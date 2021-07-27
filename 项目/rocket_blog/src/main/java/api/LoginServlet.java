package api;

import dao.User;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Description:
 * date: 2021/7/24 17:09
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
//            resp.sendError(404,"用户名或密码不能为空");
            resp.getWriter().write("<h3>用户名或密码不能为空</h3>");
            return;
        }
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if (user == null) {
//            resp.sendError(404,"用户名或密码不存在");
            resp.getWriter().write("<h3>用户名或密码错误</h3>");
            return;
        }
        if (!password.equals(user.getPassword())) {
//            resp.sendError(404,"用户名或密码不存在");
            resp.getWriter().write("<h3>用户名或密码错误</h3>");
            return;
        }
        //登录成功后！创建会话
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("blog_list");
    }
}
