package api;

import dao.Blog;
import dao.BlogDao;
import dao.User;
import dao.UserDao;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Blob;

/**
 * ClassName: BlogContentServlet
 * Description:
 * date: 2021/7/23 16:17
 *
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/blogContent")
public class BlogContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int blogId = Integer.parseInt(req.getParameter("blogId"));
        // 1.执行 dao 层数据库
        BlogDao blogDao = new BlogDao();
        Blog blog = blogDao.selectById(blogId);
        if (blog == null) {
            resp.sendError(404," blogId 的文章不存在！");
            return;
        }
        // 2.根据 blog.userId 找到对应的 dao.User 对象
        UserDao userDao = new UserDao();
        User user = userDao.selectById(blog.getUserId());
        // 3.构造博客详细页面
        //  1).需要先搞一个 WebContext 对象(数据集合)
        //  把想要替换的关键数据放到收集起来,放到 WebContext 中
        WebContext webContext = new WebContext(req,resp,getServletContext());
        webContext.setVariable("blog",blog);
        webContext.setVariable("username",user.getUsername());
        // 4.查询结果渲染到 html 模板中
        TemplateEngine engine = (TemplateEngine) getServletContext().getAttribute("engine");
        String html = engine.process("blogContent",webContext);
        resp.getWriter().write(html);
    }
}
