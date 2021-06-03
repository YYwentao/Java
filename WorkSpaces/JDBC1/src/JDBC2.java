import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: JDBC2
 * Description:
 * date: 2021/6/3 23:24
 *      JDBC 实现数据库的查询操作
 *              executeQuery()
 * @author wt
 * @since JDK 1.8
 */
public class JDBC2 {
    public static void main(String[] args) throws SQLException {
        //1.建立连接,创建数据源，设置数据源属性获取数据库资料
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/aaa?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("");
        Connection connection =  dataSource.getConnection();
        //2.创建 SQL 语句
        String sql = "select * from exam_result";
        PreparedStatement statement = connection.prepareStatement(sql);
        //3.执行 SQL 语句
        ResultSet resultSet = statement.executeQuery();
        //4.遍历结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            double chinese = resultSet.getDouble("chinese");
            double math = resultSet.getDouble("math");
            double english = resultSet.getDouble("english");
            System.out.println(id +", "+name+", "+chinese+", "+math+", "+english);
        }
        //5.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
