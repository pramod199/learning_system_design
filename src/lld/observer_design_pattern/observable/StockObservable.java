package lld.observer_design_pattern.observable;

import lld.observer_design_pattern.observer.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscriber();

    void setStockCount(int newStockAdded);

    int getStockCount();
}
