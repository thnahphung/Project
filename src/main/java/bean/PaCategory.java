package bean;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.io.Serializable;

public class PaCategory implements Serializable {

    private int paCategoryId;
    private String pname;

    public PaCategory() {
    }

    public int getPaCategoryId() {
        return paCategoryId;
    }

    public void setPaCategoryId(int paCategoryId) {
        this.paCategoryId = paCategoryId;
    }

    public String getPname() {
        return pname;
    }
    @ColumnName("pname")
    public void setPname(String pname) {
        this.pname = pname;
    }
    public PaCategory(int paCategoryId, String pname) {
        this.paCategoryId = paCategoryId;
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "PaCategory{" +
                "paCategoryId=" + paCategoryId +
                ", name='" + pname + '\'' +
                '}';
    }
}
