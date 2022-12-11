package services;

import bean.PaCategory;
import db.JDBIConnector;

import java.io.Serializable;
import java.util.logging.Handler;

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

    public PaCategory getCategoryById(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT pa_category_id, `name` from pa_category WHERE pa_category_id = :id").bind("id",id).mapToBean(PaCategory.class).one();
        });
    }


    public static void main(String[] args) {
        System.out.println(PaCategoryService.getInstance().getCategoryById(1));
    }

}
