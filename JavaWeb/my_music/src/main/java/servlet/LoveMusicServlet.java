package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.LoveMusicDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoveMusicServlet
 * Description: 处理 添加喜欢的音乐 逻辑
 * date: 2021/7/21 16:57
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/loveMusic")
public class LoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> return_map = new HashMap<>();

        int musicId = Integer.parseInt(req.getParameter("id"));
        // 获取当前用户的 Id
        User user = (User) req.getSession().getAttribute("user");
        int userId = user.getId();

        LoveMusicDao loveMusicDao = new LoveMusicDao();
        //插入之前需要先查看是否该音乐已经被添加到喜欢列表
        boolean effect = loveMusicDao.findLoveMusicByMusicIdAndUserId(userId,musicId);
        if (effect) {
            return_map.put("msg",false);
        } else {
            if (loveMusicDao.insertLoveMusic(userId,musicId)) {
                return_map.put("msg",true);
            } else {
                return_map.put("msg",false);
            }
        }
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),return_map);
    }
}
