package lld_algomaster.design_online_shopping_service.observer;

import lld_algomaster.design_online_shopping_service.models.Order;


public interface OrderObserver {
    void update(Order order);
}
