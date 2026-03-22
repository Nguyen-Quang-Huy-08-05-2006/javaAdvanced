package Sess11.Bai05;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorDAO dao = new DoctorDAO();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    List<Doctor> list = dao.getAllDoctors();
                    for (Doctor d : list) {
                        System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Nhập ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập chuyên khoa: ");
                        String specialty = sc.nextLine();

                        dao.addDoctor(new Doctor(id, name, specialty));

                    } catch (Exception e) {
                        System.out.println("Input lỗi!");
                    }
                    break;

                case 3:
                    dao.countBySpecialty();
                    break;

                case 4:
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("Chọn ngu rồi, nhập lại!");
            }
        }
    }
}