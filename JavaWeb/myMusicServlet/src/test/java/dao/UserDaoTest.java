package dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: UserDaoTest
 * Description:
 * date: 2021/7/17 18:23
 *
 * @author wt
 * @since JDK 1.8
 */
public class UserDaoTest {

    @Test
    public void login() {
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername("wt");
        user.setPassword("123");
        System.out.println(userDao.login(user));
    }

    @Test
    public void insertUser() {
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername("dwt");
        user.setPassword("123");
        user.setAge(17);
        user.setGender("男");
        user.setEmail("2313341@qq.com");
        userDao.insertUser(user);
    }
}