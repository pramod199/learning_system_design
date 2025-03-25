package lld.observer_design_pattern.observer;

import lld.observer_design_pattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {

    StockObservable observable;

    String emailId;

    public EmailAlertObserverImpl(StockObservable observable, String emailId) {
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up!");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to: " + emailId);
    }
}
