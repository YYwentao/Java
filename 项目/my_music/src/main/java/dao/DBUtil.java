package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: DBUtil
 * Description:
 * date: 2021/7/17 17:07
 */
public class DBUtil {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/my_music?characterEncoding=utf8&useSSL=false";
    private static final String username ="root";
    private static final String password = "";

    private static volatile DataSource dataSource;

    private static DataSource getDataSource(){
        // 双重校验锁
        if(dataSource == null){
            synchronized (DBUtil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource) dataSource).setUrl(url);
                    ((MysqlDataSource) dataSource).setUser(username);
                    ((MysqlDataSource) dataSource).setPassword(password);
                }
            }
        }
        return dataSource;
    }
    /**
     * 获取连接
     */
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败");
        }
    }
    /**
     * 释放资源
     */
    public static void getClose(Connection connection, PreparedStatement statement, ResultSet resultSet) {
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
