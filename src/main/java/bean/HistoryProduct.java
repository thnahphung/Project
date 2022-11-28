package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HistoryProduct implements Serializable {
    private int historyProductId;
    private LocalDateTime updateDate;
    private int userId;
    private int productId;
    private int price;
    private int priceReal;
    private String imageSrc;
    private String decription;
    private String detail;

    public HistoryProduct() {
    }

    public int getHistoryProductId() {
        return historyProductId;
    }

    public void setHistoryProductId(int historyProductId) {
        this.historyProductId = historyProductId;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
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

    public HistoryProduct(int historyProductId, LocalDateTime updateDate, int userId, int productId, int price, int priceReal, String imageSrc, String decription, String detail) {
        this.historyProductId = historyProductId;
        this.updateDate = updateDate;
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.priceReal = priceReal;
        this.imageSrc = imageSrc;
        this.decription = decription;
        this.detail = detail;
    }
}
