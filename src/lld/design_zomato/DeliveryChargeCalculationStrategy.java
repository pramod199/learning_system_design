package lld.design_zomato;

import lld.design_zomato.delivery.DeliveryMetaData;

public abstract class DeliveryChargeCalculationStrategy {
    public abstract double calculateDeliveryCharge(DeliveryMetaData deliveryMetaData);
}
