package com.tedu.servies;

import com.tedu.dao.NewsDao;
import com.tedu.dao.NewsDaoImpl;
import com.tedu.pojo.News;
import com.tedu.pojo.NewsTopic;

import java.util.List;

/**
 * 新闻服务层接口实现类
 */
public class NewsServiesImpl implements NewsServies {

    //调用dao
    NewsDao dao = new NewsDaoImpl();

    @Override
    public List<NewsTopic> getAllTopic() {
        return dao.getAllTopic();
    }

    @Override
    public List<News> getNewsByPageNo(int no, int size) {
        return dao.getNewsByPageNo(no,size);
    }

    @Override
    public int addNews(News news) {
        return dao.addNews(news);
    }

    @Override
    public int getAllCount() {
        return dao.getAllCount();
    }

    @Override
    public int getCountByTid(int newtid) {
        return dao.getCountByTid(newtid);
    }

    @Override
    public List<News> getNewsByPageNo(int tid, int no, int size) {
        return dao.getNewsByPageNo(tid,no,size);
    }

    @Override
    public News getNewsById(int id) {
        List<News> newsById = dao.getNewsById(id);
        if (newsById.size()>0){
            return newsById.get(0);
        }
        return null;
    }
}
