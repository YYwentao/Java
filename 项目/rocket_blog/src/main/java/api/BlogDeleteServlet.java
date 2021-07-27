package api;

import dao.Blog;
import dao.BlogDao;
import dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: BlogDeleteServlet
 * Description:
 * date: 2021/7/26 22:50
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/blogDelete")
public class BlogDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 0.从请求中获取 blogId
        String blogIdStr = req.getParameter("blogId");
        if (blogIdStr == null || "".equals(blogIdStr)) {
//            resp.sendError(404,"博客不存在!");
            resp.getWriter().write("<h3>博客不存在!</h3>");
            return;
        }
        int blogId = Integer.parseInt(blogIdStr);
        // 1.判断用户是否登录
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
//            resp.sendError(404,"请登录后在删除！");
            resp.getWriter().write("<h3>请登录后在删除！ <a href=\"login.html\">点击登录</a> </h3>");
            return;
        }
        // 2.根据 blogId 查询到用户的id,和当前登录的用户 Id 对比是否相同
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectById(blogId);
        if (blog == null) {
//            resp.sendError(404,"当前博客不存在！");
            resp.getWriter().write("<h3>当前博客不存在！</h3>");
            return;
        }
        if (blog.getUserId() != user.getUserId()) {
//            resp.sendError(404,"你当前只能删除自己的博客！");
            resp.getWriter().write("<h3>你当前只能删除自己的博客！</h3>");
            return;
        }
        // 3.用户 id 相同的话就执行数据库
        blogDao.delete(blogId);
        // 4.重定向到博客列表页面
        resp.sendRedirect("blog_list");
    }
}
