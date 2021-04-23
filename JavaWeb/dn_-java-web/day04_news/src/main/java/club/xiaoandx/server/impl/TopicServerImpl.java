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
package club.xiaoandx.server.impl;

import club.xiaoandx.dao.TopicDao;
import club.xiaoandx.dao.impl.TopicDaoImpl;
import club.xiaoandx.entity.News;
import club.xiaoandx.entity.Topic;
import club.xiaoandx.server.TopicServer;
import club.xiaoandx.utils.PageModel;

import java.util.List;

/**
 * <p>  </p>
 *
 * @version V1.0.0
 * @ClassName:TopicServerImpl
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:58
 */
public class TopicServerImpl implements TopicServer {

    /**
     * <p> 查询所有新闻类别 </p>
     *
     * @title: findAll
     * @date: 2021/4/22 10:59
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.Topic>
     * @throws:
     **/
    @Override
    public List<Topic> findAll() {
        TopicDao topicDao = new TopicDaoImpl();
        return topicDao.findAll();
    }

    /**
     * <p> 获取指定类型新闻分页数据 </p>
     * @param tid       类型id
     * @param toPage   查询的第几页
     * @param pageSize 总记录数
     * @title: findNewsByTid
     * @date: 2021/4/22 17:23
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: club.xiaoandx.utils.PageModel
     **/
    @Override
    public PageModel findNewsByTid(int tid, int toPage, int pageSize) {
        TopicDao topicDao = new TopicDaoImpl();
        int newsCountByTid = topicDao.getNewsNumberByTid(tid);
        PageModel pageModel = new PageModel(toPage, newsCountByTid);
        List<News> newsByTid = topicDao.findNewsByTid(tid, toPage, pageSize);
        pageModel.setList(newsByTid);
        return pageModel;
    }
}

