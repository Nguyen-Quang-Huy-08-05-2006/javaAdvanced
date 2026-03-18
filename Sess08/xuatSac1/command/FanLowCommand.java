package Sess08.xuatSac1.command;

import exercise01.device.Fan;

class FanLowCommand implements Command {
    private Fan fan;

    public FanLowCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        System.out.println("SleepMode: Quạt tốc độ thấp");
        fan.setLow();
    }
}