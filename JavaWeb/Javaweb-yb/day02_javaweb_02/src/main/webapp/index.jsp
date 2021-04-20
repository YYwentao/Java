<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/4/20
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目首页</title>
    <head/>

<body >

使用超链接向后台发送数据
<br/>
<a href="//user?name=1233444">发送参数1</a>
<a href="//user?name=1233444&pwd=admin">发送参数1</a>

<form action= "//user" method="post">
    <table>
        <tr>
            <td>.用户名</td>
            <td><input type="text" name= "username"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type= "password" name= "password"/></td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type= "text" name= "age"/></td>
        </tr>
        <tr>
            <td colspan= "2"><input type= "submit" value= "提交"/></td>
        </tr>
    </table>
</form>

<h1><a href="index.jsp">请求转发</a> </h1>
</body>
</html>
