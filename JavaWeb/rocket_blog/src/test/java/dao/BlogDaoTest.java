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
        blog.setTitle("这是标题1");
        blog.setContent("这是正文内容1");
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