import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: HelloServlet
 * Description:
 * date: 2021/4/21 19:20
 *
 * @author wentao
 * @since JDK 1.8
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //helloworld
        resp.getWriter().write("<h1>hello servlet</h1>");

    }
}
