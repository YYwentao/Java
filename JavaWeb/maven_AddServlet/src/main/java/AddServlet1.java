import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AddServlet1
 * Description:
 * date: 2021/7/7 16:42
 */

@WebServlet("/add1")
public class AddServlet1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        int result = Integer.parseInt(a) + Integer.parseInt(b);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h3> 结果 = " + result + "</h3>");
    }
}
