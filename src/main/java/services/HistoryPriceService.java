package services;

import bean.HistoryPrice;
import bean.Product;
import db.JDBIConnector;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                    .bind("create_date", historyPrice.getCreateDate())
                    .bind("status", historyPrice.getStatus())
                    .execute();
        });
    }
    public List<HistoryPrice> getPriceNow(int productId){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select id, price, price_sale, product_id, create_date, status from history_price where(product_id= "+productId+") order by create_date dest limit 1").mapToBean(HistoryPrice.class).stream().collect(Collectors.toList());
        });
    }
}