package Sess06.btvn.gioi2;

public class TicketSupplier extends Thread {

    private TicketPool pool;

    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        try {

            Thread.sleep(5000);

            pool.addTickets(3);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}