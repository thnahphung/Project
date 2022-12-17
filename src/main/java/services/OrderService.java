package services;

import bean.Order;
import bean.OrderDetail;
import db.JDBIConnector;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService implements Serializable {
    private static OrderService instance;

    private OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public List<Order> getOrderListByUserId(int userId) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Order> orders = handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date\n" +
                            "from ord o\n" +
                            "WHERE user_id = ?;")
                    .bind(0, userId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orders) {
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            }
            return orders;
        });
    }

    public List<Order> getOderListByOrderId(int orderId) {
        return JDBIConnector.get().withHandle(handle -> {
            List<Order> orders = handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date, od.order_detail_id\n" +
                            "from ord o JOIN order_detail od on o.order_id = od.order_id where order_id = ?;")
                    .bind(0, orderId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orders) {
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            }
            return orders;
        });
    }

    public void add(Order order) {
        JDBIConnector.get().withHandle(handle -> {
            int num = handle.createUpdate("INSERT INTO `ord` VALUES (:order_id,:user_id,:total,:note,:stt_delivery,:stt_pay,:order_date,:delivery_date)")
                    .bind("order_id", order.getOrderId())
                    .bind("user_id", order.getUserId())
                    .bind("total", order.getTotal())
                    .bind("note", order.getNote())
                    .bind("stt_delivery", order.getSttDelivery())
                    .bind("stt_pay", order.getSttPay())
                    .bind("order_date", order.getOrderDate())
                    .bind("delivery_date", order.getDeliveryDate())
                    .execute();
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                OrderDetailService.getInstance().add(orderDetail);
            }
            return num;
        });
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`order_id`) as numberOfOrder FROM `ord`").mapTo(Integer.class).one();
        });
    }

    public Order getCartByUserId(int userId) {
        return JDBIConnector.get().withHandle(handle -> {
            Order order = null;
            try {
                order = handle.createQuery("SELECT order_id,user_id,total,note,stt_delivery,stt_pay,order_date,delivery_date FROM ord WHERE stt_delivery =0  and user_id= :user_id")
                        .bind("user_id", userId)
                        .mapToBean(Order.class).one();
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            } catch (IllegalStateException e) {
                order = new Order();
                order.setOrderId(OrderService.getInstance().nextId());
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
                order.setUserId(userId);
                OrderService.getInstance().add(order);
            }
            return order;
        });
    }

    public void removeAllDetailByOrderId(int id){
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM order_detail WHERE order_id = :id")
                    .bind("id",id)
                    .execute();
        });
    }

}
