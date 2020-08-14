package day0814.jdbc.domain;

import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTestInsert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
//            //1.注册驱动
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //2.获取Connection对象
//            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=java", "sa", "sasa");
//            //3.定义sql
            conn = JDBCUtil.getConnection();
            String sqlstr = "insert into category(name) values ('数码')";
            //4.执行sql对象
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sqlstr);
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(stmt,conn);
        }
    }
}
