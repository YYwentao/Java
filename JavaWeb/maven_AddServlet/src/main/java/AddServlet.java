import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AddServlet
 * Description:
 * date: 2021/7/6 23:32
 *

 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        int result = Integer.parseInt(a) + Integer.parseInt(b);
        resp.setContentType("text/html");
        resp.getWriter().write("<h3> result = " + result + "</h3>");
    }
}
