package lld.design_library_management_system;

public class EmailNotification implements NotificationSender {
    public void sendNotification(SystemUser user, String message) {
        System.out.println("Email sent to " + user.getEmail() + ": " + message);
    }
}
