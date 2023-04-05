package services;

import db.JDBIConnector;

public class ProductDetailService {
    private static ProductDetailService instance;

    private ProductDetailService() {

    }

    public static ProductDetailService getInstance() {
        if (instance == null) {
            instance = new ProductDetailService();
        }
        return instance;
    }


    public ProductDetail getById(int id) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_detail_id,decription,detail,inventory,create_date,update_date,stt,quantity_sold,user_id \n" +
                    "FROM product_detail WHERE product_detail_id= :id").bind("id", id).mapToBean(ProductDetail.class).one();
        });
    }

}
