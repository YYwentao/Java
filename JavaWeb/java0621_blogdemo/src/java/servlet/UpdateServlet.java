package servlet;

import jump.HtmlGenerator;
import model.Article;
import model.ArticleDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 * ClassName: UpdateServlet
 * Description:
 * date: 2021/6/28 20:16
 *
 * @author wt
 * @since JDK 1.8
 */
public class UpdateServlet extends HttpServlet {
    // 处理编辑文章的 POST 请求逻辑
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.先验证用户的登录状态,如果未登录,先提升用户登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("你尚未登录,请先登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //2.读取请求内容，获取要修改内容的id
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null || "".equals(articleIdStr)) {
            String html = HtmlGenerator.getMessagePage("要修改的文章 id 有误","article");
            resp.getWriter().write(html);
            return;
        }
        //3.从请求中读取浏览器提交的数据(title,content),并进行简单的校验
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        System.out.println(title+"" +content);
        if (title == null || "".equals(title) || content == null || "".equals(content)) {
            String html = HtmlGenerator.getMessagePage("提交的标题或者正文为空","article");
            resp.getWriter().write(html);
            return;
        }
        //4.把数据插入到数据库中
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setArticleId(Integer.parseInt(articleIdStr));
        articleDao.update(article);
        //5.返回一个修改成功的页面
        String html = HtmlGenerator.getMessagePage("修改成功","article");
        resp.getWriter().write(html);
        return;
    }
}
