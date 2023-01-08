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

    public List<PaCategory> getListCategory() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT pa_category_id, `name`  from  pa_category").mapToBean(PaCategory.class).stream().collect(Collectors.toList());

        });
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`pa_category_id`) as numberPaCategory FROM `pa_category`").mapTo(Integer.class).one();
        });
    }

    public void addPaCategory(String name) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `pa_category` VALUES (:pa_category_id,:name)")
                    .bind("pa_category_id",nextId())
                    .bind("name", name)
                    .execute();
        });
    }

    public void editPaCategory(int id, String name) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `pa_category` SET name=? where pa_category_id=" + id + ";")
                    .bind(0, name)
                    .execute();
        });
    }

    public void deletePaCategory(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE from `pa_category` where pa_category_id=?")
                    .bind(0, id).execute();
        });
    }

    public static void main(String[] args) {
        System.out.println(getInstance().nextId());;
    }

}
