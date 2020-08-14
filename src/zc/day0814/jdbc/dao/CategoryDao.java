package day0814.jdbc.dao;

import day0814.jdbc.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> list() throws SQLException;
    public int insertCategory(String name);
    public int updateCategory(int id,String name);
}
