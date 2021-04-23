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

import club.xiaoandx.entity.News;
import club.xiaoandx.utils.PageModel;

import java.util.List;

/**
 * <p> 新闻逻辑控制server </p>
 * @version V1.0.0
 * @ClassName:NewsServer
 * @author: WEI.ZHOU
 * @date: 2021/4/22 11:01
 */
public interface NewsServer {

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
     * <p> 分页查询首页新闻标题简略信息 </p>
     * @title: findNewsToPage
     * @date: 2021/4/22 10:26
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @param toPage    第几页
     * @param pageSize  每页查询新闻数据量
     * @return: PageModel
     * @throws:
     **/
    PageModel findNewsToPage(int toPage, int pageSize);

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
}
