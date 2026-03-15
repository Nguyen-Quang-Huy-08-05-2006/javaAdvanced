package Sess06.btvn.xuatSac2;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();
    private int soldCount = 0;

    public TicketPool(String roomName, int totalTickets) {

        this.roomName = roomName;

        for (int i = 1; i <= totalTickets; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i)));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {
                t.setSold(true);
                soldCount++;
                return t;
            }
        }

        return null;
    }

    public int getSoldCount() {
        return soldCount;
    }

    public int getTotalTickets() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }
}