package dao;

import org.junit.Test;


/**
 * ClassName: UserDaoTest
 * Description:
 * date: 2021/7/14 16:22
 */
public class UserDaoTest {

    @Test
    public void insert() {
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("cxz");
//        user.setPassword("123");
//        userDao.insert(user);
    }

    @Test
    public void selectByName() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.selectByName("wt"));
    }

    @Test
    public void selectById() {
        UserDao userDao = new UserDao();
        System.out.println(userDao.selectById(1));
    }
}