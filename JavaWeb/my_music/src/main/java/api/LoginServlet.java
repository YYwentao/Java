package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDao;
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
 * ClassName: LoginServlet
 * Description: 登录创建 Session 对象
 * date: 2021/7/19 14:55
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);

        UserDao userDao = new UserDao();

        Map<String,Object> return_map = new HashMap<>(); //返回给前端响应

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        User user = userDao.login(loginUser);
        if (user != null) {

            //保存 Session 对象
            req.getSession().setAttribute("user",user);
            return_map.put("msg",true);
        } else {
            return_map.put("mgs",false);
            //resp.sendRedirect("login.html");
        }
        ObjectMapper mapper = new ObjectMapper();
        //利用Jackson将map转化为json对象，writer 将转换后的json字符串保存到字符输出流中，最后给客户端
        mapper.writeValue(resp.getWriter(),return_map);
    }
}
