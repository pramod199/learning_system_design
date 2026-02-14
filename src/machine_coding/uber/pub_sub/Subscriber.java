package machine_coding.uber.pub_sub;

public interface Subscriber {
    String getName();
    void onMessage(Message message);
}
