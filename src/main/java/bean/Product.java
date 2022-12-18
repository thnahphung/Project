package bean;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private Category category;
    private  int categoryId;
    private String productName;
    private int price;
    private int priceReal;
    private int rate;
    private String imageSrc;

    private ProductDetail productDetail;

    public Product() {
    }

    public Product(int productId, int categoryId, String productName, int price, int priceReal, int rate, String imageSrc,ProductDetail productDetail) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.price = price;
        this.priceReal = priceReal;
        this.rate = rate;
        this.imageSrc = imageSrc;
        this.productDetail=productDetail;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", category=" + category +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", priceReal=" + priceReal +
                ", rate=" + rate +
                ", imageSrc='" + imageSrc + '\'' +
                ", productDetail=" + productDetail +
                '}';
    }


}
