package jump;

import model.Article;
import model.User;

import java.util.List;

/**
 * ClassName: HtmlGenerator
 * Description:
 * date: 2021/6/21 21:58
 */
public class HtmlGenerator {
    //通过字符串拼接一个注册失败的 html 页面
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<mata character=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");

        stringBuilder.append(String.format("<a href=\"%s\"> 下一步 </a>",nextUrl));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }

    //通过字符串拼接一个登录后的显示页面
    public static String getArticleListPage(List<Article> list, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<mata character=\"utf-8\">");
        stringBuilder.append("<title>文章列表</title>");
        stringBuilder.append("<style>");
        //style 标签内部写 css 样式
        stringBuilder.append("a{"+
                "text-decoration:none;"+
                "}");
        stringBuilder.append("a:hover {" +
                "color:RGB(251,107,76);"+
                "}");
//        stringBuilder.append("body {" +
//                "background-image:url(\"https://cn.bing.com/th?id=OHR.BurleighHeads_ZH-CN6052781534_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp\");" +
//                "background-repeat:no-repeat;"+
//                "background-size:100%;"+
//                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3> 下午好！" + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        //文章列表，显示文章标题
        for (Article article:list) {
            stringBuilder.append(String.format("<div style=\"height:30px; line-height:30px\"> <a href=\"article?articleId=%d\"> 标题: %s </a>" +
                            "<a href=\"deleteArticle?articleId=%d\" style=\"color:red\"> 删除 </a></div>",
                    article.getArticleId(),article.getTitle(),article.getArticleId()));
        }
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<div>当前共有文章 %d 篇</div>",list.size()));

        //这里新增发布文章区域
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");
        stringBuilder.append("<br>");

        stringBuilder.append("<div> 发布文章 </div>");
        stringBuilder.append("<div>");
        stringBuilder.append("<form action=\"article\" method=\"post\">");
        stringBuilder.append("<input type=\"text\" name=\"title\" placeholder=\"请输入标题\" style=\"width:500px\">");
        stringBuilder.append("<br>");
        stringBuilder.append("<textarea name=\"context\" style=\"width:500px; height:300px\"></textarea>");
        stringBuilder.append("<br>");
        stringBuilder.append("<input type=\"submit\" value=\"发布文章\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</div>");

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetailPage(Article article, User user, User author) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<mata character=\"utf-8\">");
        stringBuilder.append("<title>文章详情</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append(String.format("<h3>标题: %s</h3>",article.getTitle()));
        stringBuilder.append("<hr>");
        stringBuilder.append(String.format("<h5>作者: %s</h5>",author.getName()));
        stringBuilder.append("<hr>");

        stringBuilder.append(String.format("<div>内容: %s</div>",article.getContent()
                .replace("\n","<br>")));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
