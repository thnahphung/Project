package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Transport implements Serializable {
    private int id;
    private int fee;
    private int time;
    private String idShipping;
    private LocalDateTime createDate;

    public Transport(int id, int fee, String idShipping, LocalDateTime createDate) {
        this.id = id;
        this.fee = fee;
        this.idShipping = idShipping;
        this.createDate = createDate;
    }

    public Transport() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdShipping() {
        return idShipping;
    }

    public void setIdShipping(String idShipping) {
        this.idShipping = idShipping;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", transportFee=" + fee +
                '}';
    }
}
