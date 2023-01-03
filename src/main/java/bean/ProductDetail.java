package bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ProductDetail implements Serializable {
    private int productDetailId;
    private String decription;
    private String detail;

    List<Image> images;
    private int inventory;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private int stt;
    private int quantitySold;
    private User user;


    public ProductDetail() {
    }

    public ProductDetail(int productDetailId, String decription, String detail, List<Image> images, int inventory, LocalDateTime createDate, LocalDateTime updateDate, int stt, int quantitySold) {
        this.productDetailId = productDetailId;
        this.decription = decription;
        this.detail = detail;
        this.images = images;
        this.inventory = inventory;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.stt = stt;
        this.quantitySold = quantitySold;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
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

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
