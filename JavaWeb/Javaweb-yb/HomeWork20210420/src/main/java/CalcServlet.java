import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CalcServlet
 * Description:
 * date: 2021/4/21 22:29
 *
 * @author wentao
 * @since JDK 1.8
 */
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取 url 中的参数内容。(a和b的内容)
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        int result = a+b;
        resp.getWriter().write(String.format("<h1>result= %d</h1>",result));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
