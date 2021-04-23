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
package club.xiaoandx.dao.impl;

import club.xiaoandx.dao.BaseDao;
import club.xiaoandx.dao.NewsDao;
import club.xiaoandx.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 新闻DAO </p>
 *  进行新闻数据的数据库操作
 * @version V1.0.0
 * @ClassName:NewsDao
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:07
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

    @Override
    public List<News> findAllNews() {
        String sql = "SELECT " +
                " n.nid,n.ntid,n.ntitle,n.nauthor,n.ncreateDate,n.npicPath," +
                " n.ncontent,n.nmodifyDate,n.nsummary " +
                " FROM " +
                " news as n";
        List<News> newsList = select(sql, News.class);
        return newsList;
}

    @Override
    public List<News> findAllNewsTitle() {
        String sql = "SELECT " +
                " n.nid,n.ntid,n.ntitle,n.ncreateDate,n.npicPath " +
                " FROM " +
                " news as n";
        ResultSet re = query(sql);
        List<News> newsTileList = null;
        try {
            newsTileList = new ArrayList<News>();
            while (re.next()) {
                News news = new News();
                news.setNid(re.getInt("nid"));
                news.setNtid(re.getInt("ntid"));
                news.setNtitle(re.getString("ntitle"));
                news.setNcreateDate(re.getTimestamp("ncreateDate"));
                news.setNpicPath(re.getString("npicPath"));
                newsTileList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            newsTileList = null;
        }
        return newsTileList;
    }

    @Override
    public List<News> findNewsByTid(int tid) {
        String sql = "SELECT " +
                "n.nid,n.ntid,n.ntitle,n.nauthor,n.ncreateDate,n.npicPath,n.ncontent," +
                "n.nmodifyDate,n.nsummary " +
                "FROM news as n " +
                "INNER JOIN topic as t " +
                "ON n.ntid = t.tid " +
                "WHERE tid = ?";

        List<News> newsList = select(sql, News.class, tid);
        return newsList;
    }

    /**
     * <p> 分页查询新闻数据集合 </p>
     *
     * @param toPage   第几页
     * @param pageSize 每页查询新闻数据量
     * @title: findNewsToPage
     * @date: 2021/4/22 11:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.News>
     * @throws:
     **/
    @Override
    public List<News> findNewsToPage(int toPage, int pageSize) {
        String sql = "SELECT * FROM news ORDER BY ncreateDate desc LIMIT ? , ?";
        List<News> newsToPageList = select(sql, News.class, toPage, pageSize);
        return newsToPageList;
    }

    /**
     * <p> 添加新闻 </p>
     *
     * @param n 新闻对象
     * @title: addNews
     * @date: 2021/4/22 11:30
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: int 操作结果
     **/
    @Override
    public int addNews(News n) {
        return 0;
    }

    /**
     * <p> 查询新闻总数 </p>
     *
     * @title: findTotalNews
     * @date: 2021/4/22 16:21
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: int
     * @throws:
     **/
    @Override
    public int findTotalNews() {
        int countNumber = 0;
        String sql = "SELECT COUNT(nid) FROM news";
        try {
            ResultSet query = query(sql);
            while (query.next()){
                countNumber = query.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countNumber;
    }

}