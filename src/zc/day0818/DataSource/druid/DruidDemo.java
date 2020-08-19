package day0818.DataSource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 阿里巴巴数据库连接池
 * 步骤：
 * 1.导入jar包
 * 2.定义配置文件（是properties形式的，可以叫任意名称，放在任意目录下）
 * 3.加载配置文件Properties
 * 4.获取数据库连接池对象：通过工厂类来获取 DruidDataSourceFactory
 * 5.getConnection()
 * 定义工具类
 * 1.JDBCUtils
 * 2.提供静态代码块加载配置文件。初始化连接池对象
 * 3.提供方法
 *      ①获取连接方法，通过数据库连接池获取连接
 *      ②释放资源
 *      ③获取连接池的方法
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();
        for (int i = 1; i <=15 ; i++) {
            System.out.println(i+":"+conn);
        }

    }

}
