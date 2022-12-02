package services;

import bean.Product;
import bean.User;
import db.JDBIConnector;

import java.util.ArrayList;
import java.util.List;
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
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold  FROM product").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public Product getProductById(int id) {
        List<Product> products =  JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from product where product_id " + "=" + id).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
        if(products.size() != 1) return null;
        return products.get(0);
    }
    public List<Product> getListTopProduct(int begin, int end) {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold , image_src, rate FROM product LIMIT"+begin+","+end).mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }
    public static void main(String[] args) {
//        System.out.println(ProductService.getInstance().getProductById(1));
        System.out.println(ProductService.getInstance().getListProduct());
//        System.out.println(ProductService.getInstance().getListTopProduct());
    }
}
