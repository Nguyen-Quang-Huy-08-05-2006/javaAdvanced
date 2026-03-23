package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import Sess11.Bai01.DBContext;

public class ResultDAO {

    public void insertWithStatement(List<TestResult> list) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBContext.getConnection();

            long start = System.currentTimeMillis();

            for (TestResult tr : list) {
                String sql = "INSERT INTO Results(data) VALUES('" + tr.getData() + "')";
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
            }

            long end = System.currentTimeMillis();
            System.out.println("Statement time: " + (end - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DBContext.closeConnection(conn);
        }
    }

    public void insertWithPreparedStatement(List<TestResult> list) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBContext.getConnection();

            String sql = "INSERT INTO Results(data) VALUES(?)";
            pstmt = conn.prepareStatement(sql);

            long start = System.currentTimeMillis();

            for (TestResult tr : list) {
                pstmt.setString(1, tr.getData());
                pstmt.executeUpdate();
            }

            long end = System.currentTimeMillis();
            System.out.println("PreparedStatement time: " + (end - start) + " ms");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DBContext.closeConnection(conn);
        }
    }
}