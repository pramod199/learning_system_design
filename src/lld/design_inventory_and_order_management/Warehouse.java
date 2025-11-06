package lld.design_inventory_and_order_management;



import java.util.Map;

public class Warehouse {
    Inventory inventory;

    Address address;

    public Warehouse(Inventory inventory, Address address) {
        this.inventory = inventory;
        this.address = address;
    }

    public void addProduct(Product product) {
        inventory.addProduct(product);
    }

    public void removeProduct(String productId) {
        inventory.removeProduct(productId);
    }

    public void removeItemFromInventory(Map<String, Integer> items) {

    }


}
