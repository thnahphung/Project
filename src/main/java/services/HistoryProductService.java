package services;

import db.JDBIConnector;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryProductService implements Serializable {
    private static HistoryProductService instance;

    private HistoryProductService() {

    }

    public static HistoryProductService getInstance() {
        if (instance == null) {
            instance = new HistoryProductService();
        }
        return instance;
    }

    public List<HistoryProduct> getListHisProductByProductId(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select history_product_id, update_date, user_id, product_id, price, price_real, image_src, decription, detail\n" +
                            "from history_product WHERE product_id = ?;")
                    .bind(0, id)
                    .mapToBean(HistoryProduct.class)
                    .stream()
                    .collect(Collectors.toList());
        });
    }

    public HistoryProduct getHistoryProductAtTheTime(int id, LocalDateTime time) {
       return JDBIConnector.get().withHandle(handle -> {
           return handle.createQuery("select history_product_id, update_date, user_id, product_id, price, price_real, image_src, decription, detail\n" +
                   "from history_product WHERE product_id = ? AND update_date <= ? ORDER BY update_date DESC limit 1;")
                   .bind(0, id)
                   .bind(1, time)
                   .mapToBean(HistoryProduct.class)
                   .one();
       });
    }

}
