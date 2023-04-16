package services;

import bean.LineItem;
import bean.Order;
import bean.Product;
import db.JDBIConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {
    private static CartService instance;

    private CartService() {

    }

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public void addCartItem(int userId, LineItem lineItem) {
        JDBIConnector.get().withHandle(
                handle -> handle.createUpdate("INSERT INTO cart_item VALUES (:user_id, :product_id, :quantity);")
                        .bind("user_id", userId)
                        .bind("product_id", lineItem.getProduct().getId())
                        .bind("quantity", lineItem.getQuantity())
                        .execute());

    }

    public List<LineItem> getCartOfUser(int userId) {
        List<LineItem> result = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select id, quantity from cart_item  WHERE user_id = ?")
                    .bind(0, userId)
                    .mapToBean(LineItem.class).stream().collect(Collectors.toList());
        });
        for(LineItem l : result){
            l.setProduct(ProductService.getInstance().getProductByCartItemId(l.getId()));
        }
        return result;
    }

    public void removeAllProductByUserId(int userId) {
        JDBIConnector.get().withHandle(
                handle -> handle.createUpdate("DELETE FROM cart_item WHERE user_id = :user_id;")
                        .bind("user_id", userId)
                        .execute()
        );
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getCartOfUser(5));
    }
}
