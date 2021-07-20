package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DeleteMusicServlet
 * Description:
 * date: 2021/7/20 18:45
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/delete")
public class DeleteMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> return_map = new HashMap<>();

        String musicId = req.getParameter("id");
        int id = Integer.parseInt(musicId);
        System.out.println("要删除的 music id为："+id);

        MusicDao musicDao = new MusicDao();
        //如果没有找到该 id 的音乐，返回 null 后退出
        Music music = musicDao.findMusicById(id);
        if (music == null) return;

        int ret = musicDao.deleteMusicById(id);
        System.out.println("ret:" + ret);
        if (ret== 1) {
            //上面执行删除数据库操作(中间表已在dao层实现),并删除对应文件目录位置
            File file = new File("E:\\编程软件\\代码\\IdeaProjects\\JavaWeb\\my_music\\src\\main\\webapp\\" +
                    music.getUrl()+".mp3");
            if (file.delete()) {
                //删除成功
                return_map.put("msg",true);
                System.out.println("数据库和文件内容都删除成功了！上传文件记得用浏览器，Postman 要手动解密哦，踩坑+1");
            } else {
                return_map.put("msg",false);
            }
        } else {
            return_map.put("msg",false);
            System.out.println("出现问题了！数据库和文件不一致，数据库删了，但文件可能还在哦！");
        }
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),return_map);
    }
}
