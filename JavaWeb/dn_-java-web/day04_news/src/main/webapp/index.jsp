<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/index_topicNews.js"></script>
<script type="text/javascript">
	function check(){
		var login_username = document.getElementById("uname");
		var login_password = document.getElementById("upwd");
		if(login_username.value == ""){
			alert("用户名不能为空！请重新填入！");
			login_username.focus();
			return false;
		}else if(login_password.value == ""){
			alert("密码不能为空！请重新填入！");
			login_password.focus();
			return false;
		}
		return true;
	}

	function focusOnLogin(){
		var login_username = document.getElementById("uname");
		login_username.focus();
	}
</script>
  <style type="text/css">
    .topLi{
      display: inline;
      padding: 5px 10px;
      color: #45678f;
      font-weight:900;
    }
    .newsItem{
      display: flex;
    }
    .pageButton{

    }
    .pageButtonAction{
      color: crimson;
    }
  </style>
</head>

<body onload="focusOnLogin()">

<div id="header">
  <div id="top_login">
    <form action="util/user" method="post" onsubmit="return check()">
      <input type="hidden" name="opr" value="login"/>
      <label> 登录名 </label>
      <input type="text" name="uname" value="" class="login_input" />
      <label> 密&#160;&#160;码 </label>
      <input type="password" name="upwd" value="" class="login_input" />
      <input type="submit" class="login_sub" value="登录" />
      <label id="error"> </label>
      <img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
    </form>
  </div>
  <div id="nav">
    <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
    <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
    <!--mainnav end-->
  </div>
</div>
<div id="container">

<%--@ include file="index-elements/index_sidebar.jsp"--%>
  <div class="sidebar">
  <!-- 容纳左侧最新消息的容器 -->
  </div>

  <div class="main">
    <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
    <div class="content">
      <ul class="class_date">
      <!-- 新闻主题链接区域 -->
        <c:forEach items="${topicAll}" var="t">
          <a href="/topicNews?tid=${t.tid}">
            <li class="topLi">${t.tname}</li>
          </a>
        </c:forEach>
      </ul>
      <ul class="classlist">
        <div class="pageButton">
          <!-- 分页显示新闻区域 -->
          <c:forEach items="${page.list}" var="n" varStatus="status">
            <li class="newsItem">
                ${n.ntitle}
              <span>
                  ${n.ncreateDate}
              </span>
            </li>
            <c:if test="${(status.index+1) % 5 == 0}">
              <br>
            </c:if>
          </c:forEach>

          共${page.totalPageNum}页&nbsp;/&nbsp;第${page.currentPageNum}页

          <a href="${pageContext.request.contextPath}${page.url}index?num=1">
            首页
          </a>

          <a href="${pageContext.request.contextPath}${page.url}index?num=${page.prePageNum}">
            上一页
          </a>

          <%--显示的页码，使用forEach遍历显示的页面 --%>
          <c:forEach begin="${page.startPage}" end="${page.endPage}" var="pagenum" varStatus="status">
            <c:if test="${(page.nextPageNum-1) == status.index }">
              <a href="${pageContext.request.contextPath}${page.url}index?num=${pagenum}" class="pageButtonAction">
                  ${status.index}
              </a>
            </c:if>
            <c:if test="${page.currentPageNum != status.index }">
              <a href="${pageContext.request.contextPath}${page.url}index?num=${pagenum}" >
                  ${status.index}
              </a>
            </c:if>
          </c:forEach>

          <a href="${pageContext.request.contextPath}${page.url}index?num=${page.nextPageNum}">下一页</a>
          <a href="${pageContext.request.contextPath}${page.url}index?num=${page.totalPageNum}">末页</a>
          &nbsp;&nbsp;
          <input type="text" id="pagenum" name="pagenum" size="1"/>&nbsp;&nbsp;<input type="button" value="前往" onclick="jump()" />
        </div>
        <%--分页显示的结束--%>


      </ul>
    </div>
    <%@ include file="index-elements/index_rightbar.html"%>
  </div>
</div>
  <%@ include file="index-elements/index_bottom.html"%>
</body>
<script type="text/javascript">
  function jump(){
    var totalpage = ${page.totalPageNum};
    var pagenum = document.getElementById("pagenum").value;
    //判断输入的是一个数字
    var reg =/^[1-9][0-9]{0,1}$/;
    if(!reg.test(pagenum)){
      //不是一个有效数字
      alert("请输入符合规定的数字");
      return ;
    }
    //判断输入的数字不能大于总页数
    if(parseInt(pagenum)>parseInt(totalpage)){
      //超过了总页数
      alert("不能大于总页数");
      return;
    }
    //转向分页显示的Servlet
    window.location.href="${pageContext.request.contextPath}${page.url}index?num="+pagenum;
  }
</script>
</html>