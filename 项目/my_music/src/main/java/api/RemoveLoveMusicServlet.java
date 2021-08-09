package api;

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
 * ClassName: RemoveLoveMusicServlet
 * Description: 移除当前喜欢的音乐
 * date: 2021/7/21 20:22
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/removeLoveMusicServlet")
public class RemoveLoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> return_map = new HashMap<>();

        int musicId = Integer.parseInt(req.getParameter("id"));
        User user = (User) req.getSession().getAttribute("user");

        LoveMusicDao loveMusicDao = new LoveMusicDao();
        int ret = loveMusicDao.removeLoveMusic(user.getId(),musicId);
        if (ret != 1) {
            return_map.put("msg",false);
        } else {
            return_map.put("msg",true);
        }

        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),return_map);
    }
}
