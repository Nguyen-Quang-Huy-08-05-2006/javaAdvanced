package Sess13.Bai04;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanDTO {
    private int maBenhNhan;
    private String tenBenhNhan;
    private Date ngaySinh;
    private String trangThai;
    private String khoa;
    private List<DichVuDTO> dsDichVu;

    public BenhNhanDTO() {
        this.dsDichVu = new ArrayList<>();
    }

    public BenhNhanDTO(int maBenhNhan, String tenBenhNhan, Date ngaySinh, String trangThai, String khoa) {
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngaySinh = ngaySinh;
        this.trangThai = trangThai;
        this.khoa = khoa;
        this.dsDichVu = new ArrayList<>();
    }

    public int getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public List<DichVuDTO> getDsDichVu() {
        return dsDichVu;
    }

    public void setDsDichVu(List<DichVuDTO> dsDichVu) {
        this.dsDichVu = dsDichVu;
    }

    @Override
    public String toString() {
        return "BenhNhanDTO{" +
                "maBenhNhan=" + maBenhNhan +
                ", tenBenhNhan='" + tenBenhNhan + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", trangThai='" + trangThai + '\'' +
                ", khoa='" + khoa + '\'' +
                ", dsDichVu=" + dsDichVu +
                '}';
    }
}
