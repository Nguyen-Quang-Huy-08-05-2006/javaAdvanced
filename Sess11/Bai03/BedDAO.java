package Sess11.Bai03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Sess11.Bai01.DBContext;

public class BedDAO {

    public void updateBedStatus(int bedId) {
        String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {

            ps.setString(1, "Occupied");
            ps.setInt(2, bedId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật giường bệnh thành công!");
            } else {
                System.out.println("❌ Mã giường không tồn tại!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
