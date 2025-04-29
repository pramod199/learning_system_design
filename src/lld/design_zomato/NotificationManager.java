package lld.design_zomato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//This class corresponds to subject in the observer design pattern
//NotificationSender is the observer interface
public class NotificationManager {
    private static NotificationManager notificationManagerInstance;

    private Map<String, List<Pair<String, INotificationSender>>> notificationSendersMap = new HashMap<>(); // map of orderId vs Lst<User, notificationSender?

    // Private constructor
    private NotificationManager() {
    }

    // Singleton instance getter
    public static NotificationManager getNotificationMgr() {
        if (notificationManagerInstance == null) {
            synchronized (NotificationManager.class) {
                if (notificationManagerInstance == null) {
                    notificationManagerInstance = new NotificationManager();
                }
            }
        }
        return notificationManagerInstance;
    }

    // Register observer
    public void addNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        notificationSendersMap.putIfAbsent(orderId, new ArrayList<>());
        List<Pair<String, INotificationSender>> senderList = notificationSendersMap.get(orderId);

        Pair<String, INotificationSender> newPair = new Pair<>(userId, notificationSender);
        if (!senderList.contains(newPair)) {
            senderList.add(newPair);
        }
    }

    // Unregister observer
    public void removeNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        List<Pair<String, INotificationSender>> senderList = notificationSendersMap.get(orderId);
        if (senderList != null) {
            senderList.remove(new Pair<>(userId, notificationSender));
        }
    }

    // Notify all observers for an order
    public void notify(String orderId, String message) {
        List<Pair<String, INotificationSender>> senderList = notificationSendersMap.get(orderId);
        if (senderList != null) {
            for (Pair<String, INotificationSender> sender : senderList) {
                sender.getSecond().sendNotification(sender.getFirst(), message);
            }
        }
    }

    // Notify a particular user by a particular method
    public void notifyParticularUser(String userId, String message, INotificationSender sender) {
        sender.sendNotification(userId, message);
    }

    // Simple Pair class (since Java does not have a standard one)
    static class Pair<U, V> {
        private final U first;
        private final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        public U getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }


}
