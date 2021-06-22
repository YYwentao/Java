package errorr;

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

        stringBuilder.append(String.format("<a href=\"%s\"> 点击这里重新登录 </a>",nextUrl));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return stringBuilder.toString();
    }
}
