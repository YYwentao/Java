package com.tedu.dao;

import com.tedu.pojo.News;
import com.tedu.pojo.NewsTopic;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 新闻  dao  接口实现类
 */
public class NewsDaoImpl extends BaseDao  implements NewsDao{
    @Override
    public List<NewsTopic> getAllTopic() {
        //对比使用框架的好处
        String sql = "SELECT * FROM topic";
//        ResultSet query = query(sql);
//        List<NewsTopic> data = new ArrayList<>();
//        //解析
//        try{
//            while (query.next()){
//                //对结果集解析   解析区别：字段名不一样-----字段名====属性
//                NewsTopic newsTopic = new NewsTopic();
//                newsTopic.setTid(query.getInt("tid"));
//                newsTopic.setTname(query.getString("tname"));
//                data.add(newsTopic);
//            }
//        }catch (Exception e){
//
//        }
        return select(NewsTopic.class,sql);
    }

    @Override
    public List<News> getNewsByPageNo(int no, int size) {
        String sql = "SELECT * FROM news ORDER BY ncreateDate LIMIT ? , ? ";
        return select(News.class,sql,(no-1)*size,size);
    }

    @Override
    public int addNews(News news) {
        String sql = "INSERT INTO `news`(字段名) VALUES (?,?,?,?) ";

        return  updata(sql,news.getNauthor(),news.getNcontent());
    }


    @Override
    public int getAllCount() {
            String sql = "SELECT COUNT(*) FROM news";
        return selectToInt(sql);
    }

    @Override
    public int getCountByTid(int newtid) {
        String sql = "SELECT COUNT(*) FROM news where ntid = ?";
        return selectToInt(sql,newtid);
    }

    @Override
    public List<News> getNewsByPageNo(int tid, int no, int size) {
        String sql = "SELECT * FROM news where ntid = ? ORDER BY ncreateDate LIMIT ? , ? ";
        return select(News.class,sql,tid,no,size);
    }

    @Override
    public List<News> getNewsById(int id) {
        String sql = "SELECT * FROM news where nid = ?";
        return select(News.class,sql,id);
    }
}
