package bean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String description;
    private String detail;
    private int rate;
    private Category category;
    private User userAdd;
    private int status;

    public Product(int id, String name, String description, String detail, int rate, Category category, User userAdd, int status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.detail = detail;
        this.rate = rate;
        this.category = category;
        this.userAdd = userAdd;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(User userAdd) {
        this.userAdd = userAdd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", detail='" + detail + '\'' +
                ", rate=" + rate +
                ", category=" + category +
                ", userAdd=" + userAdd +
                ", status=" + status +
                '}';
    }
}
