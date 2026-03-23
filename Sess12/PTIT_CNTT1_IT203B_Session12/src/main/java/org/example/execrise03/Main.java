package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise03;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SurgeryFeeService service = new SurgeryFeeService();

        int surgeryId = 505;
        BigDecimal fee = service.getSurgeryFee(surgeryId);

        if (fee != null) {
            System.out.println("Tổng chi phí phẫu thuật: " + fee);
        } else {
            System.out.println("Không lấy được chi phí phẫu thuật.");
        }
    }
}