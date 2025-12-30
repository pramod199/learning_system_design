package lld_algomaster.stackoverflow.entity;

import lld_algomaster.stackoverflow.enums.EventType;
import lld_algomaster.stackoverflow.enums.VoteType;
import lld_algomaster.stackoverflow.observer.PostObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Post extends Content {

    private final AtomicInteger voteCount = new AtomicInteger(0);

    private final Map<String, VoteType> voters = new ConcurrentHashMap<>();

    private final List<Comment> comments = new ArrayList<>(); // store only top-level comments.
    private List<PostObserver> observers = new ArrayList<>();

    public Post(String id, String body, User author) {
        super(id, body, author);
    }

    // observer
    public void addObserver(PostObserver observer){
        observers.add(observer);
    }

    public void removeObserver(PostObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Event event){
        observers.forEach(o -> o.onPostEvent(event));
    }

    public synchronized void vote(User user, VoteType voteType) {
        String userId = user.getId();
        if (voters.get(userId) == voteType) {
            return; // Already voted
        }
        int scoreChange = 0;
        if (voters.containsKey(userId)) { // User is changing their vote
            scoreChange = (voteType == VoteType.UPVOTE) ? 2 : -2;
        } else { // New vote
            scoreChange = (voteType == VoteType.UPVOTE) ? 1 : -1;
        }

        voters.put(userId, voteType);
        voteCount.addAndGet(scoreChange);

        EventType eventType = EventType.UPVOTE_QUESTION;

        if (this instanceof Question) {
            eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION);
        } else {
            eventType = (voteType == VoteType.UPVOTE ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER);
        }

        notifyObservers(new Event(eventType, user, this));
    }

    public void addComment(Comment comment) {
        if (!comment.isTopLevel()) {
            throw new IllegalArgumentException("Only top-level comments allowed here");
        }
        comments.add(comment);
    }

    /*
    Replies are added like this:

Comment c1 = new Comment("Nice question", user1, null);
post.addComment(c1);

Comment reply = new Comment("Thanks!", user2, c1);
c1.addReply(reply);

     */
}
