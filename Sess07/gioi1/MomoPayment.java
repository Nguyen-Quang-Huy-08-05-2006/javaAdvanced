package Sess07.gioi1;

public class MomoPayment implements EWalletPayable {

    @Override
    public void processEWallet(double amount) {

        System.out.println("Xử lý thanh toán MoMo: "
                + amount + " - Thành công");
    }
}