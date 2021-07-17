package dao;

import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MusicDao
 * Description:
 * date: 2021/7/17 17:27
 *
 * @author wt
 * @since JDK 1.8
 */
public class MusicDao {
    /**
     * 上传音乐
     * @param title
     * @param singer
     * @param time
     * @param url
     * @param userId
     * @return
     */
    public int insert(String title, String singer, String time, String url, int userId) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into music(title,singer,time,url,userId) values(?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,title);
            statement.setString(2,singer);
            statement.setString(3,time);
            statement.setString(4,url);
            statement.setInt(5,userId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("插入成功");
                return ret;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,null);
        }
        return 0;
    }
    /**
     * 查询全部歌单
     */
    public List<Music> findMusic(){
        Connection connection = DBUtil.getConnection();
        String sql = "select * from music";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return musicList;
    }
    /**
     * 根据id查找音乐
     * @param id
     * @return
     */
    public Music findMusicById(int id){
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Music music = null;
        String sql = "select * from music where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                music= new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                return music;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * 根据关键字查询歌单(模糊查询)
     */
    public List<Music> findMusicByKey(String str){
        List<Music> musicList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from music where title like ?";
        try {
            statement = connection.prepareStatement(sql);
            str = "%" +str+ "%";
            statement.setString(1,str);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return musicList;
    }
}
