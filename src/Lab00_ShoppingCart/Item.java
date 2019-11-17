package Lab00_ShoppingCart;

import java.util.Objects;

public class Item {

    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;

    public Item(String name, double price) {
        this(name, price, 0, 0);
    }

    public Item(String name, double price, int bulkQty, double bulkPrice) {
        if (price < 0 || bulkPrice < 0 || bulkQty < 0) throw new IllegalArgumentException("Error");
        this.name = name;
        this.price = price;
        this.bulkQty = bulkQty;
        this.bulkPrice = bulkPrice;
    }

    double priceFor(int quantity) {
        double totalPrice = 0;
        if (quantity < 0) throw new IllegalArgumentException("Error");
        if (bulkQty != 0 && quantity > bulkQty) {
            totalPrice += quantity / bulkQty * bulkPrice;
            quantity %= bulkQty;
        }
        return totalPrice + quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return name == ((Item) o).name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, bulkQty, bulkPrice);
    }

    @Override
    public String toString() {
        return name + ", $" + price + (bulkQty > 0 ? " (" + bulkQty + " for $" + bulkPrice + ")" : "");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getBulkQty() {
        return bulkQty;
    }

    public double getBulkPrice() {
        return bulkPrice;
    }
}
