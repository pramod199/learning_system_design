package lld.design_zomato.delivery_partner_matching_strategy;

import lld.design_zomato.delivery.DeliveryMetaData;
import lld.design_zomato.delivery.DeliveryPartner;
import lld.design_zomato.delivery.DeliveryPartnerManager;
import lld.design_zomato.delivery_partner_matching_strategy.IDeliveryPartnerMatchingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy {

    @Override
    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData) {
        DeliveryPartnerManager deliveryPartnerManager = DeliveryPartnerManager.getDeliveryPartnerManager();

        System.out.println("Quadtrees can be used to get nearest delivery partners, " +
                "Delivery partner manager can be used to get details of partners. " +
                "Returning all delivery partners for demo purposes for now.");

        List<DeliveryPartner> nearestDeliveryPartners = new ArrayList<>();
        for (Map.Entry<String, DeliveryPartner> entry : deliveryPartnerManager.getDeliveryPartnersMap().entrySet()) {
            nearestDeliveryPartners.add(entry.getValue());
        }
        return nearestDeliveryPartners;
    }
}
