package lld.design_zomato.delivery_partner_matching_strategy;

import lld.design_zomato.delivery.DeliveryMetaData;
import lld.design_zomato.delivery.DeliveryPartner;

import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
    List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData);

}
