<%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 19/10/21
  Time: 11:30 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success login</title>
</head>
<body>
    <%
        HttpSession check_session = request.getSession();
        String user = (String)check_session.getAttribute("user");
        if(user != null && user.length() >0){
    %>
    <h1 style="color:red">
        Welcome back to usr:<%=request.getSession().getAttribute("user")%>
    </h1>
    <%
        }
        else {
            response.sendRedirect("/index.jsp");
        }
    %>
    <a href="/index.jsp">
        <%
           request.getSession().removeAttribute("user");
        %>
        logout
    </a>
</body>
</html>
