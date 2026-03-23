package Sess11.Bai05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Sess11.Bai01.DBContext;

public class DoctorDAO {

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void addDoctor(Doctor d) {
        String sql = "INSERT INTO Doctors(id, name, specialty) VALUES (?, ?, ?)";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, d.getId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getSpecialty());

            ps.executeUpdate();
            System.out.println("✔ Thêm bác sĩ thành công!");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Trùng mã bác sĩ!");
        } catch (SQLException e) {
            System.out.println("Lỗi dữ liệu!");
        }
    }

    public void countBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) as total FROM Doctors GROUP BY specialty";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                System.out.println(
                        rs.getString("specialty") + " : " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}