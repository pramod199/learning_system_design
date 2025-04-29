package lld.design_zomato.delivery;

import java.util.Map;
import java.util.HashMap;

public class DeliveryPartnerManager {
    private static DeliveryPartnerManager deliveryPartnerManagerInstance;
    private Map<String, DeliveryPartner> deliveryPartnersMap = new HashMap<>();

    private DeliveryPartnerManager() {}

    public static DeliveryPartnerManager getDeliveryPartnerManager() {
        if (deliveryPartnerManagerInstance == null) {
            synchronized (DeliveryPartnerManager.class) {
                if (deliveryPartnerManagerInstance == null) {
                    deliveryPartnerManagerInstance = new DeliveryPartnerManager();
                }
            }
        }
        return deliveryPartnerManagerInstance;
    }

    public void addDeliveryPartner(String deliveryPartnerName, DeliveryPartner deliveryPartner) {
        deliveryPartnersMap.put(deliveryPartnerName, deliveryPartner);
    }

    public DeliveryPartner getDeliveryPartner(String deliveryPartnerName) {
        return deliveryPartnersMap.get(deliveryPartnerName);
    }

    public Map<String, DeliveryPartner> getDeliveryPartnersMap() {
        return deliveryPartnersMap;
    }
}
