package bean;

import java.io.Serializable;

public class Transport implements Serializable {
    private int id;
    private String name;
    private int transportFee;

    public Transport(int id, String name, int transportFee) {
        this.id = id;
        this.name = name;
        this.transportFee = transportFee;
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

    public int getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(int transportFee) {
        this.transportFee = transportFee;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transportFee=" + transportFee +
                '}';
    }
}
