<%--
  author: WEI.ZHOU
  data: 2021/4/20 18:26
  versions：v1.0.0
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>userList</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script></script>
</head>
<body>
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">用户列表</div>

    <div class="table-responsive">
        <table class="table">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">编&nbsp;&nbsp;号</th>
                    <th scope="col">用户名</th>
                    <th scope="col">密&nbsp;&nbsp;码</th>
                    <th scope="col">邮&nbsp;&nbsp;箱</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <th scope="row">${user.uid}</th>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </table>
    </div>
</div>

</body>
</html>
