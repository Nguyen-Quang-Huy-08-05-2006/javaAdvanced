package Sess13.Bai03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class XuatVienService {

    private static final Statement DatabaseManager = null;

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;

        try {
            conn = DatabaseManager.getConnection();
            conn.setAutoCommit(false);

            String sqlGetBalance = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            PreparedStatement psGet = conn.prepareStatement(sqlGetBalance);
            psGet.setInt(1, maBenhNhan);

            ResultSet rs = psGet.executeQuery();

            if (!rs.next()) {
                throw new Exception("Bệnh nhân không tồn tại");
            }

            double balance = rs.getDouble("balance");

            if (balance < tienVienPhi) {
                throw new Exception("Không đủ tiền để thanh toán");
            }

            String sqlDeduct = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeduct);
            ps1.setDouble(1, tienVienPhi);
            ps1.setInt(2, maBenhNhan);
            int row1 = ps1.executeUpdate();

            String sqlFreeBed = "UPDATE Beds SET status = 'TRONG', patient_id = NULL WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlFreeBed);
            ps2.setInt(1, maBenhNhan);
            int row2 = ps2.executeUpdate();

            String sqlUpdatePatient = "UPDATE Patients SET status = 'DA_XUAT_VIEN' WHERE patient_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(sqlUpdatePatient);
            ps3.setInt(1, maBenhNhan);
            int row3 = ps3.executeUpdate();

            if (row1 == 0 || row2 == 0 || row3 == 0) {
                throw new Exception("Dữ liệu không hợp lệ (Row Affected = 0)");
            }

            conn.commit();
            System.out.println("Xuất viện và thanh toán thành công");

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}