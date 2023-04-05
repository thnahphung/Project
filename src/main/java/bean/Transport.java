package bean;

import java.io.Serializable;

public class Transport implements Serializable {
    private int id;
    private String name;
    private int fee;
    private int time;

    public Transport(int id, String name, int fee) {
        this.id = id;
        this.name = name;
        this.fee = fee;
    }

    public Transport() {

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

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transportFee=" + fee +
                '}';
    }
}
