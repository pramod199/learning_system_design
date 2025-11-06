package lld.design_inventory_and_order_management;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void removeProduct(String productId) {
        products.remove(productId);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public Map<Integer, Product> getAllProducts() {
        return products;
    }
}
