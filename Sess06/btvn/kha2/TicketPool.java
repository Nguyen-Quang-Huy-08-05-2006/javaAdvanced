package Sess06.btvn.kha2;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;

        for (int i = 1; i <= totalTickets; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket ticket : tickets) {

            if (!ticket.isSold()) {

                ticket.setSold(true);
                return ticket;
            }
        }

        return null;
    }

    public synchronized int remainingTickets() {

        int count = 0;

        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                count++;
            }
        }

        return count;
    }
}