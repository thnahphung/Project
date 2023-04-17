package bean;

import services.CartService;

import java.util.List;

public class Cart {
    public static int sumQuantity(List<LineItem> lineItems) {
        int result = 0;
        for (LineItem cartItem : lineItems) {
            result += cartItem.getQuantity();
        }
        return result;
    }

    public static int totalPrice(List<LineItem> lineItems) {
        int sum = 0;
        for (LineItem lineItem : lineItems) {
            Product product = lineItem.getProduct();
            if (product.getPriceSale() == 0)
                sum += product.getPrice() * lineItem.getQuantity();
            else
                sum += product.getPriceSale() * lineItem.getQuantity();
        }
        return sum;
    }

    public static int totalPriceSale(List<LineItem> lineItems) {
        int sum = 0;
        for (LineItem lineItem : lineItems) {
            Product product = lineItem.getProduct();
            if (product.getPriceSale() != 0)
                sum += (product.getPriceSale() - product.getPrice()) * lineItem.getQuantity();
        }
        return sum;
    }

    public static int total(List<LineItem> lineItems) {
        return totalPrice(lineItems) - totalPriceSale(lineItems);
    }

    public static int total(List<LineItem> lineItems, int discountFee) {
        return totalPrice(lineItems) - totalPriceSale(lineItems) - discountFee;
    }

    public static List<LineItem> removeItemCart(List<LineItem> lineItem, int idItemCart) {
        for (int i = 0; i < lineItem.size(); i++) {
            if (lineItem.get(i).getId() == idItemCart) {
                lineItem.remove(i);
                return lineItem;
            }
        }
        return lineItem;
    }


}
