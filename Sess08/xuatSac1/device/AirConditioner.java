package Sess08.xuatSac1.device;

import java.util.Observable;
import java.util.Observer;

public class AirConditioner implements Observer {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    public void update(int temp) {
        // Có thể thêm logic nâng cao
        if (temp > 30) {
            System.out.println("Điều hòa: Giữ ổn định nhiệt độ = " + temperature);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}