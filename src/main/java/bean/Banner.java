package bean;

import java.io.Serializable;

public class Banner implements Serializable {
    private int id;
    private String name;
    private String image_src;
    private int stt;

    public Banner() {

    }

    public Banner(int id, String name, String image_src,int stt) {
        this.id = id;
        this.name = name;
        this.image_src = image_src;
        this.stt=stt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_src='" + image_src + '\'' +
                '}';
    }
}
