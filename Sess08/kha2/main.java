package Sess08.kha2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TemperatureSensor sensor = new ThermometerAdapter(new OldThermometer());
        SmartHomeFacade smartHome = new SmartHomeFacade(sensor);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    smartHome.getCurrentTemperature();
                    break;
                case 2:
                    smartHome.leaveHome();
                    break;
                case 3:
                    smartHome.sleepMode();
                    break;
                case 0:
                    System.out.println("Thoát.");
                    return;
                default:
                    System.out.println("Sai lựa chọn.");
            }
        }
    }
}