package lld.design_inventory_and_order_management;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    Address address;

    Cart cart;

    List<Integer> orderIds;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        orderIds = new ArrayList<>();
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public Address getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }
}
