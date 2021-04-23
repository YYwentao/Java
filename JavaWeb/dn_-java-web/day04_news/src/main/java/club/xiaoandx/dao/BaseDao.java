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

import club.xiaoandx.utils.JDBC;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 数据库的基本操作 </p>
 *
 * @version V1.0.0
 * @ClassName:BaseDao
 * @author: WEI.ZHOU
 * @date: 2021/4/22 11:16
 */
public class BaseDao {

    /**
     * <p> PreparedStatement 进行增删改 </p>
     *
     * @param sql 占位符sql
     * @param pam 数据集合
     * @title: update
     * @date: 2021/4/22 11:22
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: int 处理结果
     **/
    public int update(String sql, Object... pam) {
        int result = 0;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBC.getConn();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < pam.length; i++) {
                preparedStatement.setObject(1 + i, pam[i]);
            }
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            JDBC.close(null, null, preparedStatement, conn);
        }
        return result;
    }

    /**
     * <p> 数据查询 </p>
     *
     * @param sql 占位符SQL
     * @param pam 数据
     * @title: query
     * @date: 2021/4/22 11:33
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.sql.ResultSet  数据集合
     **/
    public ResultSet query(String sql, Object... pam) {
        ResultSet result = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = JDBC.getConn();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < pam.length; i++) {
                preparedStatement.setObject(1 + i, pam[i]);
            }
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public <T extends List<?>> T select(String sql, Class<?> clas, Object... pam) {
        ResultSet result = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<Object> list = null;
        try {
            conn = JDBC.getConn();
            preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < pam.length; i++) {
                preparedStatement.setObject(1 + i, pam[i]);
            }
            list = new ArrayList<>();
            result = preparedStatement.executeQuery();
            while (result.next()) {
                Object o = clas.newInstance();
                Field[] declaredFields = clas.getDeclaredFields();
                for (Field f : declaredFields) {
                    f.setAccessible(true);
                    f.set(o, result.getObject(f.getName()));
                }
                list.add(o);
            }
            JDBC.close(result, null, preparedStatement, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return (T) list;
    }
}