import java.util.ArrayList;
import java.util.Random;

public class bai01 extends Thread {

    ArrayList<String> danhSachTen = new ArrayList<>();

    public bai01() {
        danhSachTen.add("An");
        danhSachTen.add("Bình");
        danhSachTen.add("Chi");
        danhSachTen.add("Dũng");
        danhSachTen.add("Hà");
    }

    public void run() {
        Random random = new Random();

        while (true) {
            int index = random.nextInt(danhSachTen.size());
            System.out.println("Tên được chọn: " + danhSachTen.get(index));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Luồng bị gián đoạn");
            }
        }
    }

    public static void main(String[] args) {
        bai01 t = new bai01();
        t.start();
    }
}