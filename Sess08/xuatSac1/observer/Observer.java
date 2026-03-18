package Sess08.xuatSac1.observer;

import java.util.*;

interface Observer {
    void update(int temperature);

    static void add(Observer o) {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
