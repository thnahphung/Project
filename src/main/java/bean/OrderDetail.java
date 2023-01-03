package bean;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private Product product;
    private int quantity;
    private int discountId;
    private Discount discount;

    public OrderDetail() {
    }

    public OrderDetail(int orderDetailId, int orderId, int productId, Product product, int quantity, int discountId, Discount discount) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
        this.discountId = discountId;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", discountId=" + discountId +
                ", discount=" + discount +
                '}';
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public int total() {
        return product.getPrice() * quantity;
    }

    public int totalSale() {
        return product.getPriceReal() * quantity;
    }

}
