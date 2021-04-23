package com.tedu.web;

import com.tedu.pojo.News;
import com.tedu.servies.NewsServies;
import com.tedu.servies.NewsServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 新闻阅读
 * 绑定与新闻阅读相关的url
 */
//        /util/news?opr=readNew&nid=48
public class ReadServlet extends HttpServlet {

    //新闻模块的服务曾接口
    NewsServies newsServies;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置格式
        newsServies = new NewsServiesImpl();
        //  opr
        String opr = req.getParameter("opr");
        try{
            if(opr.equals("readNew")){
                //新闻阅读
                //获取新闻的id
                String nid = req.getParameter("nid");
                //int
                int id = Integer.parseInt(nid);
                News news = newsServies.getNewsById(id);
                //发生到  页面news_read.jsp
                req.setAttribute("news",news);
                //  转发
                req.getRequestDispatcher("/newspages/news_read.jsp").forward(req,resp);

            }
        }catch (Exception e){

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
