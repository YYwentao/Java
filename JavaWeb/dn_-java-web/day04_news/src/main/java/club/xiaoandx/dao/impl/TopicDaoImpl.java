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
import club.xiaoandx.dao.TopicDao;
import club.xiaoandx.entity.News;
import club.xiaoandx.entity.Topic;
import club.xiaoandx.utils.PageModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 新闻标签 数据库操作SQL </p>
 *  针对新闻标签的操作
 * @version V1.0.0
 * @ClassName:TopicDao
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:27
 */
public class TopicDaoImpl extends BaseDao implements TopicDao {

    @Override
    public List<Topic> findAll(){
        String sql = "SELECT t.tid, t.tname FROM topic AS t";
        List<Topic> select = select(sql, Topic.class);
        return select;
    }

    /**
     * <p> 获取指定类型新闻分页数据 </p>
     * @param tid      类型id
     * @param toPage   查询第几页
     * @param pageSize 每页数据量
     * @title: findNewsByTid
     * @date: 2021/4/22 17:25
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: List<News>
     **/
    @Override
    public List<News> findNewsByTid(int tid, int toPage, int pageSize) {
        String sql = "SELECT * FROM news as ns INNER JOIN topic as t ON ns.ntid = t.tid  " +
                "WHERE tid = ? ORDER BY ns.ncreateDate DESC LIMIT ?,?";
        List<News> select = select(sql, News.class, tid, toPage, pageSize);
        return select;
    }

    /**
     * <p> 获取指定类型新闻的总数 </p>
     *
     * @param tid 新闻类型ID
     * @title: getNewsNumberByTid
     * @date: 2021/4/22 18:12
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: int 数量
     * @throws:
     **/
    @Override
    public int getNewsNumberByTid(int tid) {
        int countNumber = 0;
        String sql = "SELECT COUNT(1) FROM news as ns INNER JOIN topic as t ON ns.ntid = t.tid  " +
                "WHERE tid = ? ";
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
