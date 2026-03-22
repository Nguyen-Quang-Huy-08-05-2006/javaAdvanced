package Sess11.Bai02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Sess11.Bai01.DBContext;

public class PharmacyDAO {

    public void getAllMedicines() {
        String sql = "SELECT medicine_name, stock FROM Pharmacy";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Số lượng: " + stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}