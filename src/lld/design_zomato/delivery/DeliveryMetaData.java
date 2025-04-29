package lld.design_zomato.delivery;

import lld.design_zomato.Location;

public class DeliveryMetaData {
    private Location userLoc;
    private Location restaurantLoc;
    private String orderId;

    // You can add more fields here, like weather conditions, premium customer flag, etc.

    public DeliveryMetaData(String orderId, Location userLoc, Location restaurantLoc) {
        this.orderId = orderId;
        this.userLoc = userLoc;
        this.restaurantLoc = restaurantLoc;
    }

    public Location getUserLoc() {
        return userLoc;
    }

    public Location getRestaurantLoc() {
        return restaurantLoc;
    }

    public String getOrderId() {
        return orderId;
    }
}
