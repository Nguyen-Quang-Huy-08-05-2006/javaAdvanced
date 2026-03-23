package Sess12.PTIT_CNTT1_IT203B_Session12.src.main.java.org.example.execrise03;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import Sess11.Bai01.DBContext;

public class SurgeryFeeService {

    public BigDecimal getSurgeryFee(int surgeryId) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = DBContext.getConnection();

            String sql = "{call GET_SURGERY_FEE(?, ?)}";
            cstmt = conn.prepareCall(sql);

            cstmt.setInt(1, surgeryId);
            cstmt.registerOutParameter(2, Types.DECIMAL);

            cstmt.execute();

            return cstmt.getBigDecimal(2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null)
                    cstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            DBContext.closeConnection(conn);
        }

        return null;
    }
}