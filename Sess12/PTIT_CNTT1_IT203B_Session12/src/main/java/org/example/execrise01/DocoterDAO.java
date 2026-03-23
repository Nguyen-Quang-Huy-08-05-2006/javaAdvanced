package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DocoterDAO {

    private static final Statement DBContext = null;

    public boolean LoginDocoter(String doctorCode, String password) {
        String sql = "SELECT * from Doctors where  doctor_code = ? AND password = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, doctorCode);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
