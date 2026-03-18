package Sess08.kha2;

class ThermometerAdapter implements TemperatureSensor {
    private OldThermometer oldThermometer;

    public ThermometerAdapter(OldThermometer oldThermometer) {
        this.oldThermometer = oldThermometer;
    }

    @Override
    public double getTemperatureCelsius() {
        int f = oldThermometer.getTemperatureFahrenheit();
        return (f - 32) * 5.0 / 9;
    }
}

class Light {
    public void off() {
        System.out.println("FACADE: Tắt đèn");
    }
}

class Fan {
    public void off() {
        System.out.println("FACADE: Tắt quạt");
    }

    public void setLowSpeed() {
        System.out.println("FACADE: Quạt chạy tốc độ thấp");
    }
}

class AirConditioner {
    public void off() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    public void setTemperature(int temp) {
        System.out.println("FACADE: Điều hòa set " + temp + "°C");
    }
}