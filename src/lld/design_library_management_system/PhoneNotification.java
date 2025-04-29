package lld.design_library_management_system;

public class PhoneNotification implements NotificationSender {
    @Override
    public void sendNotification(SystemUser user, String message) {
        System.out.println("Sending phone notification to " + user.getName() + ": " + message);
    }
}
