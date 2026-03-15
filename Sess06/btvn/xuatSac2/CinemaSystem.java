package Sess06.btvn.xuatSac2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CinemaSystem {

    private List<TicketPool> pools = new ArrayList<>();
    private ExecutorService executor;
    private boolean running = false;

    public void startSystem(int rooms, int ticketsPerRoom, int counters) {

        pools.clear();

        for (int i = 0; i < rooms; i++) {

            char roomName = (char) ('A' + i);

            pools.add(new TicketPool(String.valueOf(roomName), ticketsPerRoom));
        }

        executor = Executors.newFixedThreadPool(counters);

        for (int i = 1; i <= counters; i++) {
            executor.submit(new BookingCounter("Quầy " + i, pools));
        }

        running = true;

        System.out.println("Đã khởi tạo hệ thống với "
                + rooms + " phòng, "
                + (rooms * ticketsPerRoom) + " vé, "
                + counters + " quầy");
    }

    public void stopSystem() {

        if (executor != null) {
            executor.shutdownNow();
        }

        running = false;

        System.out.println("Đã tạm dừng tất cả quầy bán vé.");
    }

    public void showStatistics() {

        System.out.println("\n=== THỐNG KÊ HIỆN TẠI ===");

        int revenue = 0;

        for (TicketPool pool : pools) {

            int sold = pool.getSoldCount();
            int total = pool.getTotalTickets();

            System.out.println("Phòng " + pool.getRoomName()
                    + ": Đã bán " + sold + "/" + total + " vé");

            revenue += sold * 250000;
        }

        System.out.println("Tổng doanh thu: " + revenue + " VNĐ");
    }
}