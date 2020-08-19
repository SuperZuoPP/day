package day0818.DataSource.JDBCTemplate;

import day0814.jdbc.entity.Category;
import day0818.DataSource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JDBCTemplate
 * 1.导入jar包
 * 2.创建JDBCTemplate对象
 */
public class JDBCTemplateDemo {

    private  JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    public static void main(String[] args) {

    }

    @Test
    public void testInsert(){
        String strsql = "insert into category(name) values(?)";
        int jdbcTemplate1 = jdbcTemplate.update(strsql, "JDBCTemplate1");
        System.out.println(jdbcTemplate1);
    }

    @Test
    public void testDel(){
        String strsql = "delete from category where id = ?";
        int jdbcTemplate1 = jdbcTemplate.update(strsql, "22");
        testQuery1();
    }

    /**
     * queryForMap,查询结果封装为Map集合
     */
    @Test
    public void testQueryForMap(){
        String strsql ="select top 1* from category ";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(strsql);
        System.out.println(stringObjectMap);
    }

    /**
     * queryForList,查询结果封装为List集合
     */
    @Test
    public void testQueryForList(){
        String strsql ="select * from category ";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(strsql);
        System.out.println(maps);
    }

    /**
     * 查询结果封装为Category对象的List集合
     */
    @Test
    public void testQuery(){
        String strsql ="select * from category ";
        List<Category> categoryList = jdbcTemplate.query(strsql, new RowMapper<Category>() {

            @Override
            public Category mapRow(ResultSet rs, int i) throws SQLException {
                Category category = new Category();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                category.setId(id);
                category.setName(name);
                return category;
            }
        });
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

    /**
     * 查询结果封装为Category对象的List集合
     * new BeanPropertyRowMapper<>()
     */
    @Test
    public void testQuery1(){
        String strsql ="select * from category ";
        List<Category> categoryList = jdbcTemplate.query(strsql, new BeanPropertyRowMapper<Category>(Category.class));
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }

}
