<%@ page import="com.example.conprehensivejavaweb.domain.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
</head>
<body>

<%
    HttpSession sessionCheck = request.getSession();
    User loginUser = (User)sessionCheck.getAttribute("loginUser");
    System.out.println("index;loginUser===>"+loginUser);
    if(loginUser != null){
%>
    <h1 style="color: red">
        ${loginUser.username},Welcome to back;
    </h1>
<%
    }
    else {
        request.setAttribute("login_msg","please login in");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
%>

${loginUser.username}
<%--需要走后端路由然后再req.getRequestDispatcher转发到前端的jsp--%>
<a href="${pageContext.request.contextPath}/userListServlet">to all users list page</a>
<br>
<%--进入分页接口 页面--%>
<a href="${pageContext.request.contextPath}/findUserByPageServlet">to pagination page</a>
<br>
<%--前端路由是获取不到数据--%>
<a href="${pageContext.request.contextPath}/list.jsp">all users</a>
</body>
</html>