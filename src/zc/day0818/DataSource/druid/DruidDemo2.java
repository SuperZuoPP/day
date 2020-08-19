package day0818.DataSource.druid;

import day0818.DataSource.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用Druid工具类
 */
public class DruidDemo2 {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public static void main(String[] args) {


    }

    /**
     * 完成添加操作
     */
    @Test
    public void testAdd(){

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String strsql = "insert into category(name) values(?)";
            //3.获取PreparedStatement对象
            pstmt = conn.prepareStatement(strsql);
            //4.赋值
            pstmt.setString(1,"水果");
            //4.执行sql
            int i = pstmt.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }

    /**
     * 完成删除操作
     */
    @Test
    public void testDel(){
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String strsql = "delete from  category where name =?";
            //3.获取PreparedStatement对象
            pstmt = conn.prepareStatement(strsql);
            //4.赋值
            pstmt.setString(1,"水果");
            //4.执行sql
            int i = pstmt.executeUpdate();
            System.out.println(i+"删除成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }

    /**
     * 完成查询操作
     */
    @Test
    public void testQuery(){

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String strsql = "select * from  category ";
            //3.获取PreparedStatement对象
            pstmt = conn.prepareStatement(strsql);
            //4.赋值

            //4.执行sql
             rs= pstmt.executeQuery();
            while (rs.next()){
                System.out.println("id:"+rs.getInt("id")+"------name:"+rs.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
    }
}
