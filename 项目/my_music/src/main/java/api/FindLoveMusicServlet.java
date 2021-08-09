package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.LoveMusicDao;
import entity.Music;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: FindLoveMusicServlet
 * Description:    模糊匹配查看当前用户喜欢音乐的列表
 * date: 2021/7/21 18:13
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/findLoveMusicServlet")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //获取当前用户和查询关键字
        User user = (User) req.getSession().getAttribute("user");
        String str = req.getParameter("loveMusicName");
        //调用 dao 层执行 sql
        LoveMusicDao loveMusicDao = new LoveMusicDao();
        List<Music> musicList = null;
        if (str != null) {
            musicList = loveMusicDao.findLoveMusicByKeyAndUID(str,user.getId());
        } else {
            musicList = loveMusicDao.findLoveMusic(user.getId());
        }

        for (Music music: musicList) {
            System.out.println(music);
        }
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),musicList);
    }
}
