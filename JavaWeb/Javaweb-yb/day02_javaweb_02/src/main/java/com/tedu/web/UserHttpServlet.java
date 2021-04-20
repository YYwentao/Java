package com.tedu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: UserHttpServlet
 * Description:
 * date: 2021/4/20 10:57
 *
 * @author wentao
 * @since JDK 1.8
 */

/**
 * 在post,get方法获取用户登录信息
 */
public class UserHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        System.out.println("用户提交的数据是"+name);
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
        System.out.println(req.getRemoteAddr());
        System.out.println(req.getMethod());

        System.out.println(req.getParameter("name"));
        String[] names = req.getParameterValues("name");
        System.out.println(req.getParameterValues("name"));
        System.out.println(req.getParameterMap());//把用户发送的全部参数封装成map
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
