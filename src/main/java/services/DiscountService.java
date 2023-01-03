package services;

import bean.Discount;
import bean.OrderDetail;
import db.JDBIConnector;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountService implements Serializable {
    private static DiscountService instance;

    private DiscountService() {

    }

    public static DiscountService getInstance() {
        if (instance == null) {
            instance = new DiscountService();
        }
        return instance;
    }

    public Discount getDiscountByDiscountId(int discountId) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                            "select discount_id, `code`, discount_fee, start_date, end_date, quantity, `condition`\n" +
                                    "from discount where discount_id = ?;")
                    .bind(0, discountId)
                    .mapToBean(Discount.class)
                    .one();

        });
    }
}
