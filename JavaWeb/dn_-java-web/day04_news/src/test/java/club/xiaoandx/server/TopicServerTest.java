package club.xiaoandx.server;

import club.xiaoandx.dao.TopicDao;
import club.xiaoandx.dao.impl.TopicDaoImpl;
import club.xiaoandx.entity.News;
import club.xiaoandx.entity.Topic;
import club.xiaoandx.server.impl.NewsServerImpl;
import club.xiaoandx.server.impl.TopicServerImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TopicServerTest {

    @Test
    public void findAll() {
        TopicServer topicServer = new TopicServerImpl();
        NewsServer newsServer = new NewsServerImpl();
        List<News> NewsTitle = newsServer.findAllNewsTitle();
        List<Topic> topicList = topicServer.findAll();

        for(Topic t :topicList){
            System.out.println(t.toString());
        }
        for(News t :NewsTitle){
            System.out.println(t.toString());
        }
    }
}