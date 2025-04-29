package lld.design_zomato.restaurant;

import java.util.HashMap;
import java.util.Map;

public class RestaurantMgr {
    private static RestaurantMgr restaurantMgrInstance;
    private Map<String, Restaurant> restaurantsMap = new HashMap<>();

    private RestaurantMgr() {}

    public static RestaurantMgr getRestaurantMgr() {
        if (restaurantMgrInstance == null) {
            synchronized (RestaurantMgr.class) {
                if (restaurantMgrInstance == null) {
                    restaurantMgrInstance = new RestaurantMgr();
                }
            }
        }
        return restaurantMgrInstance;
    }

    public void addRestaurant(String restaurantName, Restaurant restaurant) {
        restaurantsMap.put(restaurantName, restaurant);
    }

    public Restaurant getRestaurant(String restaurantName) {
        return restaurantsMap.get(restaurantName);
    }
}
