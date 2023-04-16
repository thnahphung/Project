package services;

import bean.Order;
import db.JDBIConnector;

import java.io.Serializable;
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
            List<Order> orders = handle.createQuery("select id, note, total, status_delivery, payment_method, devlivery_date, receiving_date, create_date, is_payment, `status` from `order` where user_id =  ?")
                    .bind(0, userId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orders) {
                int id = order.getId();
                order.setListOrderItem(LineItemService.getInstance().getListLineItemByOrderId(id));
                order.setListDiscount(DiscountService.getInstance().getListDiscountByOrderId(id));
                order.setUser(UserService.getInstance().getUserByOrderId(id));
                order.setTransport(TransportService.getInstance().getTransportByOrderId(id));
                order.setInformation(InformationService.getInstance().getInformationByOrderId(id));
            }
            return orders;
        });
    }

    public List<Order> getOrderList() {
        return JDBIConnector.get().withHandle(handle -> {
            List<Order> orderList = handle.createQuery("select id, note, total, status_delivery, payment_method, devlivery_date, receiving_date, create_date, is_payment, `status` from order where stt_delivery not like 0;").mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orderList) {
                order.setListOrderItem(LineItemService.getInstance().getListLineItemByOrderId(order.getId()));
                order.setListDiscount(DiscountService.getInstance().getListDiscountByOrderId(order.getId()));
                order.setUser(UserService.getInstance().getUserByOrderId(order.getId()));
                order.setTransport(TransportService.getInstance().getTransportByOrderId(order.getId()));
                order.setInformation(InformationService.getInstance().getInformationByOrderId(order.getId()));
            }
            return orderList;
        });
    }


    public Order getOrderByOrderId(int orderId) {
        return JDBIConnector.get().withHandle(handle -> {
            Order order = handle.createQuery("select id, note, total, status_delivery, payment_method, devlivery_date, receiving_date,is_payment, create_date, `status` from `order` where id = ?")
                    .bind(0, orderId)
                    .mapToBean(Order.class).one();
            order.setListOrderItem(LineItemService.getInstance().getListLineItemByOrderId(orderId));
            order.setListDiscount(DiscountService.getInstance().getListDiscountByOrderId(orderId));
            order.setUser(UserService.getInstance().getUserByOrderId(orderId));
            order.setTransport(TransportService.getInstance().getTransportByOrderId(orderId));
            order.setInformation(InformationService.getInstance().getInformationByOrderId(orderId));
            return order;
        });
    }


    public void add(Order order) {
        JDBIConnector.get().withHandle(handle -> handle.createUpdate("INSERT INTO `ord` VALUES (:id,:note,:total,:transport_id,:status_delivery,:payment_method,:delivery_date,:receiving_date,:is_payment,:create_date,:user_id,:infomation_id,0)")
                .bind("id", order.getId())
                .bind("note", order.getNote())
                .bind("total", order.getTotal())
                .bind("transport_id", order.getTransport().getId())
                .bind("status_delivery", order.getStatusDelivery())
                .bind("payment_method", order.getPaymentMethod())
                .bind("delivery_date", order.getDeliveryDate())
                .bind("receiving_date", order.getReceivingDate())
                .bind("is_payment", order.isPayment())
                .bind("create_date", order.getCreateDate())
                .bind("user_id", order.getUser().getId())
                .bind("information_id", order.getInformation().getId())
                .execute());
        //Them danh sach cac discount cua 1 order vao bang discount_order
        if (order.getListDiscount().size() > 0) {
            StringBuilder query = new StringBuilder();
            for (int i = 0; i < order.getListDiscount().size(); i++) {
                query.append("INSERT INTO `discount_order` VALUES (" + order.getId() + order.getListDiscount().get(i).getId() + ");");
            }
            JDBIConnector.get().withHandle(handle -> handle.createUpdate(query.toString()));
        }
        //Them danh sach cac item cua 1 order vao bang order_line
        StringBuilder query = new StringBuilder();
        for (int i = 0; i < order.getListOrderItem().size(); i++) {
            query.append("INSERT INTO `order_line` VALUES (" + order.getId() + order.getListOrderItem().get(i).getId() + ");");
        }
        JDBIConnector.get().withHandle(handle -> handle.createUpdate(query.toString()));

    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`order_id`) as numberOfOrder FROM `ord`").mapTo(Integer.class).one();
        });
    }

    public void removeAllDetailByOrderId(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM order_detail WHERE order_id = :id")
                    .bind("id", id)
                    .execute();
        });
    }

    public static void main(String[] args) {

        System.out.println(getInstance().getOrderListByUserId(5));
    }

}
