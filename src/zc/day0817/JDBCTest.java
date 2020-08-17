package day0817;

import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PreparedStatement和Statement
 * 1.PreparedStatement是预编译（实例包含已编译的SQL语句）的,对于批量处理可以大大提高效率. 也叫JDBC存储过程
 * 2.除了缓冲的问题之外，使用PreparedStatement对象,那就是安全性（预防SQL注入攻击）
 * 3.
 */
public class JDBCTest {

    public static void main(String[] args) {

        new JDBCTest().query(3,"饮料");

    }

    public void query(int id,String name){

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn= JDBCUtil.getConnection();
            String strsql="select * from category where id=? and name=?";
            pstm= conn.prepareStatement(strsql);
            pstm.setInt(1,id);
            pstm.setString(2,name);
            rs=pstm.executeQuery();
            System.out.println(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(rs,pstm,conn);
        }

    }
}
