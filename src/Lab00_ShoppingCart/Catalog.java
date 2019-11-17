package Lab00_ShoppingCart;

import java.util.*;

public class Catalog {

    private String name;
    private List<Item> items;

    public Catalog(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    void add(Item item) {
        items.add(item);
    }

    int size() {
        return items.size();
    }

    Item get(int index) {
        return items.get(index);
    }

    String getName() {
        return name;
    }
}
