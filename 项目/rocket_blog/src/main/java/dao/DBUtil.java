package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: DBUtil
 * Description: 设置数据库连接和释放
 * date: 2021/7/11 23:07
 */
public class DBUtil {
    private static DataSource dataSource = null;
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/rocketblog?characterEncoding=utf8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //单例模式创建一个数据源 ,暂时是线程不安全
    public static DataSource getDataSource() {
        // 看一下 dataSource 当前是否已经持有一个实例了.
        // 如果没有持有, 就创建一个新的.
        // 如果持有了, 就不必创建新的, 直接返回之前的.
        if (dataSource == null) {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl(URL);
            mysqlDataSource.setUser(USER);
            mysqlDataSource.setPassword(PASSWORD);
            dataSource = mysqlDataSource;
        }
        return dataSource;
    }

    // 1. 通过这个代码获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 2. 通过这个代码释放资源
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
