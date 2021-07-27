package dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: BlogDaoTest
 * Description:
 * date: 2021/7/14 16:24
 */
public class BlogDaoTest {

    @Test
    public void insert() {
        Blog blog = new Blog();
        BlogDao blogDao = new BlogDao();
        blog.setTitle("我是第三篇博客");
        blog.setContent("浏览器(客户端)首次访问服务器(请求中是不存在Cookie的)，当用户访问成功后，服务器就会创建一种数据结构来保存用户的信息，这种数据结构就是 Hash 表(Key-Value，唯一的键对应唯一的值)，还会在服务器内部生成一个Session对象(用来保存用户信息)，并且给这个Session对象(Value)分配唯一一个SessionId(Key)，然后再把这个 SessionId 和 Session 对象以键值对的形式插入到 Hash 表中。服务器这边处理完成了之后，返回给客户端的响应中 Set-Cookie 字段里就包含当前SessionId，而在客户端这边就把这个值保存在了本地，被称为 Cookie(本质上是字符串，上图中使用数字表示是为了方便理解)。\n" );
        blog.setUserId(1);
        blogDao.insert(blog);
    }

    @Test
    public void delete() {
//        BlogDao blogDao = new BlogDao();
//        blogDao.delete(1);

    }

    @Test
    public void selectAll() {
        BlogDao blogDao = new BlogDao();
        System.out.println(blogDao.selectAll());
    }

    @Test
    public void selectById() {
        BlogDao blogDao = new BlogDao();
        System.out.println(blogDao.selectById(2));
    }
}