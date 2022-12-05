package bean;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private String productName;
    private int price;
    private int priceReal;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private String stt;
    private int quantitySold;
    private String imageSrc;

    private String decription;

    private String detail;

    private int rate;

    private String category;

    private String paCategory;

    public Product() {
    }

    public Product(int productId, int categoryId, String productName, int price, int priceReal, LocalDateTime createDate, LocalDateTime updateDate, String stt, int quantitySold, String imageSrc, String decription, String detail, int rate, String category, String paCategory) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.priceReal = priceReal;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.stt = stt;
        this.quantitySold = quantitySold;
        this.imageSrc = imageSrc;
        this.decription = decription;
        this.detail = detail;
        this.rate = rate;
        this.category = category;
        this.paCategory = paCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaCategory() {
        return paCategory;
    }

    public void setPaCategory(String paCategory) {
        this.paCategory = paCategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getPriceFormat() {

        DecimalFormat d = new DecimalFormat("#,###");
        return d.format(this.price).replace(",", ".");
    }

    public String getPriceRealFormat() {

        DecimalFormat d = new DecimalFormat("#,###");
        return d.format(this.priceReal).replace(",", ".");
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", priceReal=" + priceReal +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", stt='" + stt + '\'' +
                ", quantitySold=" + quantitySold +
                ", imageSrc='" + imageSrc + '\'' +
                ", decription='" + decription + '\'' +
                ", detail='" + detail + '\'' +
                ", rate=" + rate +
                '}';
    }

}
