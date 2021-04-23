package club.xiaoandx.dao.impl;

import club.xiaoandx.dao.NewsDao;
import club.xiaoandx.entity.News;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NewsDaoImplTest {

    @Test
    public void findAllNews() {
        NewsDao newsDao = new NewsDaoImpl();
        List<News> allNews = newsDao.findAllNews();
        System.out.println(allNews);

    }

    @Test
    public void findAllNewsTitle() {
        NewsDao newsDao = new NewsDaoImpl();
        List<News> allNewsTitle = newsDao.findAllNewsTitle();
        System.out.println(allNewsTitle);
    }

    @Test
    public void findNewsByTid() {
        NewsDao newsDao = new NewsDaoImpl();
        List<News> newsByTid = newsDao.findNewsByTid(7);
        System.out.println(newsByTid);
    }

    @Test
    public void findNewsToPage() {
        NewsDao newsDao = new NewsDaoImpl();
        List<News> newsToPage = newsDao.findNewsToPage(1, 5);
        System.out.println(newsToPage);
    }

    @Test
    public void findTotalNews(){
        NewsDao newsDao = new NewsDaoImpl();
        int totalNews = newsDao.findTotalNews();
        System.out.println(totalNews);
    }
}