package club.xiaoandx.servlet;

import club.xiaoandx.util.CaptchaUtil;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p> 验证码Servlet </p>
 *
 * @version V1.0.0
 * @ClassName:createCode
 * @author: WEI.ZHOU
 * @date: 2021/4/20 18:41
 */
public class createCode extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "-1");
        CaptchaUtil util = CaptchaUtil.Instance();
        String code = util.getString();
        request.getSession().setAttribute("code", code);
        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
    }

}
