package listProduct;

import java.time.format.DateTimeFormatter;

public class Product {
    private int product_id;
    private int category_id;
    private String name;
    private int price;
    private int price_real;
    private int rate;
    private String image_src;
    private String decription;
    private String detail;
    private int inventory;
    private DateTimeFormatter crate_date;
    private DateTimeFormatter update_date;
    private int status;
    private int quantity_sold;
    private boolean seen;

    public Product(int product_id, int category_id, String name, int price, int price_real, int rate, String image_src, String decription, String detail, int inventory, DateTimeFormatter crate_date, DateTimeFormatter update_date, int status, int quantity_sold, boolean seen) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.price_real = price_real;
        this.rate = rate;
        this.image_src = image_src;
        this.decription = decription;
        this.detail = detail;
        this.inventory = inventory;
        this.crate_date = crate_date;
        this.update_date = update_date;
        this.status = status;
        this.quantity_sold = quantity_sold;
        this.seen = seen;
    }

    public Product(String name, int price, int price_real, int rate, String image_src, int status) {
        this.name = name;
        this.price = price;
        this.price_real = price_real;
        this.rate = rate;
        this.image_src = image_src;
        this.status = status;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice_real() {
        return price_real;
    }

    public void setPrice_real(int price_real) {
        this.price_real = price_real;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public DateTimeFormatter getCrate_date() {
        return crate_date;
    }

    public void setCrate_date(DateTimeFormatter crate_date) {
        this.crate_date = crate_date;
    }

    public DateTimeFormatter getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(DateTimeFormatter update_date) {
        this.update_date = update_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
}
