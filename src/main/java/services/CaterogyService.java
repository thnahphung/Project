package services;

import bean.Category;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

public class CaterogyService {
    private static CaterogyService instance;

    private CaterogyService() {

    }

    public static CaterogyService getInstance() {
        if (instance == null) {
            instance = new CaterogyService();
        }
        return instance;
    }

    public List<Category> getListCategory(int kind) {
        if (kind == ProductService.ALL && kind == ProductService.SALE) {
            return JDBIConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT id, name, pa_category, status  FROM category ").mapToBean(Category.class).stream().collect(Collectors.toList());
            });
        }
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT  id, name, pa_category, status  FROM category where pa_category=" + kind).mapToBean(Category.class).stream().collect(Collectors.toList());
        });
    }

    public Category getCategoryById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            Category category = handle.createQuery("SELECT id, `name`, pa_category, status FROM category WHERE id=:id").bind("id", id).mapToBean(Category.class).one();
            return category;
        });
    }

    public List<Category> getListCategoryAll() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT id, name, pa_category, status  FROM category ").mapToBean(Category.class).stream().collect(Collectors.toList());
        });
    }
    public int nextID(){
        return 1+ JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(id) as numberCategory FROM `category`").mapTo(Integer.class).one();
        });
    }
    public void addCategory(String name, int paCategory){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO category VALUES (id=?, name=?, pa_category=?,status=?)")
                    .bind(0,nextID())
                    .bind(1,name)
                    .bind(2,paCategory)
                    .bind(3,0)
                    .execute();
        });
    }
    public void editCategory(int id, int paCategory){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE category SET pa_category where id="+id+";")
                    .bind(0,paCategory)
                    .execute();
        });
    }
    public void deleteCategory(int id){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE from `category` where id=?")
                    .bind(0, id).execute();
        });
    }
}
