package Sess08.gioi2;

class Fan implements Observer {

    public Fan() {
        System.out.println("Quạt: Đã đăng ký nhận thông báo");
    }

    @Override
    public void update(int temp) {
        if (temp < 20) {
            System.out.println("Quạt: Nhiệt độ thấp, tự động TẮT");
        } else if (temp <= 25) {
            System.out.println("Quạt: Nhiệt độ trung bình, chạy mức VỪA");
        } else {
            System.out.println("Quạt: Nhiệt độ cao, chạy tốc độ MẠNH");
        }
    }
}