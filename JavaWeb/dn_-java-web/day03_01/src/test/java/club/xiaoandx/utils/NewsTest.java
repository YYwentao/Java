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
package club.xiaoandx.utils;

import club.xiaoandx.entity.Comments;
import club.xiaoandx.entity.News;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 新闻信息JDBC测试类 </p>
 *
 * @version V1.0.0
 * @ClassName:NewsTest
 * @author: WEI.ZHOU
 * @date: 2021/4/21 18:42
 */
public class NewsTest {

    /**
     * <p> 查询所有新闻 </p>
     * @title: findAllNews
     * @date: 2021/4/21 19:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void findAllNews() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String sql = "SELECT n.nid,n.ntid,n.ntitle,n.nauthor,n.ncontent,n.ncreateDate,n.npicPath," +
                "n.ncontent,n.nmodifyDate,n.nsummary  FROM news as n";
        ResultSet re = JDBC.getResult(sql, statement);
        List<News> newsList = new ArrayList<News>();
        while (re.next()) {
            News news = new News();
            news.setNid(re.getInt("nid"));
            news.setNtid(re.getInt("ntid"));
            news.setNtitle(re.getString("ntitle"));
            news.setNauthor(re.getString("nauthor"));
            news.setNcreateDate(re.getTimestamp("ncreateDate"));
            news.setNpicPath(re.getString("npicPath"));
            news.setNcontent(re.getString("ncontent"));
            news.setNmodiffyDate(re.getTimestamp("nmodifyDate"));
            news.setNsummary(re.getString("nsummary"));
            news.setComm(null);
            newsList.add(news);
        }
        for(News n : newsList){
            System.out.println(n.toString());
        }
        JDBC.close(re, statement, null, conn);
    }

    /**
     * <p> 添加一条新闻  </p>
     * @title: addNew
     * @date: 2021/4/21 19:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void addNew() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "INSERT INTO news " +
                "(ntid,ntitle,nauthor,ncontent,ncreateDate,npicPath,nmodifyDate,nsummary)  " +
                "VALUES " +
                "(1,'李克强在四川','news','新华社成都4月2','2021-04-20 10:46:39','','2021-04-20 10:46:39','')" ;

        int statc = JDBC.exeUpdata(sql, statement);
        if(statc == 0){
            System.out.println("插入新闻失败");
        }
        System.out.println("插入新闻成功");
        JDBC.close(null, statement, null, conn);
    }

    /**
     * <p> 删除一条新闻  </p>
     * @title: addNew
     * @date: 2021/4/21 19:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void romoveNewByid() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = "DELETE FROM news WHERE nid = 189" ;
        int statc = JDBC.exeUpdata(sql, statement);
        if(statc == 0){
            System.out.println("删除新闻失败");
        }
        System.out.println("删除新闻成功");
        JDBC.close(null, statement, null, conn);
    }

    /**
     * <p> 修改一条新闻  </p>
     * @title: addNew
     * @date: 2021/4/21 19:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void updateNewByid() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String  sql = " UPDATE news SET ntid = 3 WHERE nid =190" ;
        int statc = JDBC.exeUpdata(sql, statement);
        if(statc == 0){
            System.out.println("修改新闻失败");
        }
        System.out.println("修改新闻成功");
        JDBC.close(null, statement, null, conn);
    }

    /**
     * <p> 查询一种类型的所有新闻 </p>
     * @title: findAllNews
     * @date: 2021/4/21 19:04
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void findNewsByTopic() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String sql = "SELECT n.nid,n.ntid,n.ntitle,n.nauthor,n.ncontent,n.ncreateDate,n.npicPath," +
                "n.ncontent,n.nmodifyDate,n.nsummary FROM news as n INNER JOIN topic as t ON n.ntid = t.tid WHERE tid = 1";
        ResultSet re = JDBC.getResult(sql, statement);
        List<News> newsList = new ArrayList<News>();
        while (re.next()) {
            News news = new News();
            news.setNid(re.getInt("nid"));
            news.setNtid(re.getInt("ntid"));
            news.setNtitle(re.getString("ntitle"));
            news.setNauthor(re.getString("nauthor"));
            news.setNcreateDate(re.getTimestamp("ncreateDate"));
            news.setNpicPath(re.getString("npicPath"));
            news.setNcontent(re.getString("ncontent"));
            news.setNmodiffyDate(re.getTimestamp("nmodifyDate"));
            news.setNsummary(re.getString("nsummary"));
            news.setComm(null);
            newsList.add(news);
        }
        for(News n : newsList){
            System.out.println(n.toString());
        }
        JDBC.close(re, statement, null, conn);
    }

    /**
     * <p> 查询对应新闻的全部评论 </p>
     * @title: findNewsAllByNid
     * @date: 2021/4/21 19:52
     * @author: WEI.ZHOU
     * @version: v1.0.0
     * @return: void
     * @throws:
     **/
    @Test
    public void findNewsAllByNid() throws SQLException {
        Connection conn = JDBC.getConn();
        Statement statement = JDBC.getstatement(conn);
        String sql = "SELECT " +
                "n.nid,n.ntid,n.ntitle,nauthor,n.ncreateDate,n.npicPath,n.ncontent,n.nmodifyDate,n.nsummary," +
                "c.ccontent,c.cdate,c.cauthor " +
                "from news AS n INNER JOIN comments AS c " +
                "ON n.nid = c.cnid " +
                "WHERE n.nid = 108";
        ResultSet re = JDBC.getResult(sql, statement);
        List<News> newsList = new ArrayList<News>();
        while (re.next()) {
            News news = new News();
            news.setNid(re.getInt("nid"));
            news.setNtid(re.getInt("ntid"));
            news.setNtitle(re.getString("ntitle"));
            news.setNauthor(re.getString("nauthor"));
            news.setNcreateDate(re.getTimestamp("ncreateDate"));
            news.setNpicPath(re.getString("npicPath"));
            news.setNcontent(re.getString("ncontent"));
            news.setNmodiffyDate(re.getTimestamp("nmodifyDate"));
            news.setNsummary(re.getString("nsummary"));
            //  评论数据对象
            Comments com = new Comments();
            com.setCcontent(re.getString("ccontent"));
            com.setCdata(re.getTimestamp("cdate"));
            com.setCauthor(re.getString("cauthor"));
            news.setComm(com);
            newsList.add(news);
        }
        for(News n : newsList){
            System.out.println(n.toString());
        }
        JDBC.close(re, statement, null, conn);
    }
}
