package Sess07;

import java.util.Scanner;

interface DiscountStrategy6 {
    double applyDiscount(double total);
}

class WebsiteDiscount6 implements DiscountStrategy6 {
    public double applyDiscount(double total) {
        System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
        return total * 0.9;
    }
}

class MobileDiscount6 implements DiscountStrategy6 {
    public double applyDiscount(double total) {
        System.out.println("Áp dụng giảm giá 15% cho lần đầu");
        return total * 0.85;
    }
}

class POSDiscount6 implements DiscountStrategy6 {
    public double applyDiscount(double total) {
        System.out.println("Giảm giá 5% cho khách hàng thành viên tại cửa hàng");
        return total * 0.95;
    }
}

interface PaymentMethod6 {
    void pay(double amount);
}

class CreditCardPayment6 implements PaymentMethod6 {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng qua cổng thanh toán online: " + amount);
    }
}

class MomoPayment6 implements PaymentMethod6 {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán MoMo tích hợp: " + amount);
    }
}

class CashPayment6 implements PaymentMethod6 {
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt tại cửa hàng: " + amount);
    }
}

interface NotificationService6 {
    void send(String message);
}

class EmailNotification6 implements NotificationService6 {
    public void send(String message) {
        System.out.println("Gửi email xác nhận: " + message);
    }
}

class PushNotification6 implements NotificationService6 {
    public void send(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}

class PrintNotification6 implements NotificationService6 {
    public void send(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}

interface SalesChannelFactory6 {
    DiscountStrategy6 createDiscount();

    PaymentMethod6 createPayment();

    NotificationService6 createNotification();
}

class WebsiteFactory6 implements SalesChannelFactory6 {
    public DiscountStrategy6 createDiscount() {
        return new WebsiteDiscount6();
    }

    public PaymentMethod6 createPayment() {
        return new CreditCardPayment6();
    }

    public NotificationService6 createNotification() {
        return new EmailNotification6();
    }
}

class MobileFactory6 implements SalesChannelFactory6 {
    public DiscountStrategy6 createDiscount() {
        return new MobileDiscount6();
    }

    public PaymentMethod6 createPayment() {
        return new MomoPayment6();
    }

    public NotificationService6 createNotification() {
        return new PushNotification6();
    }
}

class POSFactory6 implements SalesChannelFactory6 {
    public DiscountStrategy6 createDiscount() {
        return new POSDiscount6();
    }

    public PaymentMethod6 createPayment() {
        return new CashPayment6();
    }

    public NotificationService6 createNotification() {
        return new PrintNotification6();
    }
}

class Order6 {
    String productName;
    double price;

    public Order6(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}

class OrderService6 {
    private DiscountStrategy6 discount;
    private PaymentMethod6 payment;
    private NotificationService6 notification;

    public OrderService6(SalesChannelFactory6 factory) {
        discount = factory.createDiscount();
        payment = factory.createPayment();
        notification = factory.createNotification();
    }

    public void processOrder(Order6 order) {
        System.out.println("Sản phẩm: " + order.productName);
        double finalPrice = discount.applyDiscount(order.price);
        payment.pay(finalPrice);
        notification.send("Đơn hàng thành công");
    }
}

public class xuatSac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== CHỌN KÊNH BÁN =====");
            System.out.println("1. Website");
            System.out.println("2. Mobile App");
            System.out.println("3. Store POS");
            System.out.println("0. Thoát");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                break;
            }

            SalesChannelFactory6 factory = null;
            switch (choice) {
                case 1:
                    factory = new WebsiteFactory6();
                    System.out.println("Bạn đã chọn kênh Website");
                    break;
                case 2:
                    factory = new MobileFactory6();
                    System.out.println("Bạn đã chọn kênh Mobile App");
                    break;
                case 3:
                    factory = new POSFactory6();
                    System.out.println("Bạn đã chọn kênh POS tại cửa hàng");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
                    continue;
            }

            System.out.print("Nhập tên sản phẩm: ");
            String name = sc.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            double price = sc.nextDouble();
            Order6 order = new Order6(name, price);
            OrderService6 service = new OrderService6(factory);
            service.processOrder(order);
        }
    }
}