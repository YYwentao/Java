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
    /**
     * 删除歌曲：
     */
    public int deleteMusicById(int musicId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "delete from music where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                //删除的同时要先查看中间表(喜欢的音乐)的是否有数据,有数据就必须同时删除中间表数据。
                if (findLoveMusicById(musicId)) {
                    int tmp = deleteLoveMusicById(musicId);
                    if (tmp == 1) {
                        System.out.println("删除成功！");
                        return 1;
                    }
                    return 0;
                } else {
                    //如果没有找到,就说明在喜欢列表没有这首歌,没有被添加到喜欢列表
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,null);
        }
        return 0;
    }

    /**
     * 看中间表是否有该id的音乐数据
     */
    public boolean findLoveMusicById(int musicId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from lovemusic where music_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,musicId);
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
     * 当删除服务器上的音乐时，同时在我喜欢的列表的数据库中进行删除。
     * @param musicId
     * @return
     */
    public int deleteLoveMusicById(int musicId) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        String sql = "delete from lovemusic where music_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("喜欢的音乐删除成功！");
                return ret;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.getClose(connection,statement,null);
        }
        return 0;
    }

}
