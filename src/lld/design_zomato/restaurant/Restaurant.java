package lld.design_zomato.restaurant;

import lld.design_zomato.Location;
import lld.design_zomato.NotificationManager;
import lld.design_zomato.RestaurantOwner;

import java.util.Map;

public class Restaurant {
    private String name;
    private boolean isAvail;
    private Location location;
    private Menu menu;
    private RestaurantOwner owner;

    public Restaurant(String name, RestaurantOwner owner, Location location) {
        this.name = name;
        this.owner = owner;
        this.location = location;
        this.isAvail = false;
        this.menu = null;
    }

    public void addMenu(Menu menu) {
        this.menu = menu;
    }

    public String getId() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean prepareFood(String orderId, Map<Dish, Integer> dishes) {
        System.out.println("Restaurant accepting the order and starting to prepare it");

        NotificationManager notificationMgr = NotificationManager.getNotificationMgr();
        notificationMgr.notify(orderId, "Food is being prepared in restaurant");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        notificationMgr.notify(orderId, "Food is ready and can be picked up from restaurant");
        return true;
    }
}
