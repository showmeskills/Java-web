<%@ page import="java.util.List" %>
<%@ page import="com.example.javawebday13.User.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        List<User> list = new ArrayList<>();
        list.add(new User("T1",20,new Date()));
        list.add(new User("T2",21,new Date()));
        list.add(new User("T3",22,new Date()));
        request.setAttribute("list",list);
    %>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <tr>
                <th>${s.count}</th>
                <th>${user.name}</th>
                <th>${user.age}</th>
                <th>${user.birStr}</th>
            </tr>
        </c:forEach>
    </table>


    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
           <c:if test="${s.count % 2 != 0}">
               <tr bgcolor="yellow">
                   <th>${s.count}</th>
                   <th>${user.name}</th>
                   <th>${user.age}</th>
                   <th>${user.birStr}</th>
               </tr>
           </c:if>
            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="#ffc0cb">
                    <th>${s.count}</th>
                    <th>${user.name}</th>
                    <th>${user.age}</th>
                    <th>${user.birStr}</th>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
