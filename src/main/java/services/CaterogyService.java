package services;

import bean.Category;
import bean.Product;
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
                return handle.createQuery("SELECT category_id, pa_category_id, name  FROM category ").mapToBean(Category.class).stream().collect(Collectors.toList());
            });
        }
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT category_id, pa_category_id, name  FROM category where pa_category_id=" + kind).mapToBean(Category.class).stream().collect(Collectors.toList());
        });
    }

    public Category getCategoryById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            Category category = handle.createQuery("SELECT category_id, `name`, pa_category_id FROM category WHERE category_id=:id").bind("id", id).mapToBean(Category.class).one();
            category.setPaCategory(PaCategoryService.getInstance().getPaCategoryById(category.getPaCategoryId()));
            return category;
        });
    }
}
