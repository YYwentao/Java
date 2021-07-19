package dao;

import entity.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LoveMusicDao
 * Description:
 * date: 2021/7/19 10:27
 *
 * @author wt
 * @since JDK 1.8
 */
public class LoveMusicDao {
    /**
     * 添加音乐到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表
     */
    public boolean insertLoveMusic(int userId,int musicId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "insert into lovemusic(user_id,music_id) values (?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setInt(2,musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,null);
        }
        return false;
    }
    /**
     * 查询当前用户(user_id)喜欢的音乐列表
     */
    public List<Music> findLoveMusic(int user_id){
        List<Music> musicList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select music.id,title,singer,time,url,userId from lovemusic,music " +
                "where lovemusic.music_id = music.id and user_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,user_id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("music.id"));
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
     * 添加喜欢的音乐的时候，需要先判断该音乐是否存在(预防重复添加喜欢)
     * @param music_id
     * @return
     */
    public boolean findLoveMusicByMusicIdAndUserId(int user_id,int music_id) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from lovemusic where user_id=? and music_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,user_id);
            statement.setInt(2,music_id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return false;
    }
    /**
     * 根据关键字查询喜欢的歌单 (模糊查询)
     * @param str
     * @return
     */
    public List<Music> findLoveMusicByKeyAndUID(String str,int user_id){
        List<Music> musicList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select music.id,title,singer,time,url,userId from lovemusic,music where " +
                "lovemusic.music_id = music.id and user_id=? and title like ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,user_id);
            str = "%"+str+"%";
            statement.setString(2,str);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("music.id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                music.setUserId(resultSet.getInt("userId"));
                musicList.add(music);
            }
            return musicList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,resultSet);
        }
        return null;
    }
    /**
     * @param userId 用户id
     * @param musicId 歌曲id
     * @return 返回受影响的行数
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢，所以需要传入当前用户的id
     */
    public int removeLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "delete from lovemusic where user_id=? and music_id=?";
        try {

            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,musicId);
            int ret = preparedStatement.executeUpdate();
            if(ret == 1) {
                return ret;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.getClose(connection,preparedStatement,null);
        }
        return 0;
    }

}
