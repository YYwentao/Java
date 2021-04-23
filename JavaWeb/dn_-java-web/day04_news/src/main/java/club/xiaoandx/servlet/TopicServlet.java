package club.xiaoandx.servlet;/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 *
 *                        <xiaoandx@gmail.com>
 */

import club.xiaoandx.entity.News;
import club.xiaoandx.entity.Topic;
import club.xiaoandx.server.NewsServer;
import club.xiaoandx.server.TopicServer;
import club.xiaoandx.server.impl.NewsServerImpl;
import club.xiaoandx.server.impl.TopicServerImpl;
import club.xiaoandx.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>  获取所有新闻分类servlet </p>
 * @version V1.0.0
 * @ClassName:TopicServlet
 * @author: WEI.ZHOU
 * @date: 2021/4/22 12:15
 */
public class TopicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer num = 1;
        String num1 = request.getParameter("num");
        if(num1 != "" && num1 != null){
            num = Integer.valueOf(num1);
        }
        TopicServer topicServer = new TopicServerImpl();
        NewsServer newsServer = new NewsServerImpl();
        PageModel pageModel = newsServer.findNewsToPage(num,20);
        List<Topic> topicList = topicServer.findAll();
        request.setAttribute("topicAll", topicList);
        request.setAttribute("page",pageModel);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
