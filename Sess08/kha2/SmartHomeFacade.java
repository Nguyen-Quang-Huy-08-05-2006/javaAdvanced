package Sess08.kha2;

class SmartHomeFacade {
    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(TemperatureSensor sensor) {
        this.light = new Light();
        this.fan = new Fan();
        this.ac = new AirConditioner();
        this.sensor = sensor;
    }

    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    public void sleepMode() {
        light.off();
        ac.setTemperature(28);
        fan.setLowSpeed();
    }

    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.println("Nhiệt độ hiện tại: " + temp + "°C");
    }
}