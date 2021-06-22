package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: UserDao
 * Description:   通过 UserDao 这个类对 User 表实现数据库操作
 * date: 2021/6/20 15:58
 */
public class UserDao {
    //1. add新增数据
    //把一个 User 对象插入到数据库中
    public void add(User user) {
        //1.建立数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装一个 sql 语句
        String sql = "insert into user values(null,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getPassword());
            //3.执行 sql 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入新用户失败！");
                return;
            }
            System.out.println("插入新用户成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放数据库的连接
            DBUtil.close(connection,statement,null);
        }
    }

    //2. 查找用户按照名字(登录)
    public User selectByName(String name) {
        //1.建立数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            //3.执行 sql 语句并返回
            resultSet = statement.executeQuery();
            //4.遍历结果集,因为 name 字段属性unique唯一，所以结果只有一个
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放数据库连接的资源
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //通过用户 Id 查找用户
    public User selectById(int userId) {
        //1.建立数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "select * from user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            //3.执行 sql 语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
        //1.测试 add 方法
        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setName("dwt");
//        user.setPassword("123456");
//        userDao.add(user);

        //2.测试 selectByName 方法
//        User user = userDao.selectByName("dwt");
//        System.out.println(user);
    }


}
