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

import java.util.List;

/**
 * <p> 新闻持久层接口 </p>
 *
 * @version V1.0.0
 * @ClassName:NewsDao
 * @author: WEI.ZHOU
 * @date: 2021/4/22 10:48
 */
public interface NewsDao {

    /**
     * <p> 查询所有的新闻数据  </p>
     * @title: findAllNews
     * @date: 2021/4/22 10:19
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.News>
     * @throws: SQL错误异常
     **/
    List<News> findAllNews();

    /**
     * <p> 查询首页新闻标题简略信息 </p>
     * @title: findAllNewsTitle
     * @date: 2021/4/22 10:26
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: java.util.List<club.xiaoandx.entity.News>
     * @throws:
     **/
    List<News> findAllNewsTitle();

    /**
     * <p> 查询指定类型的所有新闻 </p>
     * @title: findNewsByTid
     * @date: 2021/4/22 10:56
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param tid 标签id
     * @return: java.util.List<club.xiaoandx.entity.News>
     * @throws:
     **/
    List<News> findNewsByTid(int tid);

    /**
     * <p> 分页查询新闻数据集合 </p>
     * @title: findNewsToPage
     * @date: 2021/4/22 11:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param toPage    第几页
     * @param pageSize  每页查询新闻数据量
     * @return: java.util.List<club.xiaoandx.entity.News>
     * @throws:
     **/
    List<News> findNewsToPage(int toPage, int pageSize);

    /**
     * <p> 添加新闻 </p>
     * @title: addNews
     * @date: 2021/4/22 11:30
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param n     新闻对象
     * @return: int 操作结果
     **/
    int addNews(News n);

    /**
     * <p> 查询新闻总数 </p>
     * @title: findTotalNews
     * @date: 2021/4/22 16:21
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: int
     * @throws:
     **/
    int findTotalNews();
}
