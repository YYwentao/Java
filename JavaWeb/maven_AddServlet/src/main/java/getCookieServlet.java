import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: getCookieServlet
 * Description:
 * date: 2021/7/10 21:53
 *
    让服务器读取到浏览器中请求的 Cookie 的值
 */
@WebServlet("/getCookie")
public class getCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]  cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() +": "+cookie.getValue());
        }
        resp.getWriter().write("<h3>服务器从客户端中获取到了 Cookie 的值</h3>");
    }
}
