package machine_coding.uber.pub_sub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class Partition {
    int id;
    List<Message> messages = Collections.synchronizedList(new ArrayList<>());
    Map<Subscriber, AtomicInteger> offsets = new ConcurrentHashMap<>();
    ExecutorService deliveryExecutor;
//    Map<Subscriber, ExecutorService> workers = new ConcurrentHashMap<>();


    public Partition(int id, ExecutorService deliveryExecutor) {
        this.id = id;
        this.deliveryExecutor = deliveryExecutor;
    }

    public void addSubscriber(Subscriber subscriber) {
        offsets.putIfAbsent(subscriber, new AtomicInteger(0));
    }

    public void removeSubscriber(Subscriber subscriber) {
        offsets.remove(subscriber);
    }

    public void addMessage(Message message) {
        messages.add(message);

        // push to subscribers
        for (Subscriber subscriber : offsets.keySet()) {
            deliveryExecutor.submit(() -> {
                try{
                    subscriber.onMessage(message);
                } catch (Exception e) {
                    System.err.println("Error delivering message to subscriber " + subscriber.getName() + ": " + e.getMessage());
                }
            });
        }
    }

}
