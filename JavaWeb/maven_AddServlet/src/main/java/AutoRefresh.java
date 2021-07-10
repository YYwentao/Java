import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AutoRefresh
 * Description:
 * date: 2021/7/10 20:57
 */
@WebServlet("/refresh")
public class AutoRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Refresh","5");
        //每一秒钟刷新一次页面
        resp.setContentType("text/html; charset=utf-8");
        String html = "<h3>" + System.currentTimeMillis() + "</h3>";
        resp.getWriter().write(html);
    }
}
