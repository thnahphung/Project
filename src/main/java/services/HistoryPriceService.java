package services;

import bean.HistoryPrice;
import db.JDBIConnector;

import java.time.LocalDateTime;

public class HistoryPriceService {
    private static HistoryPriceService instance;

    private HistoryPriceService() {

    }

    public static HistoryPriceService getInstance() {
        if (instance == null) {
            instance = new HistoryPriceService();
        }
        return instance;
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("Select max('id') as maxNumber from history_price").mapTo(Integer.class).one();
        });
    }

    public void addHistoryPriceByIdProduct(int idProduct, HistoryPrice historyPrice) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO image VALUES (:id,:price,:price_sale,:product_id,:create_date,:status)")
                    .bind("image_id", nextId())
                    .bind("price", historyPrice.getPrice())
                    .bind("price_sale", historyPrice.getPriceSale())
                    .bind("product_id", idProduct)
                    .bind("create_date", LocalDateTime.now())
                    .bind("status", historyPrice.getStatus())
                    .execute();
        });
    }
}