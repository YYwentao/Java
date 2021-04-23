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
package club.xiaoandx.dao;

import club.xiaoandx.entity.User;
import club.xiaoandx.util.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 用户数据操作 </p>
 * @version V1.0.0
 * @ClassName:UserDao
 * @author: WEI.ZHOU
 * @date: 2021/4/20 18:41
 */
public class UserDao {

    /**
     * <p> 用户登录数据库操作 </p>
     * @param username
     * @param password
     * @title: checkLogin
     * @date: 2021/4/20 18:51
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: boolean
     **/
    public static boolean checkLogin(String username, String password) throws SQLException {
        StringBuffer sql2 = new StringBuffer("SELECT * FROM user WHERE username= '");
        sql2.append(username + "'");
        sql2.append(" AND password = '");
        sql2.append(password + "'");
        Statement stm = DBHelper.getConnection().createStatement();
        ResultSet rs = stm.executeQuery(sql2.toString());
        int count = 0;
        while (rs.next()) {
            count = count + 1;
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

    /**
     * <p> 注册操作 </p>
     * @param username
     * @param password
     * @title: registe
     * @date: 2021/4/20 20:01
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     **/
    public static void registe(String username, String password) throws SQLException {
        StringBuffer sql2 = new StringBuffer("INSERT INTO user (`username`,`password`)VALUES ('");
        sql2.append(username + "', '");
        sql2.append(password + "')");
        Statement stm = DBHelper.getConnection().createStatement();
        stm.executeUpdate(sql2.toString());
    }

    /**
     * <p> 查询所以用户列表 </p>
     * @title: findAllList
     * @date: 2021/4/20 20:51
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.User>
     **/
    public static List<User> findAllList() throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT `uid`,`username`,`password`,`email` FROM " +
                "`user`" );
        PreparedStatement preparedStatement = DBHelper.getConnection()
                .prepareStatement(sql.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            User u = new User();
            u.setUid(resultSet.getInt("uid"));
            u.setUsername(resultSet.getString("username"));
            u.setPassword(resultSet.getString("password"));
            u.setEmail(resultSet.getString("email"));
            userList.add(u);
        }
        return  null == userList ? null : userList;
    }
}
