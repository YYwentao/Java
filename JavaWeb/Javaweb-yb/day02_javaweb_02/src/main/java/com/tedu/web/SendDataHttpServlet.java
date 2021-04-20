package com.tedu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: SendDataHttpServlet
 * Description:
 * date: 2021/4/20 16:10
 *
 * @author wentao
 * @since JDK 1.8
 */
public class SendDataHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");//获取用户发送数据
        System.out.println("你正在使用转发向后台发送数据！");
        req.setAttribute("key",name);
        //req.getRequestDispatcher("/show.jsp").forward(req,resp);
        resp.sendRedirect("/show.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
