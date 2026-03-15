package Sess06.btvn.xuatSac2;

import java.util.List;
import java.util.Random;

public class BookingCounter implements Runnable {

    private String name;
    private List<TicketPool> pools;
    private boolean running = true;

    private Random random = new Random();

    public BookingCounter(String name, List<TicketPool> pools) {
        this.name = name;
        this.pools = pools;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            TicketPool pool = pools.get(random.nextInt(pools.size()));

            Ticket ticket = pool.sellTicket();

            if (ticket != null) {
                System.out.println(name + " bán vé " + ticket.getId());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
