package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        String sql = "insert into * from values(null,?,?,?)";
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

    //2.查询全部文章标题
    
}
