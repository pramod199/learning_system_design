package lld.design_zomato;

import lld.design_zomato.delivery.DeliveryManager;
import lld.design_zomato.delivery.DeliveryMetaData;

import java.util.HashMap;
import java.util.Map;

// important and main calss.. which manage food and delivery
public class OrderManager {
    private static OrderManager orderMgrInstance;
    private Map<String, Order> ordersMap = new HashMap<>();

    private DeliveryManager deliveryManager;
    private FoodMgr foodManager;

    // Private constructor
    private OrderManager() {
        deliveryManager = DeliveryManager.getDeliveryManager();
        foodManager = FoodMgr.getFoodMgr();
    }

    // Singleton instance getter
    public static OrderManager getOrderMgr() {
       if (orderMgrInstance == null) {
            synchronized (OrderManager.class) {
                if (orderMgrInstance == null) {
                    orderMgrInstance = new OrderManager();
                }
            }
        }
        return orderMgrInstance;
    }

    // Create order (3 stages)
    public void createOrder(String orderId, Order order) {
        addUserForNotificationUpdates(orderId, order);
        manageFood(orderId, order);
        manageDelivery(orderId, order);
        ordersMap.put(orderId, order);
    }

    public Order getOrder(String orderId) {
        return ordersMap.get(orderId);
    }

    // Helper methods
    private void addUserForNotificationUpdates(String orderId, Order order) {
        NotificationManager notificationManager = NotificationManager.getNotificationMgr();
        notificationManager.addNotificationSender(orderId, order.getUserId(), new PushNotificationSender());
        // Ideally, notification preferences should belong to user, not handled here.
    }

    private void manageDelivery(String orderId, Order order) {
        DeliveryMetaData metaData = new DeliveryMetaData(orderId, order.getUserLocation(), order.getRestaurantLocation());
        deliveryManager.manageDelivery(orderId, metaData);
    }

    private void manageFood(String orderId, Order order) {
        foodManager.prepareFood(orderId, order.getRestaurantId(), order.getDishes());
    }
}
