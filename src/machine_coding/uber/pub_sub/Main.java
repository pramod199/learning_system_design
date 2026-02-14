package machine_coding.uber.pub_sub;

public class Main {
    // single queue pubsub system:
//    https://chatgpt.com/share/6990423a-384c-8008-942f-e9d3968f47df
//    https://codezym.com/question/33
    // https://medium.com/@choudharys710/lld-machine-coding-with-implementation-messaging-queue-1fe1162b55aa

    public static void main(String[] args) {
        PubSubService pubSubService = PubSubService.getInstance();

        Publisher publisherA = new Publisher("A");
        Publisher publisherB = new Publisher("B");

        Subscriber subscriber1 = new PrintSubscriber("1");
        Subscriber subscriber2 = new PrintSubscriber("2");

        pubSubService.createTopic("sports1", 2);
        pubSubService.createTopic("sports2", 2);

        pubSubService.subscribe("sports1", subscriber1);




    }
}
