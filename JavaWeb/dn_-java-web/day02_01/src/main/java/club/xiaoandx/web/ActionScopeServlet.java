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
package club.xiaoandx.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>  </p>
 *
 * @version V1.0.0
 * @ClassName:ActionScopeServlet
 * @author: WEI.ZHOU
 * @date: 2021/4/20 17:01
 */
public class ActionScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ServletContext servletContext = this.getServletContext();
        if(null == servletContext.getAttribute("counter")){
            servletContext.setAttribute("counter", 1);
        }else{
            Integer number = (Integer) servletContext.getAttribute("counter");
            servletContext.setAttribute("counter", number + 1);
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
