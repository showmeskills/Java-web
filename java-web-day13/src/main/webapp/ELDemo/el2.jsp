<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    如何session和request 设置名字相同
    EL表达式会从最小的域开始查找
    <%
       session.setAttribute("name","Terry");
       request.setAttribute("name1","Terrance");
       session.setAttribute("age","23");
       request.setAttribute("str","");
    %>
    <%
        String name = (String)session.getAttribute("name");
        String name1 = (String)request.getAttribute("name1");
        String age = (String)session.getAttribute("age");
    %>
    <h1>name=${name}</h1>
    <h1>name1=${name1 == null? "null" : name1}</h1>
    <h1>age=${age}</h1>

    <h1>name=${sessionScope.name}</h1>
    <h1>name1=${requestScope.name1}</h1>
    <h1>age=${sessionScope.age}</h1>

    <h1>name=${name}</h1>




</body>
</html>
