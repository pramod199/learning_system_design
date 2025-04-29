package lld.design_zomato;

public class PushNotificationSender implements INotificationSender {
    @Override
    public void sendNotification(String userId, String msg) {
        System.out.println("Push Notification for " + userId + " is " + msg);
    }
}
