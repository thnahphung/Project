package services;

import bean.HistoryPrice;
import bean.Image;
import db.JDBIConnector;

import java.util.List;
import java.util.stream.Collectors;

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

    public void addImageByIdProduct(int idProduct, String srcImage) {
        JDBIConnector.get().withHandle(handle -> {
            return handle.createUpdate("INSERT INTO image VALUES (:image_id,:product_id,:image_src)")
                    .bind("image_id", nextId())
                    .bind("product_id", idProduct)
                    .bind("image_src", srcImage)
                    .execute();
        });
    }
    public List<Image> getListImageByProductId(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select i.id, i.source from image i join product_image pi on i.id = pi.image_id WHERE pi.product_id = ?")
                    .bind(0, id)
                    .mapToBean(Image.class)
                    .stream().collect(Collectors.toList());
        });
    }

}
