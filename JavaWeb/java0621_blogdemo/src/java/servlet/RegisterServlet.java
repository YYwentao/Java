package servlet;

import jump.HtmlGenerator;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: RegisterServlet
 * Description:
 * date: 2021/6/21 21:37
 */
public class RegisterServlet extends HttpServlet {
    //浏览器通过 POST 请求提交注册信息给服务器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.获取前端提交的数据，用户名和密码是否符合
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name) || password == null || "".equals(password)) {
            //输入错误提示并跳转页面
            String html = HtmlGenerator.getMessagePage("用户名或密码输入错误","register.html");
            resp.getWriter().write(html);
            return;
        }
        //2.对比数据库里面的用户名，查看是否存在
        UserDao userDao = new UserDao();
        if (userDao.selectByName(name) != null) {
            //如果有返回值就说明用户就存在了,注册失败跳转页面
            String html = HtmlGenerator.getMessagePage("当前注册用户名已存在,请重新输入","register.html");
            resp.getWriter().write(html);
            return;
        }
        //3.构造 User 对象插入到数据库
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDao.add(user);
        //4.返回结果页面，提示注册成功
        String html = HtmlGenerator.getMessagePage("注册成功！返回登录页面！","login.html");
        resp.getWriter().write(html);
    }
}
