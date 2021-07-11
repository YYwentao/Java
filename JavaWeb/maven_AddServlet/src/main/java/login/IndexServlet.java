package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: IndexServlet
 * Description:
 * date: 2021/7/11 13:06
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(302);
            resp.sendRedirect("login.html");
            return;
        }
        //登陆成功后，获取Session 的里面的数据
        String username = (String) session.getAttribute("name");
        String school = (String) session.getAttribute("school");
        Long time = (Long) session.getAttribute("time");
        //重新设置上次登录时间
        session.setAttribute("time",System.currentTimeMillis());
        //实现访问次数增加
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        visitCount = visitCount+1;
        //重新设置 visitCount 次数
        session.setAttribute("visitCount",visitCount);
        //在页面上显示
        String html = String.format("<h3>欢迎您: %s</h3>",username);
        html+=String.format("<div>学校: %s</div>",school);
        html+=String.format("<div>上次登录时间: %s</div>",time);
        html+=String.format("<div>访问次数: %d</div>",visitCount);
        resp.getWriter().write(html);

    }
}
