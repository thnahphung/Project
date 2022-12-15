package services;

import bean.OrderDetail;
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
            return handle.createQuery("select order_detail_id, order_id, product_id, quantity\n" +
                            "from order_detail WHERE order_id = ?;")
                    .bind(0, orderId)
                    .mapToBean(OrderDetail.class)
                    .stream()
                    .collect(Collectors.toList());

        });
    }


}
