package dao;

import entity.Music;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: MusicDaoTest
 * Description: 单元测试 MusicDao
 * date: 2021/7/17 22:57
 *
 * @author wt
 * @since JDK 1.8
 */
public class MusicDaoTest {

    @Test
    public void insert() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        music.setTitle("盗墓笔记-十年人间");
        music.setSinger("群星");
        music.setUrl("2021-07-18");
        music.setTime("/music/");
        music.setUserId(2);
        musicDao.insert(music.getTitle(),music.getSinger(),music.getUrl(),music.getTime(),music.getUserId());
    }

    @Test
    public void findMusic() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findMusic();
        for (Music music1:musicList) {
            System.out.println(music1);
        }
    }

    @Test
    public void findMusicById() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findMusicById(2));
    }

    @Test
    public void findMusicByKey() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findMusicByKey(""));
    }


    @Test
    public void deleteMusicById() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.deleteMusicById(2));
    }

    @Test
    public void findLoveMusicById() {
    }

    @Test
    public void testFindLoveMusicById() {
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.deleteLoveMusicById(3));
    }
}