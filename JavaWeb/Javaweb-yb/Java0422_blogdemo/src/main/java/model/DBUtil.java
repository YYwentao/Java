package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

//管理数据库连接
//1)建立连接
//2)断开连接
//JDBC 中使用DataSource来管理连接
//DBUtil相当于是对DataSource 在稍微包装了一层
//DataSource 每个应用程序只应该有一个应用实例~~(单列)
//DBUtil本质上就是实现了一个单列模式,管理了唯一的一个DataSource 实例
//单例模式的实现,有两种风格
//1.饿汉模式
//2.懒汉模式
//此处使用懒汉模式即可
public class DBUtil {
    private static DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Java0422_blogdemo?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="";

    public static DataSource getDataSource(){
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            //还需要给DataSource 设置一些属性.
            ((MysqlDataSource)dataSource).setURL(URL);
            ((MysqlDataSource)dataSource).setUser(USERNAME);
            ((MysqlDataSource)dataSource).setPassword(PASSWORD);
        }
        return dataSource;
    }
}

