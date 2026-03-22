package Sess11.Bai03;

public class Main {
    public static void main(String[] args) {
        BedDAO dao = new BedDAO();

        dao.updateBedStatus(1); // tồn tại
        dao.updateBedStatus(999); // không tồn tại
    }
}