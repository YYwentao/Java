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
 * ClassName: RegisterServlet
 * Description:
 * date: 2021/8/7 17:52
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> return_map = new HashMap<>();
        //1.从请求中获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        if (username == null || "".equals(username) || password == null || "".equals(password) || age < 0 || gender.length() > 1 || email == null || "".equals(email)) {
            return_map.put("mgs",false);
            System.out.println("注册失败,请检查输入是否符合要求");
        } else {
            //查询是否存在当前用户
            UserDao userDao = new UserDao();
            if (userDao.selectByName(username) == null) {
                //说明就不存在当前用户，可以注册
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setAge(age);
                user.setEmail(email);
                user.setGender(gender);
                userDao.insertUser(user);
                return_map.put("msg",true);
            } else {
                return_map.put("mgs",false);
                System.out.println("用户名已存在");
            }
        }
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),return_map);
    }
}
