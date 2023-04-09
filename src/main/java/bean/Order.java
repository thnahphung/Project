package bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private String note;
    private int total;
    private List<LineItem> listOrderItem;  // chi tiết đơn hàng
    private List<Discount> listDiscount;
    private Transport transport;
    private int statusDelivery;
    private int paymentMethod;
    private LocalDateTime deliveryDate;
    private LocalDateTime receivingDate;
    private LocalDateTime createDate;
    private boolean isPayment;
    private User user;
    private Information information;
    private int status;

    public Order(int id, String note, int total, List<LineItem> listOrderItem, List<Discount> listDiscount, Transport transport, int statusDelivery, int paymentMethod, LocalDateTime deliveryDate, LocalDateTime receivingDate, LocalDateTime createDate, boolean isPayment, User user, Information information, int status) {
        this.id = id;
        this.note = note;
        this.total = total;
        this.listOrderItem = listOrderItem;
        this.listDiscount = listDiscount;
        this.transport = transport;
        this.statusDelivery = statusDelivery;
        this.paymentMethod = paymentMethod;
        this.deliveryDate = deliveryDate;
        this.receivingDate = receivingDate;
        this.createDate = createDate;
        this.isPayment = isPayment;
        this.user = user;
        this.information = information;
        this.status = status;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Order() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<LineItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(List<LineItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }

    public List<Discount> getListDiscount() {
        return listDiscount;
    }

    public void setListDiscount(List<Discount> listDiscount) {
        this.listDiscount = listDiscount;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public int getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(int statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDateTime getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDateTime receivingDate) {
        this.receivingDate = receivingDate;
    }

    public boolean isPayment() {
        return isPayment;
    }

    public void setPayment(boolean payment) {
        isPayment = payment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int total() {
        return 0;
    }
}
