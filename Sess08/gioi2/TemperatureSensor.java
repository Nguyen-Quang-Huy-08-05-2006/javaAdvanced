package Sess08.gioi2;

import java.util.*;

class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void attach(Observer o) {
        observers.add(o);
        System.out.println("Đã đăng ký observer.");
    }

    public void detach(Observer o) {
        observers.remove(o);
        System.out.println("Đã hủy đăng ký observer.");
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
