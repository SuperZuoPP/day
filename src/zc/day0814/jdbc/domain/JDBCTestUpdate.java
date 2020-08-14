package day0814.jdbc.domain;

import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCUtil.getConnection();
            //3.定义sql
            String sqlstr = "update category set  name = '饮料x' where id='3'";
            //4.执行sql对象
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sqlstr);
            System.out.println(count);
            if (count > 0) {
                System.out.println("修改成功！");
            }else{
                System.out.println("修改失败！");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(stmt,conn);
        }
    }
}
