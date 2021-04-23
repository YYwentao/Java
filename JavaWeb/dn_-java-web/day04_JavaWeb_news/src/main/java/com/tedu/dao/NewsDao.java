package com.tedu.dao;

import com.tedu.pojo.News;
import com.tedu.pojo.NewsTopic;

import java.util.List;

/**
 * 写新闻  dao  接口  接口  接口
 */
public interface NewsDao  {

    /**
     * 获取全部的新闻主题
     * @return  新闻主题   实体类对象
     */
    public List<NewsTopic> getAllTopic();

    /**
     * 分页获取新闻信息
     * @param no
     * @param size
     * @return
     */
    public List<News> getNewsByPageNo(int no, int size);


    /**
     * 添加一条新闻
     * @param news
     * @return
     */
    public int addNews(News news);


    int getAllCount();

    int getCountByTid(int newtid);
    public List<News> getNewsByPageNo(int tid,int no, int size);

    List<News> getNewsById(int id);
}
