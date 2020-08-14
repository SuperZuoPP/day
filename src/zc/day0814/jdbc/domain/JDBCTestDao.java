package day0814.jdbc.domain;

import day0814.jdbc.entity.Category;
import day0814.jdbc.services.CategoryImp;

import java.sql.SQLException;
import java.util.List;

public class JDBCTestDao {
    public static void main(String[] args) {
        CategoryImp categoryImp = new CategoryImp();
        try {
            List<Category> list = categoryImp.list();
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
