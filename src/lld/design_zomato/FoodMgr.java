package lld.design_zomato;

import lld.design_zomato.restaurant.Dish;
import lld.design_zomato.restaurant.Restaurant;
import lld.design_zomato.restaurant.RestaurantMgr;

import java.util.Map;

public class FoodMgr {
    private static FoodMgr foodMgrInstance;

    private FoodMgr() {}

    public static FoodMgr getFoodMgr() {
        if (foodMgrInstance == null) {
            synchronized (FoodMgr.class) {
                if (foodMgrInstance == null) {
                    foodMgrInstance = new FoodMgr();
                }
            }
        }
        return foodMgrInstance;
    }

    public void prepareFood(String orderId, String restaurantId, Map<Dish, Integer> dishes) {
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        Restaurant restaurant = restaurantMgr.getRestaurant(restaurantId);
        restaurant.prepareFood(orderId, dishes);

        addRestaurantForNotificationUpdates(orderId, restaurantId);
    }

    public void addRestaurantForNotificationUpdates(String orderId, String restaurantId) {
        NotificationManager notificationMgr = NotificationManager.getNotificationMgr();
        notificationMgr.addNotificationSender(orderId, restaurantId, new PushNotificationSender());
    }
}
