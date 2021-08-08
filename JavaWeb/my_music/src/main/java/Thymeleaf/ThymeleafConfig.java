package Thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName: ThymeleafConfig
 * Description:
 * date: 2021/8/8 18:32
 *
 * @author wt
 * @since JDK 1.8
 */
@WebListener
public class ThymeleafConfig implements ServletContextListener {
    //使用这个方法 就可以在当前的 webapp 的 ServletContext (初始化)之后立刻执行
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 初始化 Thymeleaf
        // 1)创建一个 engine(引擎). ---负责把 Java中的数据替换到模板中
        TemplateEngine engine = new TemplateEngine();
        // 2)创建一个 resolver 对象.  ---负责找到 html 模板在哪并加载到内存中，供 engine 使用
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContextEvent.getServletContext());
        // 3)设置 resolver 的一些属性 ---让它能够找到 html 文件
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix("html");
        // 4)把 resolver 和 engine 关联起来
        engine.setTemplateResolver(resolver);

        //// 把初始化好的 engine 对象交给 ServletContext 来保管.
        ServletContext context = servletContextEvent.getServletContext();
        context.setAttribute("engine",engine);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
