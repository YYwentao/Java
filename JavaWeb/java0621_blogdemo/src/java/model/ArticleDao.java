package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: ArticleDao
 * Description: 通过 ArticleDao 这个类对 Article 表实现数据库操作
 * date: 2021/6/20 16:00
 */
public class ArticleDao {
    //1.新增文章 add
    //执行插入文章操作
    public void add(Article article) {
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "insert into article  values(null,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());
            //3.执行 sql 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("执行插入文章操作失败");
                return;
            }
            System.out.println("执行插入文章操作成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            DBUtil.close(connection,statement,null);
        }
    }

    //2.查询全部文章列表(只是不显示正文,其他都显示)
    public List<Article> selectAll() {
        List<Article> list = new ArrayList<>();
        //1.获取数据库连接
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "select articleId,title,userId from article ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            //3.执行 sql 语句
            resultSet = statement.executeQuery();
            //4.遍历结果集
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                list.add(article);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
    //3.查询指定文章详情(显示指定所有内容,按照文章Id来查询)
    public Article selectById(int articleId) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "select * from article where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            //3.执行 sql 语句
            resultSet = statement.executeQuery();
            //4.遍历结果集
            if (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.释放资源
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    //4.删除所有文章(按照文章ID来删除)
    public void deleteByID(int articleId) {
        //1.连接数据库
        Connection connection = DBUtil.getConnection();
        //2.拼装 sql 语句
        String sql = "delete from article where articleId = ? ";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleId);
            //3.执行 sql 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("Id为"+articleId+"文章删除失败");
                return;
            }
            System.out.println("Id为"+articleId+"文章删除成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            DBUtil.close(connection,statement,null);
        }
    }

    public static void main(String[] args) {
        //1.测试 新增文章 add()
        //ArticleDao articleDao = new ArticleDao();
//        Article article = new Article();
//        article.setTitle("关于如何学好 javaWeb 编程语言的三个方法");
//        article.setContent("第一个方法，第二个方法，第三方法");
//        article.setUserId(1);
//        articleDao.add(article);

        //2.测试查询全部文章列表(只是不显示正文,其他都显示)
//        List<Article> list = articleDao.selectAll();
//        System.out.println(list);

        //3.测试查找指定文章内容
//        Article article = articleDao.selectById(1);
//        System.out.println(article);

        //4.测试删除指定ID的文章
//        articleDao.deleteByID(2);
    }
}
