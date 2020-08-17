package day0817.jdbc;

import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC控制事务
 * 1.事务：一个包含多个步骤的业务操作。如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。
 * 2.操作：①开启事务setAutoCommit(boolean autoCommit) false即开启事务
 *        ②提交事务commit()
 *        ③回滚事务rollback()
 * 3.使用Connection对象来管理事务
 */
public class JDBCTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn= JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String strsql="update  category set name = ? where id=? ";
            pstm= conn.prepareStatement(strsql);
            pstm.setString(1,"事务");
            pstm.setInt(2,2);
            pstm.executeUpdate();
            //int x=23/0;
            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) {
                    System.out.println("事务回滚");
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(pstm,conn);
        }
    }
}
