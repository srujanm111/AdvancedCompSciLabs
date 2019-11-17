package Lab00_ShoppingCart;

import java.util.Objects;

public class ItemOrder {

    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public double getPrice() {
        return item.priceFor(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return item.equals(((ItemOrder) o).item);
    }

}
