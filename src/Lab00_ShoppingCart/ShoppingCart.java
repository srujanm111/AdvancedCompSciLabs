package Lab00_ShoppingCart;

import java.util.*;

public class ShoppingCart {

    List<ItemOrder> orders;

    public ShoppingCart() {
        orders = new ArrayList<>();
    }

    void add(ItemOrder newOrder) {
        if (orders.contains(newOrder)) orders.set(orders.indexOf(newOrder), newOrder);
        else orders.add(newOrder);
    }

    double getTotal() {
        double totalCost = 0;
        for (ItemOrder order : orders) totalCost += order.getPrice();
        return totalCost;
    }
}
