package bean;

import db.JDBIConnector;
import org.jdbi.v3.core.mapper.JoinRow;
import org.jdbi.v3.core.mapper.JoinRowMapper;
import org.jdbi.v3.core.mapper.Nested;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class Category implements Serializable {
    private int categoryId;
    private int paCategoryId;
    private String name;

    private PaCategory paCategory;

    public Category() {
    }

    public Category(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPaCategoryId() {
        return paCategoryId;
    }

    public void setPaCategoryId(int paCategoryId) {
        this.paCategoryId = paCategoryId;
    }
    @Nested("pa")
    public void setPaCategory(PaCategory paCategory) {
        this.paCategory = paCategory;
    }

    @Nested("pa")
    public PaCategory getPaCategory() {
        return paCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", paCategoryId=" + paCategoryId +
                ", name='" + name + '\'' +
                ", paCategory=" + paCategory +
                '}';
    }

    public static void main(String[] args) {

        JDBIConnector.get().registerRowMapper(BeanMapper.factory(PaCategory.class, "pa"));
        List<Category> categories = JDBIConnector.get().withHandle(handle -> {
//            handle.registerRowMapper(BeanMapper.factory(Category.class, "c"));
//            handle.registerRowMapper();
//            handle.registerRowMapper(JoinRowMapper.forTypes(Category.class, PaCategory.class));
            return handle.createQuery("SELECT c.category_id,c.name,pa.pa_category_id,pa.name pname FROM category c join pa_category pa on pa.pa_category_id =c.pa_category_id WHERE category_id=2").mapToBean(Category.class).list();
        });
        System.out.println(categories);
    }


}

