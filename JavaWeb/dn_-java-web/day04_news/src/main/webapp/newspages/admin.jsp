<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
<meta http-equiv="description" content="This is my page"/>
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/admin.js"></script>
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员： 登录  &#160;&#160;&#160;&#160; <a href="#">login out</a></div>
  <div id="channel"> </div>
</div>
<div id="main">
  <%@ include file="console_element/left.html" %>
  <div id="msg" style="display: none; position: absolute; z-index: 5; background-color: pink; font-size: 16px; padding: 5px 20px;"></div>
  <div id="opt_area">    
    <!-- 内容区域  -->
  </div>
</div>
<div id="footer">
  <%@ include file="console_element/bottom.html" %>
</div>
</body>
</html>