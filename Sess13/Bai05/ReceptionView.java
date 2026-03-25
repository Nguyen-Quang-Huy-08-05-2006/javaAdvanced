package Sess13.Bai05;

import java.util.List;
import java.util.Scanner;

public class ReceptionView {
    private final Scanner scanner;
    private final PatientController patientController;

    public ReceptionView() {
        scanner = new Scanner(System.in);
        patientController = new PatientController();
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = inputInt("Chọn chức năng: ");

            switch (choice) {
                case 1:
                    showAvailableBeds();
                    break;
                case 2:
                    handleAdmitPatient();
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Tạm biệt.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=========== RIKKEI HOSPITAL ===========");
        System.out.println("1. Xem tình trạng giường bệnh");
        System.out.println("2. Tiếp nhận bệnh nhân nội trú");
        System.out.println("3. Thoát");
        System.out.println("=======================================");
    }

    private void showAvailableBeds() {
        List<Bed> beds = patientController.getAvailableBeds();

        if (beds.isEmpty()) {
            System.out.println("Hiện tại không có giường trống.");
            return;
        }

        System.out.println("\n--- DANH SÁCH GIƯỜNG TRỐNG ---");
        for (Bed bed : beds) {
            System.out.println("Mã giường: " + bed.getBedId()
                    + " | Tên giường: " + bed.getBedName()
                    + " | Trạng thái: " + bed.getStatus());
        }
    }

    private void handleAdmitPatient() {
        System.out.println("\n--- TIẾP NHẬN BỆNH NHÂN NỘI TRÚ ---");

        String fullName = inputNonEmptyString("Nhập tên bệnh nhân: ");
        int age = inputPositiveInt("Nhập tuổi bệnh nhân: ");
        int bedId = inputPositiveInt("Nhập mã giường muốn chọn: ");
        double advanceAmount = inputPositiveDouble("Nhập số tiền tạm ứng: ");

        try {
            patientController.admitPatient(fullName, age, bedId, advanceAmount);
        } catch (Exception e) {
            System.out.println("Tiếp nhận thất bại: " + e.getMessage());
        }
    }

    private String inputNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Dữ liệu không được để trống. Vui lòng nhập lại.");
        }
    }

    private int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private int inputPositiveInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Giá trị phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private double inputPositiveDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Số tiền phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }
}