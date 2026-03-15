package Sess06.btvn.xuatSac2;

import java.util.Scanner;

public class xuatSac2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Xem thống kê");
            System.out.println("4. Phát hiện deadlock");
            System.out.println("5. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Số vé mỗi phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.startSystem(rooms, tickets, counters);
                    break;

                case 2:

                    system.stopSystem();
                    break;

                case 3:

                    system.showStatistics();
                    break;

                case 4:

                    new DeadlockDetector().run();
                    break;

                case 5:

                    System.out.println("Đang dừng hệ thống...");
                    System.exit(0);
            }
        }
    }
}