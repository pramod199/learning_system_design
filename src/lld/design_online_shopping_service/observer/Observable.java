package lld.design_online_shopping_service.observer;

import lld.design_online_shopping_service.models.Order;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<OrderObserver> observers = new ArrayList<>();

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver(Order order){
        for (OrderObserver observer : observers) {
            observer.update(order);
        }
    }


}
