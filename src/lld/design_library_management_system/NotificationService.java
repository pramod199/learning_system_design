package lld.design_library_management_system;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    List<NotificationSender> channels = new ArrayList<>();

    public NotificationService() {
        channels.add(new EmailNotification());
        channels.add(new PhoneNotification());
    }

    public void notifyUser(SystemUser user, String message) {
        for (NotificationSender sender : channels) {
            sender.sendNotification(user, message);
        }
    }

}
