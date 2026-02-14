package machine_coding.uber.pub_sub;

public class PrintSubscriber implements Subscriber {

    private final String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Timestamp:" + System.currentTimeMillis() +
                " Subscriber " + name +
                " received: " + message.getContent());
    }
}
