package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Description:
 * date: 2021/7/11 10:15
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected String username = "wt";
    protected String password = "123";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html; charset=utf-8");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
            resp.setStatus(403);
            resp.getWriter().write("<h3>密码错误</h3>");
            return;
        }
        if (!username.equals(this.username) || !password.equals(this.password)) {
            resp.setStatus(403);
            resp.getWriter().write("<h3>密码错误</h3>");
            return;
        }
        HttpSession session =  req.getSession(true);
        session.setAttribute("name",username);
        session.setAttribute("school","宜宾学院");
        session.setAttribute("time",System.currentTimeMillis());
        session.setAttribute("visitCount",0);
        //登录成功，重定向跳转首页
        resp.setStatus(302);
        resp.sendRedirect("index.html");
    }
}
