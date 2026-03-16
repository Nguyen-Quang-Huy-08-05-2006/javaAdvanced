package Sess07.gioi1;

public class CODPayment implements CODPayable {

    @Override
    public void processCOD(double amount) {

        System.out.println("Xử lý thanh toán COD: "
                + amount + " - Thành công");
    }
}