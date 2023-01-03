package services;

import bean.*;
import db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailService implements Serializable {
    private static OrderDetailService instance;

    private OrderDetailService() {

    }

    public static OrderDetailService getInstance() {
        if (instance == null) {
            instance = new OrderDetailService();
        }
        return instance;
    }

    public List<OrderDetail> getListOrderDetailByOrderId(int orderId) {
        return JDBIConnector.get().withHandle(handle -> {
            List<OrderDetail> result = handle.createQuery("select order_detail_id, order_id, product_id, quantity\n" +
                            "from order_detail WHERE order_id = ?;")
                    .bind(0, orderId)
                    .mapToBean(OrderDetail.class)
                    .stream()
                    .collect(Collectors.toList());
            for (OrderDetail orderDetail : result) {
                orderDetail.setProduct(ProductService.getInstance().getProductById(orderDetail.getProductId()));
            }
            return result;
        });
    }

    public int nextId() {
        try {
            return 1 + JDBIConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT MAX(`order_detail_id`) as numberOfOrderDetail FROM `order_detail`").mapTo(Integer.class).one();
            });
        } catch (Exception e) {
            return 1;
        }
    }

    public void add(OrderDetail orderDetail) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO `order_detail` VALUES (:orderDetailId,:orderId,:productId,:quantity)")
                    .bind("orderDetailId", orderDetail.getOrderDetailId())
                    .bind("orderId", orderDetail.getOrderId())
                    .bind("productId", orderDetail.getProductId())
                    .bind("quantity", orderDetail.getQuantity())
                    .execute();
        });
    }

    public void update(OrderDetail orderDetail) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `order_detail` SET order_id=:order_id, product_id=:product_id, quantity=:quantity WHERE order_detail_id=:order_detail_id")
                    .bind("order_id", orderDetail.getOrderId())
                    .bind("product_id", orderDetail.getProductId())
                    .bind("quantity", orderDetail.getQuantity())
                    .bind("order_detail_id", orderDetail.getOrderDetailId())
                    .execute();
        });
    }

    public void remove(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM order_detail WHERE order_detail_id = :id")
                    .bind("id", id)
                    .execute();
        });
    }

}