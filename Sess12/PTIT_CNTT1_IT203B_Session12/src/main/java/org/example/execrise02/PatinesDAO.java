package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Sess11.Bai01.DBContext;

public class PatinesDAO {
    public void updateTemp(String patient_id, double temp) {
        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement("UPDATE Patients set temp = ? where patient_id = ?")) {
            ps.setDouble(1, temp);
            ps.setString(2, patient_id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cập nhật nhiệt độ thành công");
            } else {
                System.out.println("Không tìm thấy bệnh nhân");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
