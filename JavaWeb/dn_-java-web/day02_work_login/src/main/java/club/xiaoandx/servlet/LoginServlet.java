package club.xiaoandx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import club.xiaoandx.dao.UserDao;

/**
 * <p> 用户登录Servlet </p>
 *
 * @version V1.0.0
 * @ClassName:LoginServlet
 * @author: WEI.ZHOU
 * @date: 2021/4/20 18:41
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String user_checkCode = req.getParameter("ucheckC");
        HttpSession session = req.getSession();
        String checkCode = (String) session.getAttribute("code");
        session.removeAttribute("code");
        if (user_checkCode.equals(checkCode)) {
            try {
                if (UserDao.checkLogin(username, password)) {
                    req.getRequestDispatcher("/findUserList").forward(req, resp);
                } else {
                    req.setAttribute("inf", "你的账号或密码错误，请确认账号密码登录");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            req.setAttribute("inf", "验证码错误注意大小写");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}