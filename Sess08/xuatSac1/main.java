package Sess08.xuatSac1;

import java.util.Scanner;

import Sess08.xuatSac1.observer.TemperatureSensor;

import Sess08.xuatSac1.device.Light;
import Sess08.xuatSac1.device.Fan;
import Sess08.xuatSac1.device.AirConditioner;

import Sess08.xuatSac1.command.Command;
import Sess08.xuatSac1.command.LightOffCommand;
import Sess08.xuatSac1.command.FanLowCommand;
import Sess08.xuatSac1.command.ACCommand;
import Sess08.xuatSac1.command.SleepModeCommand;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== TẠO THIẾT BỊ =====
        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        // ===== SENSOR (OBSERVER) =====
        TemperatureSensor sensor = new TemperatureSensor();
        sensor.attach(fan);
        sensor.attach(ac);

        // ===== COMMAND (SLEEP MODE) =====
        SleepModeCommand sleep = new SleepModeCommand();
        sleep.addCommand(new LightOffCommand(light));
        sleep.addCommand(new ACCommand(ac));
        sleep.addCommand(new FanLowCommand(fan));

        // ===== MENU =====
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ");
            System.out.println("3. Xem trạng thái");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleep.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ: ");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 3:
                    System.out.println("Quạt: " + fan.getStatus());
                    System.out.println("Điều hòa: " + ac.getTemperature());
                    break;

                case 0:
                    System.out.println("Thoát.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}