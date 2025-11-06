package lld.design_inventory_and_order_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Integer, OrderItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        int productId = product.getId();
        if (items.containsKey(productId)) {
            OrderItem item = items.get(productId);
            quantity += item.getQuantity();
        }
        items.put(productId, new OrderItem(product, quantity));
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public void updateItemQuantity(int productId, int quantity) {
        OrderItem item = items.get(productId);
        if (item != null) {
            items.put(productId, new OrderItem(item.getProduct(), quantity));
        }
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public void clear() {
        items.clear();
    }


}
