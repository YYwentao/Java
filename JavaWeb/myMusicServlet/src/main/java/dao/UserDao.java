package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName: UserDao
 * Description:
 * date: 2021/7/17 17:27
 *
 * @author wt
 * @since JDK 1.8
 */
public class UserDao {
    /**
     *  登录
     * 依据用户名查询，如果找不到，返回null,否则返回一个User对象（包含了用户的所有信息）
     */
    public User login(User loginUser) {
        Connection connection = DBUtil.getConnection();
        String sql = "Select * from user where username = ? and password = ?";
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,loginUser.getUsername());
            statement.setString(2,loginUser.getPassword());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAge(resultSet.getInt("age"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
            } else {
                System.out.println("登录失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return user;
    }
    /**
     * 注册
     */
    public void insertUser(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user values(null,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getAge());
            statement.setString(4,user.getGender());
            statement.setString(5,user.getEmail());
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("注册成功！");
            } else {
                System.out.println("注册失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,null);
        }
    }
}
