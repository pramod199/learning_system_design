package lld.observer_design_pattern.observer;

import lld.observer_design_pattern.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    StockObservable observable;

    String userName;

    public MobileAlertObserverImpl(StockObservable observable, String userName) {
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "product is in stock hurry up!");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to: " +userName);
    }
}
