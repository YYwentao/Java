package club.xiaoandx.servlet;

import club.xiaoandx.dao.UserDao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 用户注册Servlet </p>
 *
 * @version V1.0.0
 * @ClassName:RegisteServlet
 * @author: WEI.ZHOU
 * @date: 2021/4/20 18:41
 */
public class RegisteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_two = req.getParameter("passwords");
        if (password.equals("") || password_two.equals("") || !password.equals(password_two)) {
            req.setAttribute("inf", "注册输入的账号密码为空");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            try {
                UserDao.registe(username, password);
            } catch (Exception e) {
                req.setAttribute("inf", "注册失败");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
            req.setAttribute("inf", "注册成功，请进行登录");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}