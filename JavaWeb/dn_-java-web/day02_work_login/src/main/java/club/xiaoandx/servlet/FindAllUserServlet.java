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
package club.xiaoandx.servlet;

import club.xiaoandx.dao.UserDao;
import club.xiaoandx.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * <p> 查询所以用户列表 </p>
 * @version V1.0.0
 * @ClassName:FindAllUserServlet
 * @author: WEI.ZHOU
 * @date: 2021/4/20 21:30
 */
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = null;
        try {
            userList =  UserDao.findAllList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/userList.jsp").forward(req, resp);
    }
}
