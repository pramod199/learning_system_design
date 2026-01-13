/*
package lld_algomaster.design_online_shopping_service;

import java.util.HashMap;
import java.util.Map;

public class MultipleSeller {

}

class Item {
    String name;
    int quantity;
    double unitPrice;
    Seller seller;

    void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}

class ItemManager {
    Map<String, Map<String, Item>> itemMap; // itemName vs Map <sellerName, Item>

    public ItemManager() {
        itemMap = new HashMap<>();
    }

    public void addItem(Item item) {
        Seller seller = item.getSeller();
        Map<String, Item> sellerMap = itemMap.getOrDefault(item.getName(), new HashMap());
        sellerMap.put(seller.getName(), item);
        itemmap.put(item.getName(), sellerMap);
    }

    public boolean removeItem(String itemName, String sellerName) {
        if (!itemMap.containsKey(itemName)) {
            System.out.println("item not found in inventory ");
            return false;
        }
        Map<String, Item> sellerMap = itemMap.get(itemname);
        if (sellerMap.containsKey(sellerName)) {
            System.out.println("seller not found in inventory ");
            return false;
        }
        sellermap.remover(sellerName);
        return true;
    }
}

class Seller {
    String name;
    Address address;
}

class Address {
    String city;
    String state;
    String pincode;
}

class SellerManager {
    Map<String, Seller> sellerMap;

    public SellerManage() {
        sellerMap = new HashMap();
    }

    public void addSeller(Seller seller) {
        sellerMap.put(seller.getName(), seller);
    }

    public void removeSeller(String sellerName) {
        sellerMap.remove(sellerName);
    }
}

class Cart {
    Map<String, Map<String, Integer>> choosenProducts; // itemName vs sellerName vs quantity

    public Cart() {
        choosenProducts = new HashMap();
    }

    public void addItemsInCart(String itemName, String sellerName, int quantity) {
        HashMap<String, Integer> seller choosenProducts.put(itemName,
    }

    public double calculateCartPrice() {
        double totalPrice = 0.0;
        choosenProd.entry
    }

    checkout() 1.payment . 2.
    reduce quantity
}
*/


