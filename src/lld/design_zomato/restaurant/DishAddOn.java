package lld.design_zomato.restaurant;

import java.util.List;
import java.util.ArrayList;

public class DishAddOn {
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;
    private List<String> images = new ArrayList<>();

    public DishAddOn(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    // Optional: You can add getters and setters for description, images, etc.
}
