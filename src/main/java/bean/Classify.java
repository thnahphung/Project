package bean;

import java.io.Serializable;

public class Classify implements Serializable {
    private int classifyId;
    private int productId;
    private String name;

    public int getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(int classifyId) {
        this.classifyId = classifyId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classify() {
    }

    public Classify(int classifyId, int productId, String name) {
        this.classifyId = classifyId;
        this.productId = productId;
        this.name = name;
    }
}
