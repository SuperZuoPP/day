package day0814.jdbc.domain;

import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.获取Connection对象
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=java", "sa", "sasa");
            //3.定义sql
            String sqlstr = "delete category where id='2'";
            //4.执行sql对象
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sqlstr);
            System.out.println(count);
            if (count > 0) {
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(stmt,conn);
        }
    }
}
