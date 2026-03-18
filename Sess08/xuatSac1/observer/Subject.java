package Sess08.xuatSac1.observer;

interface Subject {
    void attach(Observer o);

    void notifyObservers();
}