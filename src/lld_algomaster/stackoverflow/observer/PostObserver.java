package lld_algomaster.stackoverflow.observer;

import lld_algomaster.stackoverflow.entity.Event;

public interface PostObserver {
    void onPostEvent(Event event);
}
