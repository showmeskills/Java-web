<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
foreach:相当于java代码的for语句
    1. 完成重复的操作
        for(int i = 0; i < 10; i ++){}
        <c:forEach begin="1" end="10" var="i" step="1" varStatus="s">
            逻辑业务
        </c:forEach>
        * 属性：
            begin：开始值
            end：结束值
            var：临时变量
            step：步长
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
    2. 遍历容器
        List<User> list;
        for(User user : list){}
        <c:forEach items="${item}" var="str" varStatus="s">
            逻辑业务
        </c:forEach>
        * 属性：
            items:容器对象
            var:容器中元素的临时变量
            varStatus:循环状态对象
                index:容器中元素的索引，从0开始
                count:循环次数，从1开始
--%>
    <c:forEach begin="0" end="10" var="val" step="1" varStatus="s">
        <ul>
            <li>
                val:${val}<br/>
                s.index:${s.index}<br/>
                s.count:${s.count}<br/>
            </li>
        </ul>
    </c:forEach>
    <%
        List list1 = new ArrayList();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        request.setAttribute("list1",list1);
    %>
    <c:forEach begin="0" end="${list1.size()}" var="idx" step="1" varStatus="l">
        <ul>
            <li>
                value:${list1[idx]}<br/>
                l.index:${l.index}<br/>
                l.count:${l.count}<br/>
            </li>
        </ul>
    </c:forEach>
    <%
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="str" varStatus="s">
        <ul>
            <li>
                下标:${s.index}<br/>
                循环次数:${s.count}<br/>
                List数组的内容:${str}<br/>
                ${list[s.index] == "aaa"?"111":"222"}
            </li>
        </ul>
    </c:forEach>
</body>
</html>
