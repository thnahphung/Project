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

    public List<LineItem> getItemCartUserId(int userId) {
        List<Integer> productIds = JDBIConnector.get().withHandle(handle -> handle.createQuery("select product_id\n" +
                        "from cart_item\n" +
                        "WHERE user_id = ?\n")
                .bind(0, userId)
                .mapToBean(Integer.class).stream().collect(Collectors.toList()));
        List<Product> products = new ArrayList<>();
        for (Integer productId : productIds) {
            products.add(ProductService.getInstance().getProductById(productId));
        }
        List<LineItem> result = JDBIConnector.get().withHandle(
                handle -> handle.createQuery("select quantity\n" +
                        "from cart_item \n" +
                        "WHERE user_id = ?\n")
                .bind(0, userId)
                .mapToBean(LineItem.class).stream().collect(Collectors.toList()));
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setProduct(products.get(i));
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
}
