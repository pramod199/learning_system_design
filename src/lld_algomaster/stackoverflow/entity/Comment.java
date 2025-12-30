package lld_algomaster.stackoverflow.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Comment extends Content {

    private final Comment parent;              // null if top-level
    private final List<Comment> replies = new ArrayList<>();

    public Comment(String body, User author, Comment parent) {
        super(UUID.randomUUID().toString(), body, author);
        this.parent = parent;
    }

    public boolean isTopLevel() {
        return parent == null;
    }

    public void addReply(Comment reply) {
        replies.add(reply);
    }

    public List<Comment> getReplies() {
        return Collections.unmodifiableList(replies);
    }

}
