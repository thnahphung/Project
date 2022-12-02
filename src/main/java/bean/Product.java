package bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private int categoryId;
    private String productName;
    private int price;
    private int priceReal;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String stt;
    private int quantitySold;
    private String imageSrc;
    private int rate;


    public Product() {
    }

    public Product(int productId, int categoryId, String productName, int price, int priceReal, LocalDateTime createDate, LocalDateTime updateDate, String stt, int quantitySold, String imageSrc, int rate) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.price = price;
        this.priceReal = priceReal;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.stt = stt;
        this.quantitySold = quantitySold;
        this.imageSrc=imageSrc;
        this.rate = rate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
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
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", priceReal=" + priceReal +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", stt='" + stt + '\'' +
                ", quantitySold=" + quantitySold +
                '}';
    }
}
