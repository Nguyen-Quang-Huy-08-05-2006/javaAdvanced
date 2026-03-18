package Sess08.gioi2;

class Humidifier implements Observer {

    public Humidifier() {
        System.out.println("Máy tạo ẩm: Đã đăng ký");
    }

    @Override
    public void update(int temp) {
        System.out.println("Máy tạo ẩm: Điều chỉnh độ ẩm cho nhiệt độ " + temp);
    }
}