package Sess13.Bai04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Sess11.Bai01.DBContext;

public class DashboardService {

    public List<BenhNhanDTO> layDanhSachDashboardBenhNhan() throws Exception {
        List<BenhNhanDTO> result = new ArrayList<>();

        String sql = """
                SELECT
                    bn.maBenhNhan,
                    bn.tenBenhNhan,
                    bn.ngaySinh,
                    bn.trangThai,
                    bn.khoa,
                    dv.maDichVu,
                    dv.tenDichVu,
                    dv.soLuong,
                    dv.donGia
                FROM BenhNhan bn
                LEFT JOIN DichVuSuDung dv
                    ON bn.maBenhNhan = dv.maBenhNhan
                WHERE bn.khoa = ?
                ORDER BY bn.maBenhNhan
                """;

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "Cấp cứu");

            try (ResultSet rs = ps.executeQuery()) {

                Map<Integer, BenhNhanDTO> benhNhanMap = new LinkedHashMap<>();

                while (rs.next()) {
                    int maBenhNhan = rs.getInt("maBenhNhan");

                    BenhNhanDTO benhNhan = benhNhanMap.get(maBenhNhan);
                    if (benhNhan == null) {
                        String tenBenhNhan = rs.getString("tenBenhNhan");
                        Date ngaySinh = rs.getDate("ngaySinh");
                        String trangThai = rs.getString("trangThai");
                        String khoa = rs.getString("khoa");

                        benhNhan = new BenhNhanDTO(maBenhNhan, tenBenhNhan, ngaySinh, trangThai, khoa);
                        benhNhanMap.put(maBenhNhan, benhNhan);
                    }

                    Integer maDichVu = (Integer) rs.getObject("maDichVu");

                    if (maDichVu != null) {
                        String tenDichVu = rs.getString("tenDichVu");
                        int soLuong = rs.getInt("soLuong");
                        double donGia = rs.getDouble("donGia");

                        DichVuDTO dichVu = new DichVuDTO(maDichVu, tenDichVu, soLuong, donGia);
                        benhNhan.getDsDichVu().add(dichVu);
                    }
                }

                result = new ArrayList<>(benhNhanMap.values());
            }

        } catch (SQLException e) {
            throw new Exception("Lỗi khi tải dữ liệu dashboard y tá: " + e.getMessage(), e);
        }

        return result;
    }

    public List<BenhNhanDTO> layDanhSachDashboardBenhNhanTheoTuKhoa(String tuKhoa) throws Exception {
        List<BenhNhanDTO> result = new ArrayList<>();

        String sql = """
                SELECT
                    bn.maBenhNhan,
                    bn.tenBenhNhan,
                    bn.ngaySinh,
                    bn.trangThai,
                    bn.khoa,
                    dv.maDichVu,
                    dv.tenDichVu,
                    dv.soLuong,
                    dv.donGia
                FROM BenhNhan bn
                LEFT JOIN DichVuSuDung dv
                    ON bn.maBenhNhan = dv.maBenhNhan
                WHERE bn.khoa = ?
                  AND bn.tenBenhNhan LIKE ?
                ORDER BY bn.maBenhNhan
                """;

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "Cấp cứu");
            ps.setString(2, "%" + tuKhoa + "%");

            try (ResultSet rs = ps.executeQuery()) {
                Map<Integer, BenhNhanDTO> benhNhanMap = new LinkedHashMap<>();

                while (rs.next()) {
                    int maBenhNhan = rs.getInt("maBenhNhan");

                    BenhNhanDTO benhNhan = benhNhanMap.get(maBenhNhan);
                    if (benhNhan == null) {
                        benhNhan = new BenhNhanDTO(
                                maBenhNhan,
                                rs.getString("tenBenhNhan"),
                                rs.getDate("ngaySinh"),
                                rs.getString("trangThai"),
                                rs.getString("khoa"));
                        benhNhanMap.put(maBenhNhan, benhNhan);
                    }

                    Integer maDichVu = (Integer) rs.getObject("maDichVu");
                    if (maDichVu != null) {
                        DichVuDTO dichVu = new DichVuDTO(
                                maDichVu,
                                rs.getString("tenDichVu"),
                                rs.getInt("soLuong"),
                                rs.getDouble("donGia"));
                        benhNhan.getDsDichVu().add(dichVu);
                    }
                }

                result = new ArrayList<>(benhNhanMap.values());
            }

        } catch (SQLException e) {
            throw new Exception("Lỗi khi tìm kiếm dashboard y tá: " + e.getMessage(), e);
        }

        return result;
    }
}