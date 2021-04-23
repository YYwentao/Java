package club.xiaoandx.utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    /**
     * <p> 查询news用户 </p>
     * @title: findUser
     * @date: 2021/4/21 11:52
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void findUser() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "SELECT *  FROM news_users" ;
        ResultSet re = JDBC.getResult(sql, statement);
        while (re.next()){
            int uid = re.getInt("uid");
            String name = re.getString("uname");
            String password = re.getString("upwd");
            System.out.println(uid + " " + name + " " + password);
        }

        JDBC.close(re, statement, null, conn);
    }

    /**
     * <p> 添加用户 </p>
     * @title: addUser
     * @date: 2021/4/21 12:00
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void addUser() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "INSERT INTO news_users (`uname`,`upwd`)VALUES ('xiaoandx', '123')" ;
        int statc = JDBC.exeUpdata(sql, statement);
        if(statc == 0){
            System.out.println("新建用户错误");
        }
        System.out.println("新增用户成功");
        JDBC.close(null, statement, null, conn);
    }

    /**
     * <p> 查询所有新闻类型 </p>
     * @title: findTopic
     * @date: 2021/4/21 12:00
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void findTopic() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "SELECT *  FROM topic" ;
        ResultSet re = JDBC.getResult(sql, statement);
        while (re.next()){
            int tid = re.getInt("tid");
            String name = re.getString("tname");
            System.out.println(tid + " " + name);
        }

        JDBC.close(re, statement, null, conn);
    }

    /**
     * <p> SQL注入 </p>
     * @title: sqlXS
     * @date: 2021/4/21 15:27
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     **/
    @Test
    public void sqlXS() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "INSERT INTO news_users (`uname`,`upwd`)VALUES ('xiaoandx', '123')" ;
        int statc = JDBC.exeUpdata(sql, statement);
        if(statc == 0){
            System.out.println("删除用户错误");
        }
        System.out.println("用户删除成功");
        JDBC.close(null, statement, null, conn);
    }
}