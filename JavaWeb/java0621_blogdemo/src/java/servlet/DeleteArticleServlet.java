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

/**
 * ClassName: DeleteArticleServlet
 * Description:
 * date: 2021/6/22 22:25
 */
public class DeleteArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        //1.先验证用户的登录状态,如果未登录,提示用户先登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("你尚未登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        //2.读取请求内容,获取到要删除的文章 id
        String articleIdSer = req.getParameter("articleId");
        if (articleIdSer == null || "".equals(articleIdSer)) {
            String html = HtmlGenerator.getMessagePage("要删除的文章 id 有误","article");
            resp.getWriter().write(html);
            return;
        }

        //3.根据文章的 id 查找到该文章的内容,当前用户如果是作者,才能删除,否则删除失败
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(Integer.parseInt(articleIdSer));
        if (article.getUserId() != user.getUserId()) {
            String html = HtmlGenerator.getMessagePage("你只能删除自己的文章！","article");
            resp.getWriter().write(html);
            return;
        }
        //4.执行数据库删除操作
        articleDao.deleteByID(Integer.parseInt(articleIdSer));
        //5.返回一个"删除成功"的页面
        String html = HtmlGenerator.getMessagePage("删除成功！","article");
        resp.getWriter().write(html);
        return;
    }
}
