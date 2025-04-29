package lld.design_zomato.delivery;


import lld.design_zomato.delivery_partner_matching_strategy.IDeliveryPartnerMatchingStrategy;
import lld.design_zomato.NotificationManager;
import lld.design_zomato.PushNotificationSender;
import lld.design_zomato.delivery_partner_matching_strategy.StrategyManager;

import java.util.List;

public class DeliveryManager {
    private static DeliveryManager deliveryManagerInstance;

    private DeliveryManager() {}

    public static DeliveryManager getDeliveryManager() {
        if (deliveryManagerInstance == null) {
            synchronized (DeliveryManager.class) {
                if (deliveryManagerInstance == null) {
                    deliveryManagerInstance = new DeliveryManager();
                }
            }
        }
        return deliveryManagerInstance;
    }

    // This function should ideally be broken down into smaller parts (Single Responsibility Principle)
    public void manageDelivery(String orderId, DeliveryMetaData deliveryMetaData) {
        StrategyManager strategyManager = StrategyManager.getStrategyManager();

        IDeliveryPartnerMatchingStrategy partnerMatchingStrategy =
                strategyManager.determineDeliveryPartnerMatchingStrategy(deliveryMetaData);

        List<DeliveryPartner> deliveryPartners =
                partnerMatchingStrategy.matchDeliveryPartners(deliveryMetaData);

        NotificationManager notificationManager = NotificationManager.getNotificationMgr();

        // Send push notifications to the nearest delivery partners
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            notificationManager.notifyParticularUser(
                    deliveryPartner.getName(),
                    "Delivery Request",
                    new PushNotificationSender()
            );
        }

        // Assume first delivery partner accepted it
        DeliveryPartner assignedDeliveryPartner = deliveryPartners.get(0);

        notificationManager.notify(
                orderId,
                "Delivery Partner " + assignedDeliveryPartner.getName() +
                        " assigned for the order " + orderId
        );

        assignedDeliveryPartner.performDelivery(orderId, deliveryMetaData);
    }
}
