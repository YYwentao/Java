import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: setCookieServlet
 * Description:
 * date: 2021/7/10 21:45
    Cookie 是从浏览器上生成的
        通过这个 Servlet 类让服务器给浏览器返回Cookie内容
 */
@WebServlet("/setCookie")
public class setCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("time",""+System.currentTimeMillis());
        resp.addCookie(cookie);
        resp.setStatus(200);
        resp.getWriter().write("<h3>从服务器上获取到 Cookie </h3>");
    }
}
