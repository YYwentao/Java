package api;

import dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LogoutServlet
 * Description:     注销当前用户
 * date: 2021/7/24 20:26
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession(false);
        if (session == null) {
//            resp.sendError(404,"当前尚未登录！不能注销！");
            resp.getWriter().write("<h3>当前尚未登录！不能注销！</h3>");
            return;
        }
        session.removeAttribute("user");
        resp.sendRedirect("blog_list");
    }
}
