package main.java.info.stochastic.designpatterns.observer;

import java.util.LinkedList;
import java.util.List;

public class ObservableObject implements Observable {

    /*
     Keeping hard references so you must not forget
     to unregister Observer if you no longer need it
     otherwise there will be a memory leak
    */
    private List<Observer> observers;

    ObservableObject() {
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.removeIf(obs -> obs.equals(observer));
    }

    @Override
    public void notifyAllObservers() {
        for (Observer obs: observers) {
            obs.update();
        }
    }
}
