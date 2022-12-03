package services;

import bean.Comment;
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

    public List<Product> getListTopProduct(String kind) {
      switch (kind){
          case "all": return JDBIConnector.get().withHandle(handle -> {
                return handle.createQuery("SELECT product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold , image_src, decription, detail, rate FROM product   LIMIT 0,15").mapToBean(Product.class).stream().collect(Collectors.toList());
            });
          case "wood": return JDBIConnector.get().withHandle(handle -> {
              return handle.createQuery("SELECT pro.product_id, pro.category_id, pro.product_name, pro.price, pro.price_real, pro.create_date, pro.update_date, pro.stt, pro.quantity_sold, pro.image_src, pro.rate FROM product pro join category ca on pro.category_id = ca.category_id join pa_category pa on pa.pa_category_id = ca.pa_category_id WHERE pa.pa_category_id=1 LIMIT 0,15").mapToBean(Product.class).stream().collect(Collectors.toList());
          });
          case "ceramic" : return JDBIConnector.get().withHandle(handle -> {
              return handle.createQuery("SELECT pro.product_id, pro.category_id, pro.product_name, pro.price, pro.price_real, pro.create_date, pro.update_date, pro.stt, pro.quantity_sold, pro.image_src, pro.rate FROM product pro join category ca on pro.category_id = ca.category_id join pa_category pa on pa.pa_category_id = ca.pa_category_id WHERE pa.pa_category_id=2 LIMIT 0,15").mapToBean(Product.class).stream().collect(Collectors.toList());
          });
    }
    return null;
    }

    public List<Product> getListFavouriteProduct() {
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src,decription,detail, rate from product ORDER BY price DESC limit 3").mapToBean(Product.class).stream().collect(Collectors.toList());
        });

    }

    public List<Product> getListWoodProduct(){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "WHERE category_id = 1;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public List<String> getImageOfProductById(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select image_src from image where product_id " + "=" + id).mapTo(String.class).stream().collect(Collectors.toList());
        });
    }
    public int countProduct(){
        return ProductService.getInstance().getListProduct().size();
    }

    public List<Comment> getCommentOfProductById(int id){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("SELECT cmt.comment_id, cmt.rate,cmt.document,u.user_id,u.full_name,u.avatar from `comment` cmt join `user` u on cmt.user_id= u.user_id WHERE cmt.product_id = "+id).mapToBean(Comment.class).stream().collect(Collectors.toList());
        });
    }


    public List<Product> getNewProducts(){
        return  JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select product_id, category_id, product_name, price, price_real, create_date, update_date, stt, quantity_sold, image_src, rate\n" +
                    "FROM product\n" +
                    "ORDER BY create_date DESC limit 6;").mapToBean(Product.class).stream().collect(Collectors.toList());
        });
    }

    public static void main(String[] args) {
//        System.out.println(ProductService.getInstance().getProductById(1));
//        System.out.println(ProductService.getInstance().getListProduct());
//        System.out.println(ProductService.getInstance().getListTopProduct());

//        System.out.println(ProductService.getInstance().getProductById(1));

//        System.out.println(ProductService.getInstance().getListFavouriteProduct());
//        System.out.println(ProductService.getInstance().getImageOfProductById(1));

//        System.out.println(ProductService.getInstance().getNewProducts());
        System.out.println(ProductService.getInstance().getCommentOfProductById(1));
    }


}
