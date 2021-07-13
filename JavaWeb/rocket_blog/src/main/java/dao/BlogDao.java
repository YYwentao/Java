package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ClassName: BlogDao
 * Description:
 * date: 2021/7/13 17:56
 */
public class BlogDao {
    //从数据库里面插入一篇博客
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
    //从数据库删除博客
    public void delele(int blogId) {

    }
    //从数据库查看所有博客
    //从数据库按照 Id 查看一篇博客

}
