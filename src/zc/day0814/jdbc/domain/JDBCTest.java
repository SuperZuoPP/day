package day0814.jdbc.domain;

import day0814.jdbc.dao.CategoryDao;
import day0814.jdbc.entity.Category;
import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getConnection();
            System.out.println("数据库："+JDBCUtil.url);
            String sqlstr1 = "insert into category(name) values ('书籍')";
            String sqlstr2 = "update category set  name = '饮料xx' where id='3'";
            String sqlstr3 = "delete category where id='7'";
            String sqlstr = "select * from category";
            stmt =conn.createStatement();
            int count = stmt.executeUpdate(sqlstr3);
            rs =  stmt.executeQuery(sqlstr);
            System.out.println(count);

            while (rs.next()){
                System.out.println("id:"+rs.getInt("id")+"------name:"+rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(rs,stmt,conn);
        }
    }
}
