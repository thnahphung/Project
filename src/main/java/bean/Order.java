package bean;

import services.OrderDetailService;
import services.OrderService;
import services.ProductService;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public int total() {
        int total = 0;
        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.total();
        }
        return total;
    }

    public int totalReal() {
        int total = 0;
        for (OrderDetail orderDetail : orderDetails) {
            total += Math.max(orderDetail.total(), orderDetail.totalSale());
        }
        return total;
    }

    public int amount() {
        int amount = 0;
        for (OrderDetail orderDetail : orderDetails) {
            amount += orderDetail.getQuantity();
        }
        return amount;
    }

    public boolean contain(int idProduct) {
        for (OrderDetail orderDetail : orderDetails) {
            if (orderDetail.getProduct().getProductId() == idProduct)
                return true;
        }
        return false;
    }

    public OrderDetail getOderDetail(int idProduct) {
        for (OrderDetail orderDetail : orderDetails) {
            if (orderDetail.getProduct().getProductId() == idProduct)
                return orderDetail;
        }
        return null;
    }

    public OrderDetail getOderDetailByIdDetail(int idDetail) {
        for (OrderDetail orderDetail : orderDetails) {
            if (orderDetail.getOrderDetailId() == idDetail)
                return orderDetail;
        }
        return null;
    }

    public void addProduct(int idProduct, int amount) {
        OrderDetail orderDetail;
        if (contain(idProduct)) {
            orderDetail = getOderDetail(idProduct);
            orderDetail.setQuantity(orderDetail.getQuantity() + amount);
            OrderDetailService.getInstance().update(orderDetail);
        } else {
            orderDetail = new OrderDetail();
            orderDetail.setOrderDetailId(OrderDetailService.getInstance().nextId());
            orderDetail.setOrderId(this.getOrderId());
            orderDetail.setProductId(idProduct);
            orderDetail.setProduct(ProductService.getInstance().getProductById(idProduct));
            orderDetail.setQuantity(amount);
            OrderDetailService.getInstance().add(orderDetail);
            orderDetails.add(orderDetail);
        }
    }

    public void removeDetail(int id) {
        orderDetails.remove(getOderDetailByIdDetail(id));
        OrderDetailService.getInstance().remove(id);
    }

    public void removeAll() {
        OrderService.getInstance().removeAllDetailByOrderId(this.orderId);
        orderDetails.clear();
    }


}
