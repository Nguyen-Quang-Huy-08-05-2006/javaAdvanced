package Sess06.btvn.xuatSac2;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class DeadlockDetector implements Runnable {

    @Override
    public void run() {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        long[] threadIds = bean.findDeadlockedThreads();

        System.out.println("Đang quét deadlock...");

        if (threadIds != null) {
            System.out.println("⚠ Phát hiện DEADLOCK!");
        } else {
            System.out.println("Không phát hiện deadlock.");
        }
    }
}