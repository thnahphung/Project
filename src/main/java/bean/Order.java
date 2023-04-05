package bean;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private String note;
    private int total;
    private List<LineItem> listOrderItem;
    private List<Discount> listDiscount;
    private Transport transport;
    private int statusDelivery;
    private int paymentMethod;
    private LocalDateTime deliveryDate;
    private LocalDateTime receivingDate;
    private boolean isPayment;
    private int status;

    public Order(int id, String note, int total, List<LineItem> listOrderItem, List<Discount> listDiscount, Transport transport, int statusDelivery, int paymentMethod, LocalDateTime deliveryDate, LocalDateTime receivingDate, boolean isPayment, int status) {
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
        this.isPayment = isPayment;
        this.status = status;
    }

    public Order() {
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

}
