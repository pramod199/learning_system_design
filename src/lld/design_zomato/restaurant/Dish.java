package lld.design_zomato.restaurant;

import java.util.List;
import java.util.ArrayList;

public class Dish {
    private String name;
    private Cuisine cuisine;  // Assuming you have an enum 'Cuisine'
    private String description;
    private double price;
    private List<String> dishImages = new ArrayList<>();
    private List<DishAddOn> addons = new ArrayList<>();

    public Dish(String name, Cuisine cuisine, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
    }

    public void addAddOn(DishAddOn addOn) {
        addons.add(addOn);
    }

    public double getPrice() {
        double totalPrice = price;
        for (DishAddOn addOn : addons) {
            totalPrice += addOn.getPrice();
        }
        return totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getDishName() {
        return name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }
}
