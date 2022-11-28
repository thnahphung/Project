package bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    public static final int ORDERRECEIVED = 1;
    public static final int CANCELLED = 2;
    public static final int SHIPPING = 3;
    public static final int SUCCESSFUL = 4;
    public static final int UNSUCCESSFUL = 5;


    private int oderId;
    private int userId;
    private int total;
    private String note;
    private int stt;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;

    public Order() {
    }

    public Order(int oderId, int userId, int total, String note, int stt, LocalDateTime orderDate, LocalDateTime deliveryDate) {
        this.oderId = oderId;
        this.userId = userId;
        this.total = total;
        this.note = note;
        this.stt = stt;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
