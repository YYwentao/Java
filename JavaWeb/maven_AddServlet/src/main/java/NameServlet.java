import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: NameServlet
 * Description:
 * date: 2021/7/7 17:32

 */
@WebServlet("/hello")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h1> name = " + name+ "</h1>");
    }
}
