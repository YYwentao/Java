package Java0422;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * ClassName: ServletDemo2
 * Description:
 * date: 2021/4/22 11:24
 *
 * @author wentao
 * @since JDK 1.8
 */
//返回一个一个页面,每秒自动刷新
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setIntHeader("Refresh",1);
        //返回的页面中,填写上当前时间
        //获取当前时间
        Date date = new Date();
        Writer writer =resp.getWriter();
        writer.write("<html>");
        writer.write(date.toString());
        writer.write("<html>");
    }
}
