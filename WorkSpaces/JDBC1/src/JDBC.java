import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * ClassName: JDBC
 * Description:
 * date: 2021/6/2 9:35
 *
 * @author wt
 * @since JDK 1.8
 */
public class JDBC {
    public static void main(String[] args) throws SQLException {
        //1. 先和数据库建立连接
        //  a).创建一个数据源
        DataSource dataSource = new MysqlDataSource();
        //  b).给数据源设置一些属性(告诉代码,数据库服务器在哪里)
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/aaa?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("");
        //  c).通过getConnection 方法来和服务器创建连接
        Connection connection = dataSource.getConnection();
    }
}
