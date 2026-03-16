package Sess07.gioi1;

public class PaymentProcessor {

    public void process(PaymentMethod method, double amount) {

        if (method instanceof CODPayable) {
            ((CODPayable) method).processCOD(amount);
        }

        else if (method instanceof CardPayable) {
            ((CardPayable) method).processCard(amount);
        }

        else if (method instanceof EWalletPayable) {
            ((EWalletPayable) method).processEWallet(amount);
        }
    }
}
