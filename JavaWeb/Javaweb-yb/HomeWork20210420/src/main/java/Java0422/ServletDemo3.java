package Java0422;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * ClassName: ServletDemo3
 * Description:
 * date: 2021/4/22 14:20
 *
 * @author wentao
 * @since JDK 1.8
 */
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先获取Session.如果用户曾经没有访问过,此时将创建新的session
        // 如果用户已经访问过了,就获取到曾经的Session
        HttpSession httpSession = req.getSession(true);
        //2.判断是否为新用户
        Integer count = 1;
        if (httpSession.isNew()) {
            //是新用户,把count值写入到session对象中,
            //httpSession 也可以当成一个hash表
            httpSession.setAttribute("count",count);
        } else {
            //是老用户
            //从httpSession中读取到count值
            count = (Integer) httpSession.getAttribute("count");
            count = count + 1;
            //count 自增完成后,要重新写入session
            httpSession.setAttribute("count",count);
        }
        //3.返回响应页面
        resp.setContentType("text/html;charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("count" +count);
        writer.write("</html>");
    }
}
