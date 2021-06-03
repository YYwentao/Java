import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * ClassName: JDBC
 * Description:
 * date: 2021/6/2 9:35
 *  JDBC实现数据库的插入，删除，修改操作
 *      executeUpdate()
 * @author wt
 * @since JDK 1.8
 */
public class JDBC {
    public static void main(String[] args) throws SQLException {
        //  通过输入值插入数据库
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();
        String name = scan.next();
        double chinese = scan.nextDouble();
        double math = scan.nextDouble();
        double english = scan.nextDouble();
        //1. 先和数据库建立连接
        //  a).创建一个数据源
        DataSource dataSource = new MysqlDataSource();
        //  b).给数据源设置一些属性(告诉代码,数据库服务器在哪里)
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/aaa?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("");
        //  c).通过getConnection 方法来和服务器创建连接
        Connection connection = dataSource.getConnection();

        //2.拼接一个sql语句
        String str = "insert into exam_result values(?,?,?,?,?)";
        //  a).实际上需要一个语句对象的sql  使用PreparedStatement可以帮我们动态的构造一个SQL出来
        PreparedStatement statement = connection.prepareStatement(str);
        //  把第一个 ？ 替换成id(id 的类型是 int ,所以用 setInt 方法)
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setDouble(3,chinese);
        statement.setDouble(4,math);
        statement.setDouble(5,english);
        System.out.println(statement.toString());
        //3.执行 SQL 语句
        int  ret = statement.executeUpdate();
        //4.释放资源
        connection.close();
        statement.close();
    }
}
