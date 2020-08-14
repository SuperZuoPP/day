package day0814.jdbc.services;

import day0814.jdbc.dao.CategoryDao;
import day0814.jdbc.entity.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryServices extends CategoryDao{
    @Override
    List<Category> list() throws SQLException;

    @Override
    int insertCategory(String name);

    @Override
    int updateCategory(int id,String name);
}
