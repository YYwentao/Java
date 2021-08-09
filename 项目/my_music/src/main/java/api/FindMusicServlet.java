package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;
import entity.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: FindMusicServlet
 * Description:    模糊匹配查询所有用户当前音乐列表
 * date: 2021/7/20 16:43
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/findMusicServlet")
public class FindMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;  charset=utf-8");

        String str = req.getParameter("musicName");
        List<Music> musicList = null;
        MusicDao musicDao = new MusicDao();

        if (str == null || "".equals(str)) {
            musicList = musicDao.findMusic();
        } else {
            musicList = musicDao.findMusicByKey(str);
        }
        for (Music music:musicList) {
            System.out.println(music);
        }
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),musicList);
    }
}
