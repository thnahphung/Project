package services;

import bean.Category;
import bean.PaCategory;
import db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Handler;
import java.util.stream.Collectors;

public class PaCategoryService implements Serializable {
    private static PaCategoryService instance;

    private PaCategoryService() {

    }

    public static PaCategoryService getInstance() {
        if (instance == null) {
            instance = new PaCategoryService();
        }
        return instance;
    }

    public PaCategory getPaCategoryById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT pa_category_id, `name` from pa_category WHERE pa_category_id = :id")
                    .bind("id", id)
                    .mapToBean(PaCategory.class).one();
        });
    }
    public List<PaCategory> getListCategory(){
        return (List<PaCategory>) JDBIConnector.get().withHandle(handle -> {
           return handle.createQuery("SELECT pa_category_id, `name`  from  pa_category").mapToBean(PaCategory.class).stream().collect(Collectors.toList());

        });
    }

    public static void main(String[] args) {
        System.out.println(PaCategoryService.getInstance().getPaCategoryById(1));
    }

}
