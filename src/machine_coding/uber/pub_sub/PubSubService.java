package machine_coding.uber.pub_sub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PubSubService {
    private static final PubSubService INSTANCE = new PubSubService();
    private final ExecutorService deliveryExecutor;
    private final Map<String, Topic> topicRegistry;

    private PubSubService() {
        this.topicRegistry = new ConcurrentHashMap<>();
        // A cached thread pool is suitable for handling many short-lived, bursty tasks (message deliveries).
        deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance() {
        return INSTANCE;
    }

    public void createTopic(String topicName, int partitionCount) {
        topicRegistry.putIfAbsent(topicName, new Topic(topicName, partitionCount, deliveryExecutor));
        System.out.println("Topic " + topicName + " created with partition count " + partitionCount);
    }

    public void subscribe(String topicName, Subscriber subscriber){
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) {
            throw new IllegalArgumentException("TOpic not found" + topicName);
        }

        for (Partition partition : topic.getPartitions()) {
            partition.addSubscriber(subscriber);
        }
    }

    public void unsubscribe(String topicName, Subscriber subscriber){
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) {
            throw new IllegalArgumentException("Topic not found" + topicName);
        }

        for (Partition partition : topic.getPartitions()) {
            partition.removeSubscriber(subscriber);
        }
    }

    public void publish(Publisher publisher, String topicName, String content) {
        Topic topic = topicRegistry.get(topicName);
        if (topic == null) {
            throw new IllegalArgumentException("Topic not found" + topicName);
        }
        publisher.publish(topic, content);
    }




}
