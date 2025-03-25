package memento;

public class EditorState {
    private final String content; // final so state won't change

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
