package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatinesDAO dao = new PatinesDAO();

        System.out.print("Nhập mã bệnh nhân: ");
        String patientId = sc.nextLine();

        System.out.print("Nhập nhiệt độ mới: ");
        double temp = Double.parseDouble(sc.nextLine());

        dao.updateTemp(patientId, temp);

        sc.close();
    }
}
