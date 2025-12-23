package lld.design_online_shopping_service.observer;

import lld.design_online_shopping_service.models.Order;


public interface OrderObserver {
    void update(Order order);
}
