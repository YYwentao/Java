package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import sun.security.util.Password;

import javax.sql.DataSource;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: DBUtil
 */
//管理数据库连接: 1.建立连接, 2.断开连接
//JDBC 中使用 DataSource 来管理连接
//DBUtil 相当于是对 DataSource 在稍微包装一层,DBUtil 本质上就是实现一个单例模式，
//来管理唯一一个DataSource实例，此处实现懒汉式的单例
public class DBUtil {
    private static DataSource dataSource= null;
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/java0621_blogdemo?characterEncoding=utf8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //给 DataSource 设置
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USER);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    //通过这个方法获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //通过这个方法断开连接
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
