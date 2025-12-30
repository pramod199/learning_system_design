package lld_algomaster.stackoverflow.observer;

import lld_algomaster.stackoverflow.entity.Event;

import java.util.ArrayList;
import java.util.List;

// this could not be used in post as multiple inheritance not allowed

public abstract class PostSubject {
    List<PostObserver> observers = new ArrayList<>();

    public void addObserver(PostObserver observer){
        observers.add(observer);
    }

    public void removeObserver(PostObserver observer) {
        observers.remove(observer);
    }

    public void notifyObserver(Event event){
        observers.forEach(o -> o.onPostEvent(event));
    }

}
