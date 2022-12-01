package bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private Category category;
    private int categoryId;
    private String productName;
    private int price;
    private int priceReal;
    private int rate;
    private String imageSrc;


    private OrderDetail orderDetail;

    public Product() {
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceReal() {
        return priceReal;
    }

    public void setPriceReal(int priceReal) {
        this.priceReal = priceReal;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", category=" + category +
                ",category_id="+ categoryId+
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", priceReal=" + priceReal +
                ", rate=" + rate +
                ", imageSrc='" + imageSrc + '\'' +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
