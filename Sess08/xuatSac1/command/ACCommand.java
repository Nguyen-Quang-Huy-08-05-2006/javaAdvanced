package Sess08.xuatSac1.command;

import exercise01.device.AirConditioner;

class ACCommand implements Command {
    private AirConditioner ac;

    public ACCommand(AirConditioner ac) {
        this.ac = ac;
    }

    public void execute() {
        System.out.println("SleepMode: Điều hòa set 28°C");
        ac.setTemperature(28);
    }
}