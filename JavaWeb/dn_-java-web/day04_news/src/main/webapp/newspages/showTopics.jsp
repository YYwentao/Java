<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="classlist" id="topicsList">
<c:forEach items="${requestScope.list}" var="topic">
    <li> &#160;&#160;&#160;&#160; ${topic.tname} &#160;&#160;&#160;&#160; <a href='javascript:;' class="tpsMdfLink" id='${topic.tid}:${topic.tname}'>修改</a> &#160;&#160;&#160;&#160; <a href='javascript:;' class="tpsDelLink" id='${topic.tid}'>删除</a> </li>
</c:forEach>
</ul>