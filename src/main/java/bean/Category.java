package bean;

import java.io.Serializable;

public class Category implements Serializable {
    private int categoryId;
    private int paCategoryId;
    private String name;

    public Category() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(int categoryId, int paCategoryId, String name) {
        this.categoryId = categoryId;
        this.paCategoryId = paCategoryId;
        this.name = name;
    }
}

