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
        List<LineItem> result = JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select quantity\n" +
                            "from cart_item \n" +
                            "WHERE user_id = ?\n")
                    .bind(0, userId)
                    .mapToBean(LineItem.class).stream().collect(Collectors.toList());
        });
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setProduct(products.get(i));
        }
        return result;
    }
}
