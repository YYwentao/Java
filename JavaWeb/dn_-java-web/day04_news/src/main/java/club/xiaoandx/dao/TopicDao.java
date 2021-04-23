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
package club.xiaoandx.dao;

import club.xiaoandx.entity.News;
import club.xiaoandx.entity.Topic;
import club.xiaoandx.utils.PageModel;

import java.util.List;

/**
 * <p> 新闻标签持久层接口 </p>
 *
 * @version V1.0.0
 * @ClassName:TopicDao
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:47
 */
public interface TopicDao {

    /**
     * <p> 查询新闻所有的标签列表 </p>
     * @title: findAll
     * @date: 2021/4/22 10:33
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.Topic>
     **/
    List<Topic> findAll();

    /**
     * <p> 获取指定类型新闻分页数据 </p>
     * @title: findNewsByTid
     * @date: 2021/4/22 17:25
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param tid       类型id
     * @param toPage    查询第几页
     * @param pageSize  每页数据量
     * @return: List<News>
     **/
    List<News> findNewsByTid(int tid, int toPage, int pageSize);

    /**
     * <p> 获取指定类型新闻的总数 </p>
     * @title: getNewsNumberByTid
     * @date: 2021/4/22 18:12
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param tid   新闻类型ID
     * @return: int 数量
     * @throws:
     **/
    int getNewsNumberByTid(int tid);
}
