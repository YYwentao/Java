

[TOC]


<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">
<font color=#999AAA >提示：以下是本篇文章正文内容

# 一、HTTP原理简介


&emsp;&emsp;<font color=black> `HTTP`协议(超文本传输协议HyperText Transfer Protocol)：它是基于TCP协议的应用层传输协议，简单来说就是客户端和服务端进行数据传输的一种规则。
	
>注意：客户端与服务器的角色不是固定的，一端充当客户端，也可能在某次请求中充当服务器。这取决于请求的发起端。HTTP协议属于应用层，建立在传输层协议TCP之上。客户端通过与服务器建立TCP连接，之后发送HTTP请求与接收HTTP响应都是通过访问Socket接口来调用TCP协议实现。

<font color=black >`HTTP` 是一种无状态 (stateless) 协议, HTTP协议本身不会对发送过的请求和相应的通信状态进行持久化处理。这样做的目的是为了保持HTTP协议的简单性，从而能够快速处理大量的事务, 提高效率。

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 二、HTTP内容简介
## 1. 认识URL
<font color=black >URL就是平时我们所说的网址/网站，它的结构如下：</from>

>URL：协议名称://服务器地址(ip地址/域名):端口号/带层次的路径？查询字符串

<font color=#999AAA >图文如下（示例）：</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630162021220.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)
<font color=black >URL中的每个部分代表不同的含义，重点了解下面几个部分</form>

 - 服务器地址：指出WWW页所在的服务器域名，表示服务器在哪里
 - 端口号：表示服务器上的哪个程序
 - 带层次的文件路径：表示该程序上的那个资源
 - 查询字符串：表示显示该资源上的那些细节(一般根据数据库id查询)

## 2. HTTP协议格式
&emsp;&emsp;<font color=black >协议就是一种约定，约定了请求和响应里面都是按照啥样的结构来进行组织数据的，要了解HTTP，就要先研究协议的格式。

>注意：请求(Request)和响应(Response)一般是成对出现的，就是网络通信模式中的**一问一答**(网络通信模式还包括一问多答，多问一答，多问多答)，例如用浏览器登录一个网站，用户输入网址之后，浏览器发送请求给服务器，服务器接收请求并处理后，返回响应给浏览器，浏览器接收到响应后，就打开了对应的页面。当前描述只是一个简单的过程，主要是为了明白HTTP协议格式要从请求(Request)和响应(Response)去描述

<font color=black >**HTTP 请求(Request)格式：**

 1. 首行(方法，url，版本号)
 2. header(每一行是一个键值对，键与值之间用==冒号空格== 分隔)
 3. 空行(表示header的结束标志)
 4. body(GET请求一般没有body，POST请求一般有body)

<font color=black >**HTTP 响应(Response)格式：**

 1. 首行(版本号，状态码，状态码描述)
 2. header(每一行是一个键值对，键与值之间用==冒号空格==分隔)
 3. 空行(表示header的结束标志)
 4. body(大部分常见的 body 就是html数据)

<font color=#999AAA >图文如下（示例）：</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630180349750.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)

## 3. HTTP的方法
 &emsp;&emsp;<font color=black >其中GET和POST方法最为重要，[点击了解GET和POST的区别](https://blog.csdn.net/qq_41603622/article/details/118309544)，其他的方法如PUT，HEAD，DELETE方法我们也应该适当了解

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630180654831.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)

## 4. HTTP的状态码
 &emsp;&emsp;<font color=black >HTTP状态码：当用户访问一个网页时，用户的浏览器会向网页所在的服务器发出请求。当浏览器接收并显示网页前，此网页所在的服务器会返回一个包含HTTP状态码的状态行(首行)用以响应浏览器的请求。

<font color=#999AAA > 状态码一般分为五大类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630183209575.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)
>最常见的状态码, 比如 200(OK), 404(Not Found), 403(Forbidden), 302(Redirect, 重定向), 504(Bad Gateway)

###  通过 Fiddler 抓包工具分析请求和响应的格式
 <font color=black >由于大部分 GET 请求没有 body 部分，为了方便观察结果，我们就以登录学校官网为例，因为是登录操作，要提交数据给服务器，所以抓取的是一个 POST 请求</form>

<font color=#999AAA >抓取POST方法：</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630192210267.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)
<font color=#999AAA >分析请求内容</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630194715491.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)
<font color=#999AAA >分析响应内容</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630195634834.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)

## 5. HTTP常见Header

 - Content-Type: 数据类型(text/html等)
 - Content-Length: Body的长度
 - Host: 客户端告知服务器, 所请求的资源是在哪个主机的哪个端口上;
 - User-Agent: 声明用户的操作系统和浏览器版本信息;
 - referer: 当前页面是从哪个页面跳转过来的;
 - location: 搭配3xx状态码使用, 告诉客户端接下来要去哪里访问;
 - Cookie: 用于在客户端存储少量信息. 通常用于实现会话(session)的功能;

## 6. Cookie 和 Session 的简单介绍

<font color=#999AAA >作为 HTTP 协议内容中 header 部分里最难理解的部分(狗头保命)，Cookie 和 Session 有必要单独拿出来介绍</form>

<font color=black >**1. Cookie是什么？**

 &emsp;&emsp;<font color=black >Cookie 简单来说就是一个字符串，是一种==键值对结构的字符串==。在浏览器里面保存着(每个域名/地址都有自己的Cookie)，访问不同的网站会产生不同的 Cookie ，Cookie 里面键值对里面的内容是什么(有哪些键，哪些值，是开发那些网站的程序员自己约定的)，外人都不知道。

<font color=black >**2. Cookie从何而来？**

 &emsp;&emsp;<font color=black >Cookie 的内容来自与服务器。在 HTTP 响应的 header 部分中有一个或多个 Set-Cookie 字段，Set-Cookie 字段里面的内容就会被浏览器保存下来。

<font color=black >**3. Cookie在什么时候出现？**

 &emsp;&emsp;<font color=black >浏览器保存好服务器返回的 Cookie 之后，如果下次还要访问这个服务器/网站，此时的请求中就会自动加上这个 Cookie 字段，字段里的值就是第一次访问这个服务器时返回的 Set-Cookie 字段里的内容

<font color=black >**4. Cookie有什么作用？**

 &emsp;&emsp;<font color=black > Cookie 的作用是非常大的，最典型的就是识别用户身份。服务器同一时刻可能会收到大量的 HTTP 请求，这些请求分别来自于哪些用户，服务器必须要明确的识别处理，那么服务器又是如何识别的呢？先看下面这个图

 <font color=#999AAA >如图所示</form>
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630214207798.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)
>如图所示(重点)：浏览器(客户端)首次访问服务器(请求中是不存在Cookie的)，当用户访问成功后，服务器就会创建一种数据结构来保存用户的信息，这种数据结构就是 Hash 表(Key-Value，唯一的键对应唯一的值)，还会在服务器内部生成一个Session对象(用来保存用户信息)，并且给这个Session对象(Value)分配唯一一个SessionId(Key)，然后再把这个 SessionId 和 Session 对象以键值对的形式插入到 Hash 表中。服务器这边处理完成了之后，返回给客户端的响应中 Set-Cookie 字段里就包含当前SessionId，而在客户端这边就把这个值保存在了本地，被称为 Cookie(本质上是字符串，上图中使用数字表示是为了方便理解)。

>浏览器二次访问服务器的时候，发送 HTTP 请求就会自动带上这个 Cookie ，服务器收到这个请求后，就可以从 Cookie 中获取到 SessionId，就可以查上面的 Hash 表，得到对应的 Session 对象，就获取到了该用户的详细信息。

总结：Cookie 是客户端的概念，是一种键值对结构的字符串，用来区分用户的身份，是服务器通过 Set-Cookie 字段返回的，存储在浏览器，后续再给服务器发送请求就会自动带上这个 Cookie 字段；Session 是服务器的概念，用来保存用户信息，每一个 Session 对象对应一个 SessionId，以键值对形式存储在服务器的哈希表中，当有一个新的客户端访问服务器的时候，请求中是不存在Cookie，服务器就会创建 Session 对象，并保存在哈希表中，对应的 SessionId 就被加入到了 Set-Cookie 字段返回，客户端就获取分配到了 Cookie。

注意：Cookie 里面只是包含着 SessionId 的，还包括其他一大段字符串(后面还会更详细解释 Cookie 和 Session 的关系)

<hr style=" border:solid; width:100px; height:1px;" color=#000000 size=1">

# 三、补充

## 1.Http VS Https
 &emsp;&emsp;<font color=black >简单理解，http 传送数据(包括账号和密码)，都是明文传送，很容易被窃取或者侦听，在现有的互联网应用中，很明显有不安全因素，所以有了 https，可以简单理解成https 多了一层加密解密层，在发送前加密，在收到后解密，在网络里传输的都是经过加密的数据。

 <font color=#999AAA >图文如下（示例）：</form>![在这里插入图片描述](https://img-blog.csdnimg.cn/20210630184222110.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxNjAzNjIy,size_16,color_FFFFFF,t_70)

<font color=#999AAA >提示：以上就是博客要讲的内容，本文仅仅简单介绍了HTTP协议中的请求和响应的格式内容，像网络中的数据如何传输，如何交互处理会在后续的文章中详细介绍。如有错误，请及时提醒(抱拳)。

