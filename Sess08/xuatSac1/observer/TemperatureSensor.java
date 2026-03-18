package Sess08.xuatSac1.observer;

import java.util.*;

class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("\nCảm biến: Nhiệt độ = " + temp);
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}