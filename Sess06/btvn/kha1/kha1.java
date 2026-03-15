package Sess06.btvn.kha1;

public class kha1 {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter counter1 = new BookingCounter("Quầy 1", roomA);
        BookingCounter counter2 = new BookingCounter("Quầy 2", roomB);

        TicketSupplier supplier = new TicketSupplier(
                roomA,
                roomB,
                3,
                3000,
                3);

        Thread supplierThread = new Thread(supplier);

        counter1.start();
        counter2.start();
        supplierThread.start();
    }
}