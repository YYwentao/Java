package dao;

import entity.Music;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: LoveMusicDaoTest
 * Description:
 * date: 2021/7/19 10:41
 *
 * @author wt
 * @since JDK 1.8
 */
public class LoveMusicDaoTest {

    @Test
    public void insertLoveMusic() {
        LoveMusicDao loveMusicDao = new LoveMusicDao();
        loveMusicDao.insertLoveMusic(1,1);
        loveMusicDao.insertLoveMusic(1,2);
    }

    @Test
    public void findLoveMusic() {
        LoveMusicDao loveMusicDao = new LoveMusicDao();
        List<Music> musicList = loveMusicDao.findLoveMusic(1);
        for (Music music:musicList) {
            System.out.println(music);
        }
    }


    @Test
    public void findLoveMusicByKeyAndUID() {
        LoveMusicDao loveMusicDao = new LoveMusicDao();
        System.out.println(loveMusicDao.findLoveMusicByKeyAndUID("人间", 1));
    }

    @Test
    public void removeLoveMusic() {
        LoveMusicDao loveMusicDao = new LoveMusicDao();
        System.out.println(loveMusicDao.removeLoveMusic(1, 1));
    }
}