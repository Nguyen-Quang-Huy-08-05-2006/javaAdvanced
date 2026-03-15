package Sess06.btvn.kha1;

public class BookingCounter extends Thread {

    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            Ticket ticket = pool.sellTicket();

            if (ticket == null) {
                break;
            }

            soldCount++;
            System.out.println(name + " đã bán vé " + ticket.getId());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(name + " bán được: " + soldCount + " vé");
    }
}