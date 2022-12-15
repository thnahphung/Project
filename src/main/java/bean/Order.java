package bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    public static final int ORDERRECEIVED = 1;
    public static final int CANCELLED = 2;
    public static final int SHIPPING = 3;
    public static final int SUCCESSFUL = 4;
    public static final int UNSUCCESSFUL = 5;

    public static final int UNPAID = 0;
    public static final int PAID = 1;

    private int orderId;
    private int userId;
    private int total;
    private String note;
    private int sttDelivery;
    private boolean sttPay;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(int orderId, int userId, int total, String note, int sttDelivery, boolean sttPay, LocalDateTime orderDate, LocalDateTime deliveryDate, List<OrderDetail> orderDetails) {
        this.orderId = orderId;
        this.userId = userId;
        this.total = total;
        this.note = note;
        this.sttDelivery = sttDelivery;
        this.sttPay = sttPay;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public int getSttDelivery() {
        return sttDelivery;
    }

    public void setSttDelivery(int sttDelivery) {
        this.sttDelivery = sttDelivery;
    }

    public boolean getSttPay() {
        return sttPay;
    }

    public void setSttPay(boolean sttPay) {
        this.sttPay = sttPay;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;

    }

    @Override
    public String toString() {
        return "Order{" +
                "oderId=" + orderId +
                ", userId=" + userId +
                ", total=" + total +
                ", note='" + note + '\'' +
                ", sttDelivery=" + sttDelivery +
                ", sttPay=" + sttPay +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", orderDetails=" + orderDetails +
                '}';
    }


}
