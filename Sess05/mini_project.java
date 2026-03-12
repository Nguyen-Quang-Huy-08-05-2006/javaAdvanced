import java.util.*;
import java.util.stream.Collectors;

abstract class MenuItem {
    private String id;
    private String name;
    private double price;

    public MenuItem(String id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public abstract double calculatePrice();
    public String toString(){
        return id+" - "+name+" : "+calculatePrice();
    }
}

class Food extends MenuItem{
    public Food(String id,String name,double price){
        super(id,name,price);
    }
    @Override
    public double calculatePrice(){
        return getPrice();
    }
}

class Drink extends MenuItem{
    private String size;
    public Drink(String id,String name,double price,String size){
        super(id,name,price);
        this.size=size;
    }
    @Override
    public double calculatePrice(){
        if(size.equalsIgnoreCase("L"))
            return getPrice()+10000;
        if(size.equalsIgnoreCase("M"))
            return getPrice()+5000;
        return getPrice();
    }
}

enum OrderStatus{
    PENDING,
    PAID,
    CANCELLED
}

class Order{
    private String id;
    private Map<MenuItem,Integer> items=new HashMap<>();
    private OrderStatus status=OrderStatus.PENDING;

    public Order(String id){
        this.id=id;
    }
    public void addItem(MenuItem item,int quantity){
        items.put(item,items.getOrDefault(item,0)+quantity);
    }
    public double calculateTotal(){
        return items.entrySet()
                .stream()
                .mapToDouble(e->e.getKey().calculatePrice()*e.getValue())
                .sum();
    }
    public String getId(){
        return id;
    }
    public OrderStatus getStatus(){
        return status;
    }
    public void setStatus(OrderStatus status){
        this.status=status;
    }
    public Map<MenuItem,Integer> getItems(){
        return items;
    }
}

class InvalidOrderIdException extends Exception{
    public InvalidOrderIdException(String message){
        super(message);
    }
}

class MenuService{
    private List<MenuItem> menu=new ArrayList<>();
    public void addItem(MenuItem item){
        menu.add(item);
    }
    public void showMenu(){
        menu.forEach(System.out::println);
    }
    public Optional<MenuItem> findById(String id){
        return menu.stream()
                .filter(i->i.getId().equals(id))
                .findFirst();
    }
    public List<MenuItem> searchByName(String name){
        return menu.stream()
                .filter(i->i.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<MenuItem> searchByPrice(double min,double max){
        return menu.stream()
                .filter(i->i.calculatePrice()>=min && i.calculatePrice()<=max)
                .collect(Collectors.toList());
    }
}

class OrderService{
    private List<Order> orders=new ArrayList<>();
    public void createOrder(Order order){
        orders.add(order);
    }
    public Order getOrder(String id) throws InvalidOrderIdException{
        Optional<Order> order=orders.stream()
                .filter(o->o.getId().equals(id))
                .findFirst();
        if(!order.isPresent())
            throw new InvalidOrderIdException("Order not found");
        return order.get();
    }
    public double getRevenue(){
        return orders.stream()
                .mapToDouble(Order::calculateTotal)
                .sum();
    }
}

public class mini_project {
    public static void main(String[] args){
        MenuService menuService=new MenuService();
        OrderService orderService=new OrderService();
        Scanner sc=new Scanner(System.in);

        menuService.addItem(new Food("F1","Burger",50000));
        menuService.addItem(new Food("F2","Pizza",70000));
        menuService.addItem(new Drink("D1","Coke",20000,"M"));
        while(true){
            System.out.println("\n===== FAST FOOD SYSTEM =====");
            System.out.println("1. Show Menu");
            System.out.println("2. Create Order");
            System.out.println("3. Revenue");
            System.out.println("0. Exit");

            int choice=sc.nextInt();

            switch(choice){

                case 1:
                    menuService.showMenu();
                    break;
                case 2:
                    System.out.print("Order ID: ");
                    String id=sc.next();
                    Order order=new Order(id);
                    while(true){
                        System.out.print("Enter item id (0 to stop): ");
                        String itemId=sc.next();
                        if(itemId.equals("0"))
                            break;
                        menuService.findById(itemId).ifPresent(item->{
                            System.out.print("Quantity: ");
                            int q=sc.nextInt();
                            order.addItem(item,q);
                        });
                    }
                    System.out.println("Total = "+order.calculateTotal());
                    orderService.createOrder(order);
                    break;
                case 3:
                    System.out.println("Revenue = "+orderService.getRevenue());
                    break;
                case 0:
                    return;
            }
        }
    }
}