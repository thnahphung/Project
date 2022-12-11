package bean;

import java.io.Serializable;

public class PaCategory implements Serializable {

    private int paCategoryId;
    private String name;

    public PaCategory() {
    }

    public int getPaCategoryId() {
        return paCategoryId;
    }

    public void setPaCategoryId(int paCategoryId) {
        this.paCategoryId = paCategoryId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PaCategory(int paCategoryId, String name) {
        this.paCategoryId = paCategoryId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaCategory{" +
                "paCategoryId=" + paCategoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
