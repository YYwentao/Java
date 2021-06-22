package servlet;

import jump.HtmlGenerator;
import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: ArticleServlet
 * Description:
 * date: 2021/6/22 12:56
 */
public class ArticleServlet extends HttpServlet {
    //处理进入文章列表页和详情页的 GET 请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.验证用户是否已经登录了,如果未登录，就提示用户先登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("请先登录","login.html");
            resp.getWriter().write(html);
        }
        User user = (User) httpSession.getAttribute("user");
        //2.判断请求中是否存在 articleId 参数
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null) {
            // a).没有参数就执行获取所有文章列表操作
            getAllArticle(user,resp);
        } else {
            // b).有参数就去执行获取文章详情操作
            getOneArticle(Integer.parseInt(articleIdStr),user,resp);
        }
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        //1.查找数据库
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.selectAll();
        //2.构造页面
        String html = HtmlGenerator.getArticleListPage(list,user);
        resp.getWriter().write(html);
    }

    private void getOneArticle(int articleId, User user, HttpServletResponse resp) throws IOException {
        //1.查找数据库
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if (article == null) {
            String html = HtmlGenerator.getMessagePage("文章不存在","article");
            resp.getWriter().write(html);
            return;
        }
        //2. 根据作者 Id 找到作者信息,进一步得到作者姓名
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());
        //3.构造页面
        String html = HtmlGenerator.getArticleDetailPage(article,user,author);
        resp.getWriter().write(html);
    }

    // 处理新增文章的 POST 请求逻辑
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //1.判断用户的登陆状态,如果用户尚未登录,就提示用户登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("你尚未登录，请先登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");//获取Session对象里面的user对象
        //2.从请求中读取浏览器提交的数据(title,context),并进行简单校验
        String title = req.getParameter("title");
        String context = req.getParameter("context");
        if (title == null || "".equals(title) || context == null || "".equals(context)) {
            String html = HtmlGenerator.getMessagePage("提交的标题或者正文为空","article");
            resp.getWriter().write(html);
            return;
        }
        //3.把数据插入到数据库中
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(context);
        article.setUserId(user.getUserId());
        articleDao.add(article);
        //4.返回一个插入成功的页面
        String html = HtmlGenerator.getMessagePage("发布成功","article");
        resp.getWriter().write(html);
        return;
    }
}
