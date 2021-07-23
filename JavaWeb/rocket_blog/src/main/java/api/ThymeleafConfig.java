package api;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName: ThymeleafConfig
 * Description:
 * date: 2021/7/23 17:52
 *
 * @author wt
 * @since JDK 1.8
 */
//通过这注解,就知道这是一个监听器,监听 ServletContext 初始化和销毁事件
@WebListener
public class ThymeleafConfig implements ServletContextListener {
    //使用这个方法 就可以在当前的 webapp 的 ServletContext (初始化)之后立刻执行
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        /**
         *  初始化 Thymeleaf
         *  1)创建一个 engine(引擎). ---负责把 Java中的数据替换到模板中
         *  2)创建一个 resolver 对象.  ---负责找到 html 模板在哪并加载到内存中，供 engine 使用
         *  3)设置 resolver 的一些属性 ---让它能够找到 html 文件
         *  4)把 resolver 和 engine 关联起来
         */
        TemplateEngine engine = new TemplateEngine();
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContextEvent.getServletContext());
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("/WEB-INF/template/");   //设置前置
        resolver.setSuffix(".html");                //设置后缀
        engine.setTemplateResolver(resolver);

        // 把初始化好的 engine 对象交给 ServletContext 来保管.
        ServletContext context =servletContextEvent.getServletContext();
        context.setAttribute("engine",engine);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
