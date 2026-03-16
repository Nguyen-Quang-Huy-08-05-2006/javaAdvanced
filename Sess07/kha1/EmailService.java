package Sess07.kha1;

public class EmailService {

    public void sendConfirmation(Customer customer, Order order) {

        System.out.println("Đã gửi email đến "
                + customer.getEmail()
                + ": Đơn hàng "
                + order.getOrderId()
                + " đã được tạo");
    }
}
