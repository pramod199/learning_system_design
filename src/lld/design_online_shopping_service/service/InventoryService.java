package lld.design_online_shopping_service.service;

import lld.design_online_shopping_service.models.OrderLineItem;
import lld.design_online_shopping_service.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock; // productId, quantity

    public InventoryService() {
        this.stock = new HashMap<>();
    }

    public void addStock(Product product, int quantity) {
        stock.put(product.getId(), stock.getOrDefault(product.getId(), 0) + quantity);
    }

    public synchronized void updateStockForOrder(List<OrderLineItem> items){
        // first checking if all items are in stock
        for (OrderLineItem item : items) {
            if (stock.getOrDefault(item.getProductId(), 0) < item.getQuantity()){
                throw new RuntimeException("Not enough stock for product Id: " + item.getProductId());
            }
        }

        // If all checks pass, deduct the stock
        for (OrderLineItem item : items) {
            stock.compute(item.getProductId(), (id, currentStock) -> currentStock - item.getQuantity());
        }
    }
}
