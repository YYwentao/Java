package servlet;

import dao.MusicDao;
import entity.User;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * ClassName: uploadServlet
 * Description: 处理 上传音乐 的逻辑
 * date: 2021/7/19 17:21
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/upload")
@MultipartConfig
public class uploadServlet extends HttpServlet {
    //文件存放路径
    private static final String SavePath = "E:\\编程软件\\代码\\IdeaProjects\\JavaWeb\\my_music\\src\\main\\webapp\\music\\";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.setAttribute("msg","请登录后在上传");
            System.out.println("请登录后在上传");
        } else {
            // 1.上传文件,把文件存到指定路径，并从请求中截取文件名和歌手信息(难点)
            //先上传服务器 用postman进行了urlencode,获取到请求中的歌名的核心代码
            Part part = req.getPart("filename");
            String headerComDis = part.getHeader("Content-Disposition");
            int start = headerComDis.lastIndexOf("=");  //获取到 Content-Disposition 中 filename这个字段 = 的下标
            String fileName = headerComDis.substring(start+1).replace("\"","");  //filename 内容为 ="花海_周杰伦_128K.mp3"
            System.out.println("filename:"+fileName);
            /*
            谷歌浏览器会自动解析上传加密文件. 用 postman 测试需要手动处理解密过程(以下代码)
            浏览器如果自动解密了就不需要再次手动解密，不然会报错(越界异常)，踩坑+1
            int index = fileName.indexOf("%");
            fileName = fileName.substring(index);
            //对音乐名解码  URLEncoder.encode()
            fileName = URLDecoder.decode(fileName,"utf-8");
            System.out.println("fileName2:"+fileName);
            */
            part.write(SavePath + fileName); //把文件存到当前路径

            String singer = req.getParameter("singer");
            System.out.println("歌手："+singer);

            // 2.插入数据库
            String[] titles = fileName.split("\\.");     //截取歌名，去掉.mp3
            String title = titles[0];

            String url = "music\\" + title;                     // 路径 url

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            String time = sf.format(new Date());                // 时间

            int userId = user.getId();
            MusicDao musicDao = new MusicDao();
            //判断数据库中这当前用户是否已经上传过这首歌
            if (musicDao.isMusicExist(title,singer,userId)) {
                System.out.println("当前歌曲已经上传过了,请不要重复上传！");
                part.delete();
                return;
            }
            int ret = musicDao.insert(title,singer,time,url,userId);
            if (ret != 0) {
                resp.sendRedirect("list.html");
                return;
            }
            //数据库上传失败,同时删除服务器上已经有的文件
            System.out.println("上传音乐失败！");
            part.delete();
        }
    }
}
