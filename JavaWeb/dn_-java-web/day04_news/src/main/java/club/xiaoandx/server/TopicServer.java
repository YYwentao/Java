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
package club.xiaoandx.server;

import club.xiaoandx.entity.Topic;
import club.xiaoandx.utils.PageModel;

import java.util.List;

/**
 * <p> 标签业务逻辑 </p>
 *  查询出现新闻标签
 * @version V1.0.0
 * @ClassName:TopicServer
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:57
 */
public interface TopicServer {
    /**
     * <p> 查询所有新闻类别 </p>
     * @title: findAll
     * @date: 2021/4/22 10:59
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.Topic>
     * @throws:
     **/
    List<Topic> findAll();

    /**
     * <p> 获取指定类型新闻分页数据 </p>
     * @title: findNewsByTid
     * @date: 2021/4/22 17:23
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param tid       类型id
     * @param toPage    查询的第几页
     * @param pageSize  每页数量
     * @return: club.xiaoandx.utils.PageModel
     **/
    PageModel findNewsByTid(int tid, int toPage, int pageSize);
}
