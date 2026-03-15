package Sess06.btvn.gioi1;

public class gioi1 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 3);
        TicketPool roomB = new TicketPool("B", 3);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA, roomB);

        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB, roomA);

        counter1.start();
        counter2.start();
    }
}