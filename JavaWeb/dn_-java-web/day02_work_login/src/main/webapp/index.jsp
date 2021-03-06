<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>登陆注册模块</title>
    <link href="css/Logins.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <style type="text/css">
        .check {
            margin: 3 20 -10;
        }
    </style>
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png"/></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png"/></a></div>
        <div class="login_name">
            <p>登陆系统</p>
        </div>
        <form method="post" action="LoginServlet" onsubmit="return sub">
            <input name="username" type="text" value="用户名" onfocus="this.value=''"
                   onblur="if(this.value==''){this.value='用户名'}">
            <span id="password_text"
                  onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();">密码</span>
            <input name="password" type="password" id="password" style="display:none;"
                   onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <input type="text" class="form-control" id="inputPassword3" name="ucheckC"
                   placeholder="请输入验证码" style="width: 50%"><img class="check" id="img"
                                                                src="user/check.jpg"
                                                                onclick="refresh()">
            <input value="登录" style="width:100%;" type="submit">
            <input value="点击我一下去注册>" style="width:100%;margin-top: 20px;float: right;" type="submit"
                   onClick="window.open('register.jsp')">
        </form>
        <p align="center" style="color: red;">${inf}</p>
    </div>
    <div class="copyright">小小工作室</div>
</div>
</body>
<script>
    function sub() {
        var uname = document.getElementById("uname").value;
        var password = document.getElementById("padw").value;
        //创建2个新对象用于清除内容用.value方法
        var uname_two = document.getElementById("uname")
        var password_two = document.getElementById("padw")
        //将用户名输出在控制台
        //console.log(uname);
        //判断用户名长度（账号长度为6-12）
        if (uname.length > 5 && uname.length < 13) {
            alert("用户名正确");
            //密码必须以字母开头  6-16为
            if (/^[a-zA-Z]\w{5,17}$/.test(password)) {
                alert("密码正确");
            } else {
                password_two.value = "";
                alert("密码格式错误");
            }
        } else {
            uname_two.value = "";
            alert("用户名错误");
        }
    }

    /* 执行重新查找验证码 */
    function refresh() {
        /* var url = $("#basePath").val() + "user/check.jpg";
        $("#img").attr("src",url); */
        var date = new Date();
        var captcha = document.getElementById("img");
        captcha.src = "user/check.jpg?t=" + date.getTime();
    }
</script>
</html>