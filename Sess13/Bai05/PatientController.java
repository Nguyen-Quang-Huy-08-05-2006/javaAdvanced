package Sess13.Bai05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Sess11.Bai01.DBContext;

public class PatientController {

    public List<Bed> getAvailableBeds() {
        List<Bed> beds = new ArrayList<>();

        String sql = "SELECT bed_id, bed_name, status FROM beds WHERE status = 'Trống' ORDER BY bed_id";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Bed bed = new Bed(
                        rs.getInt("bed_id"),
                        rs.getString("bed_name"),
                        rs.getString("status"));
                beds.add(bed);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách giường trống: " + e.getMessage());
        }

        return beds;
    }

    public void admitPatient(String fullName, int age, int bedId, double advanceAmount) throws Exception {
        Connection conn = null;
        PreparedStatement psCheckBed = null;
        PreparedStatement psInsertPatient = null;
        PreparedStatement psUpdateBed = null;
        PreparedStatement psInsertFinance = null;
        ResultSet rs = null;

        try {
            conn = Sess11.Bai01.DBContext.getConnection();
            conn.setAutoCommit(false);

            String sqlCheckBed = "SELECT status FROM beds WHERE bed_id = ?";
            psCheckBed = conn.prepareStatement(sqlCheckBed);
            psCheckBed.setInt(1, bedId);
            rs = psCheckBed.executeQuery();

            if (!rs.next()) {
                throw new Exception("Mã giường không tồn tại.");
            }

            String bedStatus = rs.getString("status");
            if (!"Trống".equalsIgnoreCase(bedStatus)) {
                throw new Exception("Giường này hiện không trống. Vui lòng chọn giường khác.");
            }

            String sqlInsertPatient = """
                    INSERT INTO patients(full_name, age, bed_id, advance_amount)
                    VALUES (?, ?, ?, ?)
                    """;
            psInsertPatient = conn.prepareStatement(sqlInsertPatient, Statement.RETURN_GENERATED_KEYS);
            psInsertPatient.setString(1, fullName);
            psInsertPatient.setInt(2, age);
            psInsertPatient.setInt(3, bedId);
            psInsertPatient.setDouble(4, advanceAmount);

            int insertedPatientRows = psInsertPatient.executeUpdate();
            if (insertedPatientRows == 0) {
                throw new Exception("Không thể thêm bệnh nhân mới.");
            }

            int patientId;
            try (ResultSet generatedKeys = psInsertPatient.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    patientId = generatedKeys.getInt(1);
                } else {
                    throw new Exception("Không lấy được mã bệnh nhân vừa tạo.");
                }
            }

            String sqlUpdateBed = "UPDATE beds SET status = 'Đã có người' WHERE bed_id = ?";
            psUpdateBed = conn.prepareStatement(sqlUpdateBed);
            psUpdateBed.setInt(1, bedId);

            int updatedBedRows = psUpdateBed.executeUpdate();
            if (updatedBedRows == 0) {
                throw new Exception("Không thể cập nhật trạng thái giường.");
            }

            String sqlInsertFinance = """
                    INSERT INTO finance_records(patient_id, amount, description)
                    VALUES (?, ?, ?)
                    """;
            psInsertFinance = conn.prepareStatement(sqlInsertFinance);
            psInsertFinance.setInt(1, patientId);
            psInsertFinance.setDouble(2, advanceAmount);
            psInsertFinance.setString(3, "Thu tiền tạm ứng nội trú cho bệnh nhân: " + fullName);

            int insertedFinanceRows = psInsertFinance.executeUpdate();
            if (insertedFinanceRows == 0) {
                throw new Exception("Không thể ghi nhận phiếu thu tạm ứng.");
            }

            conn.commit();
            System.out.println("Tiếp nhận bệnh nhân thành công.");
            System.out.println("Mã bệnh nhân mới: " + patientId);

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback dữ liệu do xảy ra lỗi.");
                } catch (SQLException rollbackEx) {
                    System.out.println("Rollback thất bại: " + rollbackEx.getMessage());
                }
            }
            throw e;
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng ResultSet: " + e.getMessage());
            }

            try {
                if (psCheckBed != null)
                    psCheckBed.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng psCheckBed: " + e.getMessage());
            }

            try {
                if (psInsertPatient != null)
                    psInsertPatient.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng psInsertPatient: " + e.getMessage());
            }

            try {
                if (psUpdateBed != null)
                    psUpdateBed.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng psUpdateBed: " + e.getMessage());
            }

            try {
                if (psInsertFinance != null)
                    psInsertFinance.close();
            } catch (SQLException e) {
                System.out.println("Lỗi đóng psInsertFinance: " + e.getMessage());
            }

            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Lỗi đóng Connection: " + e.getMessage());
            }
        }
    }
}