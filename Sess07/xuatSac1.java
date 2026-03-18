package Sess07;
import java.util.*;

class Product5 {
    String id;
    String name;
    double price;
    public Product5(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Customer5 {
    String name;
    String email;
    public Customer5(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class OrderItem5 {
    Product5 product;
    int quantity;
    public OrderItem5(Product5 product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double getTotal() {
        return product.price * quantity;
    }
}

class Order5 {
    String id;
    Customer5 customer;
    List<OrderItem5> items = new ArrayList<>();
    public Order5(String id, Customer5 customer) {
        this.id = id;
        this.customer = customer;
    }
    public void addItem(OrderItem5 item) {
        items.add(item);
    }
    public double getTotal() {
        double total = 0;
        for (OrderItem5 i : items) {
            total += i.getTotal();
        }
        return total;
    }
}

interface DiscountStrategy5 {
    double applyDiscount(double total);
}
class PercentageDiscount5 implements DiscountStrategy5 {
    double percent;
    public PercentageDiscount5(double percent) {
        this.percent = percent;
    }
    public double applyDiscount(double total) {
        return total - (total * percent / 100);
    }
}

class FixedDiscount5 implements DiscountStrategy5 {
    double amount;
    public FixedDiscount5(double amount) {
        this.amount = amount;
    }
    public double applyDiscount(double total) {
        return total - amount;
    }
}

class HolidayDiscount5 implements DiscountStrategy5 {
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}

interface PaymentMethod5 {
    void pay(double amount);
}
class CODPayment5 implements PaymentMethod5 {
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount);
    }
}
class CreditCardPayment5 implements PaymentMethod5 {
    public void pay(double amount) {
        System.out.println("Thanh toán thẻ tín dụng: " + amount);
    }
}

class MomoPayment5 implements PaymentMethod5 {
    public void pay(double amount) {
        System.out.println("Thanh toán MoMo: " + amount);
    }
}

class VNPayPayment5 implements PaymentMethod5 {
    public void pay(double amount) {
        System.out.println("Thanh toán VNPay: " + amount);
    }
}

interface OrderRepository5 {
    void save(Order5 order);
    List<Order5> findAll();
}

class FileOrderRepository5 implements OrderRepository5 {
    List<Order5> orders = new ArrayList<>();
    public void save(Order5 order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.id);
    }
    public List<Order5> findAll() {
        return orders;
    }
}

interface NotificationService5 {
    void send(String message);
}

class EmailNotification5 implements NotificationService5 {
    public void send(String message) {
        System.out.println("Đã gửi email: " + message);
    }
}

class SMSNotification5 implements NotificationService5 {
    public void send(String message) {
        System.out.println("Đã gửi SMS: " + message);
    }
}

class InvoiceGenerator5 {
    public void printInvoice(Order5 order, double finalAmount) {
        System.out.println("\n=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.customer.name);
        for (OrderItem5 item : order.items) {
            System.out.println(
                    item.product.name +
                            " - SL: " + item.quantity +
                            " - Giá: " + item.product.price +
                            " - Thành tiền: " + item.getTotal()
            );
        }
        System.out.println("Tổng tiền: " + order.getTotal());
        System.out.println("Cần thanh toán: " + finalAmount);
    }
}

class OrderService5 {
    private OrderRepository5 repository;
    private NotificationService5 notification;
    public OrderService5(OrderRepository5 repository, NotificationService5 notification) {
        this.repository = repository;
        this.notification = notification;
    }
    public void createOrder(Order5 order, DiscountStrategy5 discount, PaymentMethod5 payment) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);
        InvoiceGenerator5 invoice = new InvoiceGenerator5();
        invoice.printInvoice(order, finalAmount);
        payment.pay(finalAmount);
        repository.save(order);
        notification.send("Đơn hàng " + order.id + " đã được tạo");
    }
    public List<Order5> getOrders() {
        return repository.findAll();
    }
}

public class xuatSac1 {
    static List<Product5> products = new ArrayList<>();
    static List<Customer5> customers = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderRepository5 repo = new FileOrderRepository5();
        NotificationService5 notify = new EmailNotification5();
        OrderService5 service = new OrderService5(repo, notify);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem đơn hàng");
            System.out.println("0. Thoát");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Mã: ");
                String id = sc.nextLine();
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("Giá: ");
                double price = sc.nextDouble();
                sc.nextLine();
                products.add(new Product5(id, name, price));
                System.out.println("Đã thêm sản phẩm " + id);
            }
            else if (choice == 2) {
                System.out.print("Tên: ");
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                customers.add(new Customer5(name, email));
                System.out.println("Đã thêm khách hàng");
            }

            else if (choice == 3) {
                Customer5 c = customers.get(0);
                Product5 p = products.get(0);
                Order5 order = new Order5("ORD001", c);
                order.addItem(new OrderItem5(p, 1));
                DiscountStrategy5 discount = new PercentageDiscount5(10);
                PaymentMethod5 payment = new CreditCardPayment5();
                service.createOrder(order, discount, payment);
            }

            else if (choice == 4) {
                for (Order5 o : service.getOrders()) {
                    System.out.println(o.id + " - " + o.customer.name + " - " + o.getTotal());
                }
            }
            else {
                break;
            }
        }
    }
}