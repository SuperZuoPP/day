package day0814.jdbc.services;

import day0814.jdbc.dao.CategoryDao;
import day0814.jdbc.entity.Category;
import day0814.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryImp implements CategoryDao{
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
        return 0;
    }

    @Override
    public int updateCategory(int id, String name) {
        return 0;
    }

    @Override
    public int deleteCategory(int id) {
        return 0;
    }
}
