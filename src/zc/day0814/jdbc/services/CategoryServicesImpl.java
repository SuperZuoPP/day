package day0814.jdbc.services;

import day0814.jdbc.entity.Category;
import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryServicesImpl implements CategoryServices {


    @Override
    public List<Category> list() throws SQLException {
        List<Category> categoryList = new ArrayList<Category>();
        String sqlstr = "select * from category";
        Connection conn = JDBCUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlstr);
        while (rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public int insertCategory(String name) {
        Connection conn = null;
        Statement stmt = null;
        int count=0;
        try {
            conn = JDBCUtil.getConnection();
            String sqlstr = "insert into category(name) values ('"+name+"')";
            //4.执行sql对象
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sqlstr);
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
        return count;
    }

    @Override
    public int updateCategory(int id,String name) {
        Connection conn = null;
        Statement stmt = null;
        int count=0;
        try {
            conn = JDBCUtil.getConnection();
            String sqlstr = "update category set name = '"+name+"' where id='"+id+"'";
            //4.执行sql对象
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sqlstr);
            if (count > 0) {
                System.out.println("更新成功！");
            }else{
                System.out.println("更新失败！");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(stmt,conn);
        }
        return count;
    }

    @Override
    public int deleteCategory(int id) {
        Connection conn = null;
        Statement stmt = null;
        int count=0;
        try {
            conn = JDBCUtil.getConnection();
            String sqlstr = "delete category where id='"+id+"'";
            //4.执行sql对象
            stmt = conn.createStatement();
            count = stmt.executeUpdate(sqlstr);
            if (count > 0) {
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败！");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.Close(stmt,conn);
        }
        return count;
    }
}
