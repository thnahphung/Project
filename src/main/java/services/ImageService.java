package services;

import db.JDBIConnector;

import java.util.List;

public class ImageService {
    private static ImageService instance;

    private ImageService() {

    }

    public static ImageService getInstance() {
        if (instance == null) {
            instance = new ImageService();
        }
        return instance;
    }

    public int nextId() {
        return 1 + JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT MAX(`image_id`) as numberProduct FROM `image`").mapTo(Integer.class).one();
        });
    }


    public void addListImageByIdProduct(int idProduct, List<String> srcImage) {
        for (String src : srcImage) {
            JDBIConnector.get().withHandle(handle -> {
                return handle.createUpdate("INSERT INTO image VALUES (:image_id,:product_id,:image_src)")
                        .bind("image_id", nextId())
                        .bind("product_id", idProduct)
                        .bind("image_src", src)
                        .execute();
            });
        }

    }

}
