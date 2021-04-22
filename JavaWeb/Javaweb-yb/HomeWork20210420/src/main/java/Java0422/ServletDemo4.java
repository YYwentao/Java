package Java0422;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * ClassName: ServletDemo4
 * Description:
 * date: 2021/4/22 16:07
 *
 * @author wentao
 * @since JDK 1.8
 */
@MultipartConfig
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收到图片,直接把图片保存到
        //d:/images 目录中~
        //先把路径准备好
        String basePath = "e:/images/";
        Part image = req.getPart("image");
        //这个方法就能得到上传的文件名.
        String path = basePath + image.getName();
        image.write(path);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("图片上传成功!");
    }
}
