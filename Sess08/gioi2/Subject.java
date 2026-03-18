package Sess08.gioi2;

interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}