package Sess07.gioi2;

public class OrderService {

    private OrderRepository repository;
    private NotificationService notificationService;

    public OrderService(OrderRepository repository,
            NotificationService notificationService) {

        this.repository = repository;
        this.notificationService = notificationService;
    }

    public void createOrder(Order order, String customerEmail) {

        repository.save(order);

        notificationService.send(
                "Đơn hàng " + order.getOrderId() + " đã được tạo",
                customerEmail);
    }
}
