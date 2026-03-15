package Sess06.btvn.gioi2;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<String> tickets = new LinkedList<>();
    private int ticketCounter = 1;

    public TicketPool(String roomName, int initialTickets) {
        this.roomName = roomName;

        for (int i = 0; i < initialTickets; i++) {
            tickets.add(generateTicket());
        }
    }

    private String generateTicket() {
        return roomName + "-" + String.format("%03d", ticketCounter++);
    }

    // bán vé
    public synchronized String sellTicket(String counterName) {

        while (tickets.isEmpty()) {
            try {
                System.out.println(counterName + ": Hết vé phòng " + roomName + ", đang chờ...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String ticket = tickets.poll();
        System.out.println(counterName + " bán vé " + ticket);

        return ticket;
    }

    // thêm vé
    public synchronized void addTickets(int amount) {

        for (int i = 0; i < amount; i++) {
            tickets.add(generateTicket());
        }

        System.out.println("Nhà cung cấp: Đã thêm " + amount + " vé vào phòng " + roomName);

        notifyAll(); // đánh thức các quầy
    }
}
