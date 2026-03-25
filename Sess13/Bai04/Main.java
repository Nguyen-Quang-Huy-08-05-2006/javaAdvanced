package Sess13.Bai04;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DashboardService service = new DashboardService();

        try {
            List<BenhNhanDTO> dsBenhNhan = service.layDanhSachDashboardBenhNhan();

            for (BenhNhanDTO bn : dsBenhNhan) {
                System.out.println("====================================");
                System.out.println("Mã BN: " + bn.getMaBenhNhan());
                System.out.println("Tên BN: " + bn.getTenBenhNhan());
                System.out.println("Ngày sinh: " + bn.getNgaySinh());
                System.out.println("Trạng thái: " + bn.getTrangThai());
                System.out.println("Khoa: " + bn.getKhoa());

                if (bn.getDsDichVu().isEmpty()) {
                    System.out.println("Danh sách dịch vụ: Trống");
                } else {
                    System.out.println("Danh sách dịch vụ:");
                    for (DichVuDTO dv : bn.getDsDichVu()) {
                        System.out.println(" - " + dv.getTenDichVu()
                                + " | Số lượng: " + dv.getSoLuong()
                                + " | Đơn giá: " + dv.getDonGia());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}