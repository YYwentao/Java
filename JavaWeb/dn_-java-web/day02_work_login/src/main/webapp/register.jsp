<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>登陆注册模块</title>
    <link href="/css/Logins.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="/images/login-img.png"/></div>
    <div class="login_two">
        <div class="login_logo"><a href="#"><img src="/images/login_logo.png"/></a></div>
        <div class="login_name">
            <p>注册系统</p>
        </div>
        <form method="post" action="/RegisteServlet">
            <input name="username" type="text" value="用户名" onfocus="this.value=''"
                   onblur="if(this.value==''){this.value='用户账号'}">

            <span id="password_text"
                  onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">用户密码</span>
            <input name="password" type="password" id="password" style="display:none;"
                   onblur="if(this.value==''){};"/>

            <span id="password_text"
                  onclick="this.style.display='none';document.getElementById('passwords').style.display='block';document.getElementById('passwords').focus().select();">确认密码</span>
            <input name="passwords" type="password" id="passwords" style="display:none;"
                   onblur="if(this.value=='');"/>
            <input value="点击注册" style="width:100%;" type="submit">
        </form>
        <p align="center" style="color: red;">${inf}</p>
    </div>
    <div class="copyright">小小工作室</div>
</div>
</body>
</html>
