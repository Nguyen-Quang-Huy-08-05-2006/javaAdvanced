package Sess07.gioi2;

public class main {

    public static void main(String[] args) {

        System.out.println("=== Cấu hình 1 ===");

        OrderRepository repo1 = new FileOrderRepository();
        NotificationService notify1 = new EmailService();

        OrderService service1 = new OrderService(repo1, notify1);

        service1.createOrder(new Order("ORD001"), "a@example.com");

        System.out.println("\n=== Cấu hình 2 ===");

        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService notify2 = new SMSNotification();

        OrderService service2 = new OrderService(repo2, notify2);

        service2.createOrder(new Order("ORD002"), "b@example.com");
    }
}