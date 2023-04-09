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
            List<Order> orders = handle.createQuery("select order_id, user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date,o.address_id, o.transport_id, o.discount_id,o.payments\n" +
                            "from ord\n" +
                            "WHERE user_id = ? and stt_delivery not like 0\n" +
                            "ORDER BY order_date ASC;")
                    .bind(0, userId)
                    .mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orders) {
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
                order.setAddress(AddressService.getInstance().getAddressByAddressId(order.getAddressId()));
                order.setTransport(TransportService.getInstance().getTransportById(order.getTransportId()));
            }
            return orders;
        });
    }

    public List<Order> getOrderList() {
        return JDBIConnector.get().withHandle(handle -> {
            List<Order> orderList = handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date,o.address_id from ord o where stt_delivery not like 0;").mapToBean(Order.class).stream().collect(Collectors.toList());
            for (Order order : orderList) {
                order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
                order.setAddress(AddressService.getInstance().getAddressByAddressId(order.getAddressId()));

            }
            return orderList;
        });
    }


    public Order getOrderByOrderId(int orderId) {
        return JDBIConnector.get().withHandle(handle -> {
            Order order = handle.createQuery("select o.order_id, o.user_id, o.total, o.note, o.stt_delivery, o.stt_pay, o.order_date, o.delivery_date,o.address_id,o.transport_id, o.discount_id,o.payments\n" +
                            "                            from ord o  where o.order_id = ?;")
                    .bind(0, orderId)
                    .mapToBean(Order.class).one();

            order.setOrderDetails(OrderDetailService.getInstance().getListOrderDetailByOrderId(order.getOrderId()));
            order.setAddress(AddressService.getInstance().getAddressByAddressId(order.getAddressId()));
            order.setDiscount(DiscountService.getInstance().getDiscountByDiscountId(order.getDiscountId()));
            order.setTransport(TransportService.getInstance().getTransportById(order.getTransportId()));
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

    public void cartToOrder(Order order) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("UPDATE `ord` SET note=:note,total=:total,stt_delivery=:stt_delivery,stt_pay=:stt_pay," +
                            "order_date=:order_date,delivery_date=:delivery_date,address_id=:address_id,transport_id=:transport_id," +
                            "discount_id=:discount_id,payments=:payments WHERE order_id=:order_id")
                    .bind("order_id", order.getOrderId())
                    .bind("total", order.getTotal())
                    .bind("note", order.getNote())
                    .bind("stt_delivery", order.getSttDelivery())
                    .bind("stt_pay", order.isSttPay())
                    .bind("order_date", order.getOrderDate())
                    .bind("delivery_date", order.getDeliveryDate())
                    .bind("address_id", order.getAddressId())
                    .bind("transport_id", order.getTransportId())
                    .bind("discount_id", order.getDiscountId())
                    .bind("payments", order.getPayments())
                    .execute();
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
                order = handle.createQuery("SELECT order_id,user_id,total FROM ord WHERE stt_delivery =0  and user_id= :user_id")
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

    public void removeAllDetailByOrderId(int id) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("DELETE FROM order_detail WHERE order_id = :id")
                    .bind("id", id)
                    .execute();
        });
    }

    public static void main(String[] args) {
//        System.out.println(getInstance().getOrderListByUserId(3));
        System.out.println(getInstance().getOrderByOrderId(1));
    }

}
