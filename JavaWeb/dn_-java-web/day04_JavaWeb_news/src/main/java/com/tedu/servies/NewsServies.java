package com.tedu.servies;

import com.tedu.pojo.News;
import com.tedu.pojo.NewsTopic;

import java.util.List;

/**
 * 服务层接口
 */
public interface NewsServies {

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

    /**
     * 查询总页码数
     * @return
     */
    int getAllCount();

    /**
     * 通过  新闻类型  获取条数
     * @param newtid
     * @return
     */
    int getCountByTid(int newtid);

    public List<News> getNewsByPageNo(int tid,int no, int size);

    News getNewsById(int id);
}
