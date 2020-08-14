package day0814.jdbc.dao;

import day0814.jdbc.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
    List<Category> list() throws SQLException;
    int insertCategory(String name);
    int updateCategory(int id,String name);
    int deleteCategory(int id);
}
