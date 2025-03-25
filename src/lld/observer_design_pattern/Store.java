package lld.observer_design_pattern;

import lld.observer_design_pattern.observable.IphoneObservableImpl;
import lld.observer_design_pattern.observable.StockObservable;
import lld.observer_design_pattern.observer.EmailAlertObserverImpl;
import lld.observer_design_pattern.observer.MobileAlertObserverImpl;
import lld.observer_design_pattern.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl(iphoneObservable, "abc@gmail.com");
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl(iphoneObservable, "abc@gmail.com");
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl(iphoneObservable, "xyz_user");

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setStockCount(10);
    }
}
