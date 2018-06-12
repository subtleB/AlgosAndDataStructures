package main.java.info.stochastic.designpatterns.observer;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WeakObservableObject implements Observable {

    /*
     Wrapping the objects into WeakReference
     so they will be collected by GC when there is
     no outer hard reference to them,
     but be careful with objects you want to be kept
     even with no reference (anonymous class for instance).
    */
    private List<WeakReference<Observer>> observers;

    WeakObservableObject() {
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(new WeakReference<>(observer));
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.removeIf(weakRef -> (weakRef.get() == null
                || weakRef.get().equals(observer)));
    }

    @Override
    public void notifyAllObservers() {
        Iterator<WeakReference<Observer>> iterator = observers.iterator();
        while (iterator.hasNext()) {
            WeakReference<Observer> obs = iterator.next();
            if (obs.get() == null) {
                iterator.remove();
            } else {
                obs.get().update();
            }
        }
    }
}
