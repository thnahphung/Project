package services;

import bean.Discount;
import db.JDBIConnector;

import java.io.Serializable;

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
        if (discountId == 0) return null;
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery(
                            "select discount_id, `code`, discount_fee, start_date, end_date, quantity, `condition`\n" +
                                    "from discount where discount_id = ?;")
                    .bind(0, discountId)
                    .mapToBean(Discount.class)
                    .one();

        });
    }

    public Discount getDiscountByCode(String code) {
        return JDBIConnector.get().withHandle(handle -> {
            try {
                return handle.createQuery(
                                "select discount_id, `code`, discount_fee, start_date, end_date, quantity, `condition`\n" +
                                        "from discount where code = :code;")
                        .bind("code", code)
                        .mapToBean(Discount.class)
                        .one();
            } catch (Exception e) {
                return null;
            }
        });
    }
}
