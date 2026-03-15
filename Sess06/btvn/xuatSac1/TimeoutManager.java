package Sess06.btvn.xuatSac1;

public class TimeoutManager implements Runnable {

    private TicketPool[] pools;

    public TimeoutManager(TicketPool[] pools) {
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            for (TicketPool pool : pools) {
                pool.releaseExpiredTickets();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}