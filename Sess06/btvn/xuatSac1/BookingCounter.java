package Sess06.btvn.xuatSac1;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool[] pools;

    private Random random = new Random();

    public BookingCounter(String name, TicketPool[] pools) {
        this.name = name;
        this.pools = pools;
    }

    @Override
    public void run() {

        while (true) {

            TicketPool pool = pools[random.nextInt(pools.length)];

            boolean vip = random.nextBoolean();

            Ticket ticket = pool.holdTicket(name, vip);

            if (ticket == null) {
                continue;
            }

            try {
                Thread.sleep(3000); // khách suy nghĩ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pool.sellHeldTicket(ticket, name);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}