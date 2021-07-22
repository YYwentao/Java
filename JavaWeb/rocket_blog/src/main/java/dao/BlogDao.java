package dao;

import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BlogDao
 * Description:
 * date: 2021/7/13 17:56
 */
public class BlogDao {
    /**
     * 从数据库里面插入一篇博客
     */
    public void insert(Blog blog) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into blog values(null,?,?,?,now())";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,blog.getTitle());
            statement.setString(2,blog.getContent());
            statement.setInt(3,blog.getBlogId());
            //执行
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,null);
        }
    }

    /**
     * 从数据库删除博客
     */
    public void delete(int blogId) {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from blog where blogId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            //执行 sql
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,null);
        }
    }
    /**
     * 从数据库查看所有博客
     */
    public List<Blog> selectAll () {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //遍历结果集到 blogs 里面
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                String content = resultSet.getString("content");
                if (content.length() > 110) {
                    content = content.substring(0,110) + "...";
                }
                blog.setContent(content);
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return blogs;
    }

    /**
     * 从数据库按照 Id 查看一篇博客
     */
    public Blog selectById(int blogId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog where blogId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,blogId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                return blog;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
}













