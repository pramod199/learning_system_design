package lld.design_zomato.delivery;

import lld.design_zomato.IPartner;
import lld.design_zomato.NotificationManager;

import java.util.concurrent.TimeUnit;

public class DeliveryPartner extends IPartner {

    public DeliveryPartner(String name) {
        super(name);
    }

    // Simulates performing a delivery with notifications
    public void performDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        NotificationManager notificationManager = NotificationManager.getNotificationMgr();

        double restaurantLat = deliveryMetaData.getRestaurantLoc().getLatitude();
        double restaurantLong = deliveryMetaData.getRestaurantLoc().getLongitude();

        notificationManager.notify(orderId, name + " going to pick up delivery from location " + restaurantLat + "," + restaurantLong);
        sleep(5);

        notificationManager.notify(orderId, name + " picked up delivery!");
        sleep(5);

        notificationManager.notify(orderId, name + " on the way to deliver!");
        sleep(5);

        double userLat = deliveryMetaData.getUserLoc().getLatitude();
        double userLong = deliveryMetaData.getUserLoc().getLongitude();

        notificationManager.notify(orderId, name + " reached the location " + userLat + "," + userLong);
        sleep(5);

        notificationManager.notify(orderId, name + " delivered the order. CONGRATULATIONS!!");
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
