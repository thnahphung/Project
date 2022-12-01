package bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private Category category;
    private String productName;
    private int price;
    private int priceReal;
    private int rate;
    private String imageSrc;

    ProductDetail productDetail;

    public Product() {
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
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


<<<<<<< HEAD

<<<<<<< HEAD
=======
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
>>>>>>> parent of 93016d7 (Le Bao Dang)

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
                '}';
    }
<<<<<<< HEAD

=======
>>>>>>> parent of 2d7ab4b (Phan Thi Quynh Nhu)
=======
>>>>>>> parent of 93016d7 (Le Bao Dang)
}
