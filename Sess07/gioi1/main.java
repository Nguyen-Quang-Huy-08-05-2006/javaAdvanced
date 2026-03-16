package Sess07.gioi1;

public class main {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        processor.process(cod, 500000);
        processor.process(card, 1000000);
        processor.process(momo, 750000);

        System.out.println("Kiểm tra LSP:");

        PaymentMethod test = new CreditCardPayment();
        processor.process(test, 600000);

        test = new MomoPayment();
        processor.process(test, 600000);
    }
}
