package com.tedu.jdbc;

import java.sql.*;

/**
 * jdbc的入门案例
 * 在本案例  学习jdbc  全部知识。
 * 1.加载驱动----（驱动与mysql版本关系）
 * 2.获取连接（三次握手）
 * 3.获取jdbc  执行器
 * 4.执行sql
 * 5.处理结果
 * 6.释放资源。。。。（断开连接时，四次分手）      ----连接池工具
 */
public class JDBC {

    //加载驱动  一次   构造代码块  静态构造代码块   构造方法。。
    static {
        //使用反射机制加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("找不到驱动，加载驱动失败");
        }
    }


    /**
     * 获取连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        //使用jdbc的api  获取对象
        long l = System.currentTimeMillis();
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "");
        System.out.println("获取连接对象耗时："+(System.currentTimeMillis()-l)+"毫秒");
        return root;

    }


    /**
     * 获取jdbc  执行器   执行sql的api
     * @param connection
     * @return  返回Statement执行器   不会对sql进行预编译。。出现sql注入。
     * @throws SQLException
     */
    public static Statement getstatement(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    /**
     * 执行sql语句   增删改操作  返回成功修改数据库行数   int
     * @param sql   带参数
     * @param statement
     * @return
     */
    public static  int exeUpdata(String sql,Statement statement) throws SQLException {
       return statement.executeUpdate(sql);
    }

    /**
     * 执行sql  查询  返回游标
     * @param sql
     * @param statement
     * @return
     */
    public static ResultSet getResult(String sql,Statement statement) throws SQLException {
        return statement.executeQuery(sql);
    }

    //解析数据、处理结课  一般放在  dao层中实现  注意关闭的顺序

    // 关闭连接  释放资源
    public static void close(ResultSet resultSet,Statement statement,PreparedStatement preparedStatement,Connection connection){

        try{
            resultSet.close();
        }catch (Exception e){

        }

        //  关闭
        try{
            statement.close();
        }catch (Exception e){

        }
        try{
            preparedStatement.close();
        }catch (Exception e){

        }

        try{
            connection.close();
        }catch (Exception e){

        }


    }

}
