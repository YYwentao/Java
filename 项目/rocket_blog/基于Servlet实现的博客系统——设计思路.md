# Servlet版本的博客系统
<font color=#999AAA >提示：本篇文章只是提供项目的设计思路，使用的技术，部分难题的解决方法，源码在文章最下面
<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

@[TOC](文章目录)

</font>

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 前言

<font color=#999AAA >由于偶尔在 CSDN 上写一些博客，于是就模仿 CSDN 的部分功能和样式实现一个相对简单的 JavaWeb 的博客系统项目。此项目使用 Maven 管理，使用 Servlet 处理请求和响应，Thymeleaf 模板技术实现前后端数据交互。实现用户登录注册功能，发布博客，删除博客，显示博客列表，博客详情页以及退出当前用户等基本功能</font>

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">


# 一、分析需求

<font color=black >想要搭建一个博客 JavaWeb 的项目，第一步肯定不是一上手就写代码，而是要分析需求。
>需要创建那些实体类？

答：两个实体类 ，User类 实现对用户登录注册管理， Blog类 实现对博客功能的管理
>需要实现那些功能？

1.	注册新用户
2.	登录已有用户
3.	显示博客列表，每一项包含博客标题，部分内容，发布时间
4.	点击标题跳转到文章详情页，文章详情页中，显示文章标题，作者，详细内容
5.	发布新文章（暂不考虑富文本编辑）
6.	注销当前登录用户
7.	删除博客

</font>

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 二、数据库设计
## 1. 创建表
<font color=#999AAA >代码如下（示例）：

```sql
create database if not exists RocketBlog;
use RocketBlog;

drop table if exists  blog;
create table blog(
    blogId int primary key auto_increment,
    title varchar (512),
    content text,
    userId int,
    postTime datetime
);

drop table if exists user;
create table user (
    userId int primary key auto_increment,
    username varchar (50),
    password varchar (50)
);
```
## 2. JDBC实现数据库连接和释放

<font color=#999AAA >代码如下（示例）：

```java
//管理数据库连接: 1.建立连接, 2.断开连接
//JDBC 中使用 DataSource 来管理连接
//DBUtil 相当于是对 DataSource 在稍微包装一层,DBUtil 本质上就是实现一个单例模式，
//来管理唯一一个DataSource实例，此处实现懒汉式的单例
public class DBUtil {
    private static DataSource dataSource= null;
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/rocketblog?characterEncoding=utf8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    //给 DataSource 设置
                    ((MysqlDataSource) dataSource).setUrl(URL);
                    ((MysqlDataSource) dataSource).setUser(USER);
                    ((MysqlDataSource) dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }
    //通过这个方法获取连接
    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //通过这个方法断开连接
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```

## 3. Dao 层实现对数据库执行的 SQL 语句
<font color=black > 由于涉及到两种数据库表，就要对两张数据库表操作进行操作。使用 Java 代码对执行数据库操作，模式比较固定单一。
首先创建 Connection 类获取数据库连接，创建 PreparedStatement 类对 sql 语句预处理的同时，还`解决了 sql 注入问题`带来的不必要错误，然后创建 ResultSet 类对查询结果集设置相应的属性，最后释放创建的资源。

<b>注意：查询语句使用 executeQuery()方法，其他语句使用 executeUpdate()方法。

<font color=#999AAA >以下为查询所有博客列表（示例代码）：

```java
	/**
     * 从数据库查看所有博客
     */
    public List<Blog> selectAll () {
        List<Blog> blogs = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select * from blog order by blogId desc ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //遍历结果集到 blogs 里面
            while (resultSet.next()) {
                Blog blog = new Blog();
                blog.setBlogId(resultSet.getInt("blogId"));
                blog.setTitle(resultSet.getString("title"));
                blog.setContent(resultSet.getString("content"));
                blog.setUserId(resultSet.getInt("userId"));
                blog.setPostTime(resultSet.getTimestamp("postTime"));
                blogs.add(blog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return blogs;
    }
```
<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">



# 三、Servlet 逻辑处理

<font color=black >Servlet 就是Tomcat 提供的一组 api，用户处理 HTTP 协议的请求逻辑和返回相应，每一种功能一般来说都对应一个 Servlet 类，然后再这个类里面分析出要解决的问题。

 - `LoginServlet 类`处理 `用户登录` 的逻辑
 - `Register 类`处理 `新用户注册` 的逻辑
 - `LogoutServlet类`处理 `登录后注销用户` 的逻辑
 - `BlogListServlet 类`处理 `显示当前所有博客列表` 的逻辑
 - `BlogContentServlet 类`处理 `显示当前博客详情页` 的逻辑
 - `BlogInsertServlet 类`处理 `发布新博客`的逻辑
 - `BlogDeleteServlet 类`处理 `删除博客`的逻辑

<br>例如： LoginServlet 类处理 Post 请求的用户登录的逻辑，首先要获取到登录输入用户名和密码，判断密码的有效性，然后和数据库的用户名和密码进行对比，如果存在就先要创建一个 Session 对象用户保存用户信息，最后处理登录成功够要跳转的页面

<font color=#999AAA >代码如下（示例）：

```java
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username == null || "".equals(username) || password == null || "".equals(password)) {
//            resp.sendError(404,"用户名或密码不能为空");
            resp.getWriter().write("<h3>用户名或密码不能为空</h3>");
            return;
        }
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(username);
        if (user == null) {
//            resp.sendError(404,"用户名或密码不存在");
            resp.getWriter().write("<h3>用户名或密码错误</h3>");
            return;
        }
        if (!password.equals(user.getPassword())) {
//            resp.sendError(404,"用户名或密码不存在");
            resp.getWriter().write("<h3>用户名或密码错误</h3>");
            return;
        }
        //登录成功后！创建会话
        req.getSession().setAttribute("user",user);
        resp.sendRedirect("blog_list");
    }
}
```
<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 四、Thymeleaf 模板引擎技术解决前后端数据交互问题(难点)
<font color=black >在这之前，有使用过在用字符串拼接实现一个前端页面，但效率太低，而且容易出错，后来也了解过 Ajax 实现数据交互。在第一次接触这个概念的，我也是很懵的，<b>什么是Thymeleaf？

 - Thymeleaf 官网是这么解释的：Thymeleaf is a modern server-side Java template engine for both web and standalone environments.
 - 译过来就是：Thymeleaf是适用于Web和独立环境的现代服务器端**Java模板引擎**
 - **模板引擎**（这里特指用于Web开发的模板引擎）是为了使用户界面与业务数据（内容）分离而产生的，它可以生成特定格式的文档，用于网站的模板引擎就会生成一个标准的html文档。从字面上理解模板引擎，最重要的就是模板二字，这个意思就是做好一个模板后套入对应位置的数据，最终以html的格式展示出来，这就是模板引擎的作用。

<font color=black >简单来说实现用 html 的页面当成一个模板页面，没有传输数据的时候就显示这个模板 html 页面，当后端传有数据的时候就在相应的位置显示的增加数据内容。

## 1. 先初始化 Thymeleaf 

<font color=black >实现一个监听器，用于监听 ServletContext 初始化和销毁事件，在 contextInitialized 这个方法里对 Thymeleaf  的初始化

**初始化Thymeleaf**  

 1. 创建一个 engine(引擎)，负责把 Java中的数据替换到模板中
 2. 创建一个 resolver 对象，负责找到 html 模板在哪并加载到内存中，供 engine 使用
 3. 设置 resolver 的一些属性，让它能够找到 html 文件
 4. 把 resolver 和 engine 关联起来
 5. 把初始化好的 engine 对象交给 ServletContext 来保管.
```java
//通过这注解,就知道这是一个监听器,监听 ServletContext 初始化和销毁事件
@WebListener
public class ThymeleafConfig implements ServletContextListener {
    //使用这个方法 就可以在当前的 webapp 的 ServletContext (初始化)之后立刻执行
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1)创建一个 engine(引擎). ---负责把 Java中的数据替换到模板中
        TemplateEngine engine = new TemplateEngine();
        //2)创建一个 resolver 对象.  ---负责找到 html 模板在哪并加载到内存中，供 engine 使用
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver(servletContextEvent.getServletContext());
        //设置 resolver 的一些属性，让它能够找到 html 文件
        resolver.setCharacterEncoding("utf-8");
        resolver.setPrefix("/WEB-INF/template/");   //设置前置
        resolver.setSuffix(".html");                //设置后缀
        //把 resolver 和 engine 关联起来
        engine.setTemplateResolver(resolver);

        // 把初始化好的 engine 对象交给 ServletContext 来保管.
        ServletContext context =servletContextEvent.getServletContext();
        context.setAttribute("engine",engine);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent{}
}
```

## 2. Thymeleaf 语法应用
### 导航栏显示不同内容
<font color=black >描述：在访问博客列表页面的时候，用户未登录时导航栏会显示登录/注册，用户登录后导航栏显示欢迎XX/注销

 - 在 html 模板中构造页面
 
```html
<div class="nav">
        <h3 class="nav-title">我的博客系统</h3>
       <!-- 中间空白间隔-->
        <div class="space" ></div>
        <!-- 如果用户未登陆,就显示未登录,并且显示登录注册/按钮-->

        <a href="login.html" class="nav-button" th:if="${!isLogin}">登录</a>
        <a href="register.html" class="nav-button" th:if="${!isLogin}">注册</a>

        <!-- 如果用户已经登陆，就显示欢迎XXX-->
        <div class="nav-button" th:if="${isLogin}" th:text="${'欢迎您: '+user.username}"></div>
        <a href="blog_insert.html"  class="nav-button" th:if="${isLogin}">写博客</a>
        <a href="logout" class="nav-button" th:if="${isLogin}">注销</a>
    </div>
```

 - 在 java 中对 Thymeleaf 进行渲染，渲染的时候需要定义 "数据集合" 这样的概念，WebContext 功能就是把要替换的数据给收集起来，统一的传给模板引擎。最后通过 setVariable 设置多个键值对，模板里的每个 ${ } 里面的内容都需要在 webContext 设定进去。
 

```java
		//0.获取到当前的用户的信息，判断是否登录
        User user = (User) req.getSession().getAttribute("user");
        boolean isLogin = true;
        if (user == null) {
            isLogin = false;
        }
		//1.先从数据库查询出有哪些博客
        BlogDao blogDao = new BlogDao();
        List<Blog> blogList = blogDao.selectAll();
        //2.构造博客列表页面
        // 1) 通过 Thymeleaf 进行渲染. 渲染的时候需要定义 "数据集合" 这样的概念.
        // WebContext 功能就是把要替换的数据给收集起来, 统一的传给模板引擎.
        WebContext webContext = new WebContext(req, resp, getServletContext());
        // 2) setVariable 可以设置多个键值对. 完全取决于模板代码怎么写.
        // 模板里的每个 ${ } 里面的内容都需要在 webContext 设定进去.
        webContext.setVariable("isLogin",isLogin);
        webContext.setVariable("user",user);
        // 3) 进行渲染.
        TemplateEngine engine = (TemplateEngine) getServletContext().getAttribute("engine");
        String html = engine.process("blog_list",webContext);
        resp.getWriter().write(html);
```

<font color=blue>Thymeleaf 语法众多，这里使用 `th:if="${isLogin}"` 的语法方式，如果用户已经登录 isLogin为true，通过 webContext  里设置的键值对，就获取到用户的信息并显示在页面中，否则就是 isLogin为false,前端显示登录/注册 


### 显示博客列表页
<font color=black >描述：当没有一篇博客的时候，列表页没有内容显示，当存在博客时就显示当前所有博客

<font color=#999AAA >如图所示（示例）：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2ff42c3585a94c4cbe985eb76ecf2b90.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)

 - 在 html 中提供一个显示一篇博客的模板框架，通过 Thymeleaf 语法中的一些特殊记号，把要替换的数据进行占位
 


```html
<!--container 存放所有博客-->
    <div class="container">
        <!--        blog对应每一篇博客-->
        <div class="blog" th:each="blog : ${blogs}">
            <a th:href="${'blogContent?blogId=' + blog.blogId}" class="title" th:text="${blog.title}">我是标题</a>
            <div class="desc" th:text="${blog.content}">我是正文的摘要</div>
            <div class="post-time" th:text="${blog.postTime}">发布时间: 2021-07-11 17：30：00</div>
        </div>
    </div>
```

 - java 中和上面一样
 

```java
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
        TemplateEngine engine = (TemplateEngine) getServletContext().getAttribute("engine");
        String html = engine.process("blog_list",webContext);
        resp.getWriter().write(html);
```

<font color = black>最后通过编写前端的 html 页面就实现了一个简单的博客系统

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 总结

例如：以上就是今天要讲的内容，所有代码的链接链接: [个人博客系统](https://github.com/YYwentao/Java/tree/master/%E9%A1%B9%E7%9B%AE/rocket_blog).

