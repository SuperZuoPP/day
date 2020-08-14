package day0814.jdbc.domain;

import day0814.jdbc.entity.Category;
import day0814.jdbc.services.CategoryServicesImpl;

import java.sql.SQLException;
import java.util.List;

public class JDBCTestService {
    public static void main(String[] args) {
        CategoryServicesImpl csi = new CategoryServicesImpl();
        try {
            csi.insertCategory("酒");
            csi.updateCategory(4,"卤菜");
            List<Category> list = csi.list();
            System.out.println(list.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
