package Sess08.xuatSac1.device;

import java.util.Observable;
import java.util.Observer;

class Fan implements Observer {
    private String speed = "TẮT";

    public void setLow() {
        speed = "THẤP";
        System.out.println("Quạt: Chạy tốc độ thấp");
    }

    public void setHigh() {
        speed = "MẠNH";
        System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ mạnh");
    }

    public void update(int temp) {
        if (temp > 30) {
            setHigh();
        }
    }

    public String getStatus() {
        return speed;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}