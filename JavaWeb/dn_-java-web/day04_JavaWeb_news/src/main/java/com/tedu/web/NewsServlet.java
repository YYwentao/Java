package com.tedu.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tedu.pojo.News;
import com.tedu.pojo.NewsTopic;
import com.tedu.servies.NewsServies;
import com.tedu.servies.NewsServiesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * 新闻模块  web   处理新闻相关  请求
 */
public class NewsServlet extends HttpServlet {

    NewsServies newsServies;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取用户请求类型
        String name = req.getParameter("name");
        //实例化
        newsServies = new NewsServiesImpl();

        //设置向客户端发送文本数据格式   json
        resp.setContentType("text/html; charset=utf-8");
        //输出对象
        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper  = new ObjectMapper();

        try{
            if(name.equals("index")){
                //显示新闻首页
                //获取全部新闻类型
                List<NewsTopic> allTopic = newsServies.getAllTopic();
                //分页获取新闻列表
                List<News> newsByPageNo = newsServies.getNewsByPageNo(1, 100);

                //发送数据到页面
                req.setAttribute("allTopic",allTopic);
                req.setAttribute("newsByPageNo",newsByPageNo);

                //转发到首页
                req.getRequestDispatcher("/index.jsp").forward(req,resp);

            }else if(name.equals("topiclist")){
                //使用json数据显示项目首页  全部的新闻类型
                //获取全部新闻类型
                List<NewsTopic> allTopic = newsServies.getAllTopic();
                //转换为json数据

                String json = mapper.writeValueAsString(allTopic);

                System.out.println(json);
                //  通过文本发送
                writer.println(json);
            }else if (name.equals("topicNews")) {
                //http://localhost/news?name=topicNews&tid=13&pageIndex=1
                //获取分页的新闻
                String tid = req.getParameter("tid");
                String pageIndex = req.getParameter("pageIndex");
                //转换为int
                int newtid = 0;
                int  index = 0;
                try{
                      index = Integer.parseInt(pageIndex);
                }catch (Exception e){
                        index = 1;
                }

                try{
                    newtid = Integer.parseInt(tid);
                }catch (Exception e){

                    newtid = 0;
                }
                //调用业务方法
                if(newtid==0){
                    //获取全部的新闻
                    List<News> newsByPageNo = newsServies.getNewsByPageNo(index, 15);
                    //转换json
                    HashMap<String ,Object> data = new HashMap<>();
                    //新闻类型
                    data.put("tid",newtid);
                    data.put("index",index);
                    data.put("newsList",newsByPageNo);
                    //计算  总页数
                    int count = newsServies.getAllCount();

                    int totalPageCount = count%15==0 ? count/15 : count/15+1;
                    data.put("totalPageCount",totalPageCount);

                    String s = mapper.writeValueAsString(data);
                    System.out.println("新闻数据："+s);

                    //发送
                    writer.println(s);


                }else{

                    //获取全部的新闻
                    List<News> newsByPageNo = newsServies.getNewsByPageNo(newtid,index, 15);
                    //转换json
                    HashMap<String ,Object> data = new HashMap<>();
                    //新闻类型
                    data.put("tid",newtid);
                    data.put("index",index);
                    data.put("newsList",newsByPageNo);
                    //计算  总页数
                    int count = newsServies.getCountByTid(newtid);

                    int totalPageCount = count%15==0 ? count/15 : count/15+1;
                    data.put("totalPageCount",totalPageCount);

                    String s = mapper.writeValueAsString(data);
                    System.out.println("新闻数据："+s);

                    //发送
                    writer.println(s);
                }
            } else if(name.equals("topicLatest")){
//获取左侧  新闻内容
                //获取  5条  国内新闻
                List<News> newsByPageNo = newsServies.getNewsByPageNo(1, 1, 5);
                //5  guoji
                List<News> newsByPageNo2 = newsServies.getNewsByPageNo(2, 1, 5);
                //yule
                List<News> newsByPageNo1 = newsServies.getNewsByPageNo(5, 1, 5);

                //zhuafna
                req.setAttribute("list1",newsByPageNo);
                req.setAttribute("list2",newsByPageNo2);
                req.setAttribute("list3",newsByPageNo1);

                req.getRequestDispatcher("/index-elements/index_sidebar.jsp").forward(req,resp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        writer.flush();
        writer.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
