package Java0422;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * ClassName: ServletDemo1
 * Description:
 * date: 2021/4/22 9:44
 *
 * @author wentao
 * @since JDK 1.8
 */
public class ServletDemo1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String encoding = req.getCharacterEncoding();
        String contentType = req.getContentType();
        String contextPath = req.getContextPath();
        int contentLength = req.getContentLength();

        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("encoding" +encoding);
        writer.write("<br/>");
        writer.write("contentType" +contentType);
        writer.write("<br/>");
        writer.write("contextPath" +contextPath);
        writer.write("<br/>");
        writer.write("contentLength" +contentLength);
        writer.write("<html>");


    }
}
