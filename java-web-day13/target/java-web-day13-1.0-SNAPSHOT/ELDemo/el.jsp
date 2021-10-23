<%@ page import="com.example.javawebday13.User.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setName("Terry");
    user.setAge(20);
    user.setDob(new Date());
    request.setAttribute("user",user);
%>
    ${user.name}<br/>
    3>4 返回boolean值:${3>4} <br/>
<%-- 忽略当前el表达式,以原本形态输出可以使用 \ --%>
    \${3>4}
    <h1>算数运算符</h1>
    ${3+4}<br/>
    ${3/4}<br/>
    乘法:${3 div 4}<br/>
    ${3 % 4}<br/>
    除法:${3 mod 4}<br/>
    <h1>比较运算符</h1>
    ${ 3 == 4} <br/>
    <h1>逻辑运算符</h1>
    ${3>4 && 4>3}<br/>
    ${3 > 4 and 4 > 3}<br/>
    ${3 > 4 || 3 < 4}<br/>
    <h1>empty 运算符</h1>
    <%
        String str = "";
        request.setAttribute("str",str);
        List list = new ArrayList();
        request.setAttribute("list",list);
    %>
    empty:${empty str == true? "str is empty" : "str is not empty"}<br/>
    not empty:${not empty list == true? "current is not empty" : "current is empty"}
</body>
</html>
