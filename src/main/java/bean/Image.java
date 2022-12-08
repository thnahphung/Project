package bean;

import java.io.Serializable;

public class Image implements Serializable {
    private int imageId;
    private int productId;
    private String imageSrc;

    public Image() {
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public Image(int imageId, int productId, String imageSrc) {
        this.imageId = imageId;
        this.productId = productId;
        this.imageSrc = imageSrc;
    }
}
