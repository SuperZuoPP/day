package day0814.jdbc.domain;

import day0814.jdbc.entity.Category;
import day0814.jdbc.services.CategoryServicesImpl;

import java.sql.SQLException;
import java.util.List;

public class JDBCTestService {
    public static void main(String[] args) {
        CategoryServicesImpl csi = new CategoryServicesImpl();
        try {
            csi.insertCategory("电器");
            csi.updateCategory(3,"饮料");
            csi.deleteCategory(11);
            List<Category> list = csi.list();
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
