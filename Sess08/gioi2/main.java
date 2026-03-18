package Sess08.gioi2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TemperatureSensor sensor = new TemperatureSensor();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đăng ký Quạt");
            System.out.println("2. Đăng ký Máy tạo ẩm");
            System.out.println("3. Set nhiệt độ");
            System.out.println("4. Hủy tất cả observer");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sensor.attach(new Fan());
                    break;

                case 2:
                    sensor.attach(new Humidifier());
                    break;

                case 3:
                    System.out.println("Nhập nhiệt độ:");
                    int temp = sc.nextInt();
                    sensor.setTemperature(temp);
                    break;

                case 4:
                    sensor = new TemperatureSensor();
                    System.out.println("Đã reset danh sách observer.");
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Sai lựa chọn.");
            }
        }
    }
}