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
 * ClassName: BlogInsertServlet
 * Description:
 * date: 2021/7/26 21:00
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/blogInsert")
public class BlogInsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // 0.获取到当前登录的用户
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendError(404,"当前未登录用户！不能发布博客！");
            return;
        }
        // 1.获取请求中的内容
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title) || content == null || "".equals(content)) {
            resp.sendError(404,"博客标题或内容不能为空");
            return;
        }
        // 2.构造 blog 对象 ，执行 blogDao 插入数据库
        Blog newBlog = new Blog();
        newBlog.setUserId(user.getUserId());
        newBlog.setTitle(title);
        newBlog.setContent(content);
        BlogDao blogDao = new BlogDao();
        blogDao.insert(newBlog);
        // 3.返回博客列表页面
        resp.sendRedirect("blog_list");
    }
}
