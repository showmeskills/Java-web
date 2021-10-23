<%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 23/10/21
  Time: 12:26 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${pageContext.request}<br/>
    <h1>在jsp页面动态获取虚拟目录</h1>
    获取虚拟路径 "/":${pageContext.request.contextPath}
</body>
</html>
