package Sess08.xuatSac1.command;

import exercise01.device.Light;

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.off();
    }
}
