package servlet;

import dao.Blog;
import dao.BlogDao;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: BlogListServlet
 * Description:    博客列表页面
 * date: 2021/7/14 17:18

 */
@WebServlet("/blog_list")
public class BlogListServlet extends HttpServlet {
    private TemplateEngine engine = null;

    @Override
    public void init() throws ServletException {
        /**
         *  初始化 Thymeleaf
         *  1)创建一个 engine(引擎). ---负责把 Java中的数据替换到模板中
         *  2)创建一个 resolver 对象.  ---负责找到 html 模板在哪并加载到内存中，供 engine 使用
         *  3)设置 resolver 的一些属性 ---让它能够找到 html 文件
         *  4)把 resolver 和 engine 关联起来
         */
        engine = new TemplateEngine();
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(getServletContext());
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("/WEB-INF/template/");   //设置前置
        resolver.setSuffix(".html");                //设置后缀
        engine.setTemplateResolver(resolver);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //1.先从数据库查询出有哪些博客
        BlogDao blogDao = new BlogDao();
        List<Blog> blogList = blogDao.selectAll();
        //2.构造博客列表页面
        // 1) 通过 Thymeleaf 进行渲染. 渲染的时候需要定义 "数据集合" 这样的概念.
        // WebContext 功能就是把要替换的数据给收集起来, 统一的传给模板引擎.
        WebContext webContext = new WebContext(req, resp, getServletContext());
        // 2) setVariable 可以设置多个键值对. 完全取决于模板代码怎么写.
        // 模板里的每个 ${ } 里面的内容都需要在 webContext 设定进去.
        webContext.setVariable("blogs", blogList);
        // 3) 进行渲染.
        String html = engine.process("blog_list",webContext);
        resp.getWriter().write(html);
    }
}












