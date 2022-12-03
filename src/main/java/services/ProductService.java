package services;

import bean.Product;
import bean.User;
import db.JDBIConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;
import java.util.stream.Collectors;

public class ProductService {
    private static ProductService instance;

    private ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public List<Product> getListProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold , image_src,decription,detail, rate  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public Product getProductById(int id) {
        List<Product> products = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold , image_src,decription,detail, rate from product where product_id " + "=" + id).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        if (products.size() != 1) return null;
        return products.get(0);
    }

    public List<Product> getListTopProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold , image_src, decription, detail, rate FROM product LIMIT 0,15").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<Product> getListFavouriteProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src,decription,detail, rate from product ORDER BY price DESC limit 3").mapToBean(Product.class).stream().collect(Collectors.toList());
        });

    }

    public List<String> getImageOfProductById(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select image_src from image where product_id " + "=" + id).mapTo(String.class).stream().collect(Collectors.toList());
        });
    }

//    public Map<Integer,List<String>> getCommentOfProductById(int id){
//       JDBIConnector.get().
//    }

    public static void main(String[] args) {
//        System.out.println(ProductService.getInstance().getProductById(1));
//        System.out.println(ProductService.getInstance().getListProduct());
//        System.out.println(ProductService.getInstance().getListTopProduct());

//        System.out.println(ProductService.getInstance().getProductById(1));

//        System.out.println(ProductService.getInstance().getListFavouriteProduct());
//        System.out.println(ProductService.getInstance().getImageOfProductById(1));
    }


}
