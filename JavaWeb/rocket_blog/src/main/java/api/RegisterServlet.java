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
 * ClassName: RegisterServlet
 * Description:
 * date: 2021/7/26 16:37
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 1. 获取请求中的参数内容
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
            resp.sendError(404,"用户名或密码不能为空");
            return;
        }
        // 2. 查询数据库,看用户名是否存在
        UserDao userDao = new UserDao();
        User existUser = userDao.selectByName(username);
        if (existUser != null) {
            resp.sendError(404,"用户名已存在,注册失败！");
            return;
        }
        // 3. 构造 User 对象，插入到数据库中
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insert(user);

        resp.getWriter().write("<h3>注册成功!</h3>");
    }
}
