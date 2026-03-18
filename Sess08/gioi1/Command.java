package Sess08.gioi1;

public interface Command {
    void execute();

    void undo();
}

class Light {
    public void on() {
        System.out.println("Đèn: Bật");
    }

    public void off() {
        System.out.println("Đèn: Tắt");
    }
}

class Fan {
    public void on() {
        System.out.println("Quạt: Bật");
    }

    public void off() {
        System.out.println("Quạt: Tắt");
    }
}

class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }

    public int getTemperature() {
        return temperature;
    }
}