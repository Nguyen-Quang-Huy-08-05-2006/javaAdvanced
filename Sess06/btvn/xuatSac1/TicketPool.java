package Sess06.btvn.xuatSac1;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int total) {

        this.roomName = roomName;

        for (int i = 1; i <= total; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
        }
    }

    public synchronized Ticket holdTicket(String counterName, boolean isVIP) {

        for (Ticket ticket : tickets) {

            if (!ticket.isSold() && !ticket.isHeld()) {

                ticket.setHeld(true);
                ticket.setVIP(isVIP);
                ticket.setHeldBy(counterName);

                long expiry = System.currentTimeMillis() + 5000;
                ticket.setHoldExpiryTime(expiry);

                System.out.println(counterName + ": Đã giữ vé "
                        + ticket.getTicketId()
                        + (isVIP ? " (VIP)" : "")
                        + ". Vui lòng thanh toán trong 5s");

                return ticket;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket ticket, String counterName) {

        if (ticket == null)
            return;

        if (ticket.isHeld() && !ticket.isSold()
                && counterName.equals(ticket.getHeldBy())) {

            ticket.setSold(true);
            ticket.setHeld(false);

            System.out.println(counterName +
                    ": Thanh toán thành công vé " + ticket.getTicketId());
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket ticket : tickets) {

            if (ticket.isHeld()
                    && !ticket.isSold()
                    && ticket.getHoldExpiryTime() < now) {

                ticket.setHeld(false);
                ticket.setHeldBy(null);

                System.out.println(
                        "TimeoutManager: Vé "
                                + ticket.getTicketId()
                                + " hết hạn giữ, đã trả lại kho");
            }
        }
    }

    public String getRoomName() {
        return roomName;
    }
}