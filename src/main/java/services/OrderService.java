package services;

import bean.Order;
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
            List<Order> orders =  handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date\n" +
                            "from ord o\n" +
                            "WHERE user_id = ?;")
                    .bind(0, userId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for(Order order: orders){
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            }
            return orders;
        });
    }

    public  List<Order> getOderListByOrderId(int orderId){
        return JDBIConnector.get().withHandle(handle -> {
            List<Order> orders =  handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date, od.order_detail_id\n" +
                            "from ord o JOIN order_detail od on o.order_id = od.order_id where order_id = ?;")
                    .bind(0, orderId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for(Order order: orders){
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            }
            return orders;
        });
    }



}
