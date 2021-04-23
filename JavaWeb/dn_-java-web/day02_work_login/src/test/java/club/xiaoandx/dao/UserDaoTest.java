package club.xiaoandx.dao;

import club.xiaoandx.entity.User;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @org.junit.Test
    public void findAllList() {
        List<User> userList = null;
        try {
            userList =  UserDao.findAllList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
    }
}