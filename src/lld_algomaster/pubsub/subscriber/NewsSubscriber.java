package lld_algomaster.pubsub.subscriber;

import lld_algomaster.pubsub.entities.Message;

public class NewsSubscriber implements Subscriber {
    private final String id;

    public NewsSubscriber(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.printf("[Subscriber %s] received message '%s'%n", id, message.getPayload());
    }
}