package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: uploadServlet
 * Description:
 * date: 2021/7/19 17:21
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    //文件存放路径
    private static final String SavePath = "";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
    }
}
