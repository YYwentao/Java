/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 *
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.utils;

import java.sql.*;

/**
 * <p> JDBC 连接学习 </p>
 *
 * @version V1.0.0
 * @ClassName:JDBC
 * @author: WEI.ZHOU
 * @date: 2021/4/21 10:00
 */
public class JDBC {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://47.108.3" +
            ".9:3306/newsdb?useUnicode=true&characterEncoding=UTF-8&" +
            "autoReconnect=true&failOverReadOnly=false";
    public static final String USERNAME = "dn_newsdb";
    public static final String PASSWORD = "dn_javaweb123";
    //加载驱动  一次   构造代码块  静态构造代码块   构造方法。。
    static {
        //使用反射机制加载驱动
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到驱动，加载驱动失败");
        }
    }


    /**
     * 获取连接对象
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        //使用jdbc的api  获取对象
        long l = System.currentTimeMillis();
        Connection root = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("获取连接对象耗时：" + (System.currentTimeMillis() - l) + "毫秒");
        return root;

    }


    /**
     * 获取jdbc  执行器   执行sql的api
     *
     * @param connection
     * @return 返回Statement执行器   不会对sql进行预编译。。出现sql注入。
     * @throws SQLException
     */
    public static Statement getstatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    /**
     * <p> 获取 PrepareStatement </p>
     * @title: getPrepareStatement
     * @date: 2021/4/22 10:39
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param connection
     * @param sql
     * @return: java.sql.PreparedStatement
     * @throws:
     **/
    public static PreparedStatement getPrepareStatement(Connection connection, String sql)
            throws SQLException {
        return connection.prepareStatement(sql);
    }

    /**
     * 执行sql语句   增删改操作  返回成功修改数据库行数   int
     *
     * @param sql       带参数
     * @param statement
     * @return
     */
    public static int exeUpdata(String sql, Statement statement) throws SQLException {
        return statement.executeUpdate(sql);
    }

    /**
     * 执行sql  查询  返回游标
     *
     * @param sql
     * @param statement
     * @return
     */
    public static ResultSet getResult(String sql, Statement statement) throws SQLException {
        return statement.executeQuery(sql);
    }

    /**
     * <p> 关闭连接  释放资源 </p>
     * @title: close
     * @date: 2021/4/21 13:10
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param resultSet
     * @param statement
     * @param preparedStatement
     * @param connection
     * @return: void
     **/
    public static void close(ResultSet resultSet, Statement statement, PreparedStatement preparedStatement, Connection connection) {

        try {
            resultSet.close();
        } catch (Exception e) {

        }
        try {
            statement.close();
        } catch (Exception e) {

        }
        try {
            preparedStatement.close();
        } catch (Exception e) {

        }
        try {
            connection.close();
        } catch (Exception e) {

        }
    }
}
