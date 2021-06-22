package servlet;

import jump.HtmlGenerator;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName: LoginServlet
 * Description:
 * date: 2021/6/22 0:25
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取用户名和密码,并进行简单校验
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name) || password == null || "".equals(password)) {
            String html = HtmlGenerator.getMessagePage("用户名或密码为空","login.html");
            resp.getWriter().write(html);
            return;
        }
        //2.对比数据库中用户名是否存在
        //3.再对比密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(name);
        if (user == null || !password.equals(user.getPassword())) {
            //如果返回值为null,就说明用户名不存在
            String html = HtmlGenerator.getMessagePage("用户名或密码错误","login.html");
            resp.getWriter().write(html);
            return;
        }
        //4.匹配成功说明登录成功,并创建一个 Session
        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("user",user);
        //5.返回一个登录成功的提示页面
        String html = HtmlGenerator.getMessagePage("登陆成功","article");
        resp.getWriter().write(html);
    }
}
