package Sess11.Bai04;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Sess11.Bai01.DBContext;

public class PatientDAO {

    // Hàm lọc ký tự nguy hiểm
    public String sanitizeInput(String input) {
        if (input == null)
            return "";
        return input
                .replace("'", "")
                .replace("\"", "")
                .replace(";", "")
                .replace("--", "");
    }

    public void findPatientByName(String patientName) {

        String safeName = sanitizeInput(patientName);

        String sql = "SELECT * FROM Patients WHERE full_name = '" + safeName + "'";

        try (
                Connection conn = DBContext.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("full_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}