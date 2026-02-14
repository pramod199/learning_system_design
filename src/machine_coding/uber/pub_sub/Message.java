package machine_coding.uber.pub_sub;


public class Message {
    String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
