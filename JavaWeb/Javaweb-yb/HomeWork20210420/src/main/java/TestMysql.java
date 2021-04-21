import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: TestMysql
 * Description:
 * date: 2021/4/21 10:24
 *
 * @author wentao
 * @since JDK 1.8
 */
public class TestMysql {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/db_2021_3_13?characterEncoding=utf-8&useSSl=true";
        String username = "root";
        String password ="";
        //借助dataSource 来管理数据连接
        //1.创建DataSource 实例，并设置参数
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        //2.和数据库建立连接
        Connection connection = dataSource.getConnection();
        //3.访问数据库，需要先拼装一个sql语句
        String sql = "select * from tb_student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //4.执行sql
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getInt("age"));
        }
        //6.关闭连接，释放资源。
        //关闭顺序和创建顺序差不多
        resultSet.close();
        statement.close();
        connection.close();
    }
}
