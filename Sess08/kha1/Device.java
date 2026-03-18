package Sess08.kha1;

public interface Device {
    void turnOn();

    void turnOff();
}

class Light implements Device {
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }

    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}

class Fan implements Device {
    public void turnOn() {
        System.out.println("Quạt: Bật.");
    }

    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}

class AirConditioner implements Device {
    public void turnOn() {
        System.out.println("Điều hòa: Bật.");
    }

    public void turnOff() {
        System.out.println("Điều hòa: Tắt.");
    }
}