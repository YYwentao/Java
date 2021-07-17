package dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: MusicDaoTest
 * Description:
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
        music.setTitle("我有一个道姑朋友");
        music.setSinger("双笙");
        music.setUrl("/music/");
        music.setTime("2021-07-17");
        music.setUserId(1);
        musicDao.insert(music.getTitle(),music.getSinger(),music.getUrl(),music.getTime(),music.getUserId());
    }

    @Test
    public void findMusic() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        musicDao.findMusic();
    }

    @Test
    public void findMusicById() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findMusicById(1));
    }

    @Test
    public void findMusicByKey() {
        Music music = new Music();
        MusicDao musicDao = new MusicDao();
        System.out.println(musicDao.findMusicByKey("一个"));
    }
}