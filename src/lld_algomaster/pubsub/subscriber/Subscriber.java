package lld_algomaster.pubsub.subscriber;

import lld_algomaster.pubsub.entities.Message;

public interface Subscriber {
    String getId();
    void onMessage(Message message);
}