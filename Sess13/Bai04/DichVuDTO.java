package Sess13.Bai04;

public class DichVuDTO {
    private int maDichVu;
    private String tenDichVu;
    private int soLuong;
    private double donGia;

    public DichVuDTO() {
    }

    public DichVuDTO(int maDichVu, String tenDichVu, int soLuong, double donGia) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "DichVuDTO{" +
                "maDichVu=" + maDichVu +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}