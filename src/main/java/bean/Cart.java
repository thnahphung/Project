package bean;

import java.util.List;

public class Cart {
    public static int sumQuantity(List<LineItem> lineItems) {
        int sum = 0;
        for (LineItem lineItem : lineItems) {
            sum += lineItem.getQuantity();
        }
        return sum;
    }

    public static int totalPrice(List<LineItem> lineItems) {
        int sum = 0;
        for (LineItem lineItem : lineItems) {
            sum += lineItem.getProduct().getListHistoryPrice().get(0).getPrice() * lineItem.getQuantity();
        }
        return sum;
    }

    public static int totalPriceSale(List<LineItem> lineItems) {
        int sum = 0;
        for (LineItem lineItem : lineItems) {
            HistoryPrice price = lineItem.getProduct().getListHistoryPrice().get(0);
            sum += (price.getPrice() - price.getPriceSale()) * lineItem.getQuantity();
        }
        return sum;
    }

    public static int total(List<LineItem> lineItems) {
        return totalPrice(lineItems) - totalPriceSale(lineItems);
    }

    public static int total(List<LineItem> lineItems, int sumDiscount) {
        return totalPrice(lineItems) - totalPriceSale(lineItems) - sumDiscount;
    }

    public static List<LineItem> removeItemCart(List<LineItem> lineItem, Product product) {
        for (int i = 0; i < lineItem.size(); i++) {
            if (lineItem.get(i).getProduct().equals(product)) {
                lineItem.remove(i);
                return lineItem;
            }
        }
        return lineItem;
    }


}
