<%@ page import="com.example.javawebday13.User.User" %>
<%@ page import="java.util.*" %>
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
    <h1>获取对象值</h1>
    获取对象(需要重写toString方法)不然返回地址值:${requestScope.user}<br/>
    <%--
        通过的是对象的属性来获取
        setter或getter方法,去掉set或get,在将剩余部分,首字母小写
        setName -> Name -> name
     --%>
    name:${requestScope.user.name}<br/>
    age:${user.age}<br/>
    dob:${user.dob}<br/>
    dobStr:${user.birStr}<br/>
    month:${user.dob.month+1}<br/>

    <%
        List lists = new ArrayList();
        lists.add("aaa");
        lists.add("bbb");
        lists.add(user);
        request.setAttribute("lists",lists);
    %>
    <%--
        获取List中的数据
    --%>
    //获取整个list
    List:${lists}<br/>
    //获取idx值
    List1:${lists.get(2)}<br/>
    List2:${lists[2]}<br/>
    <br/>
    <br/>
    <br/>
    <%
        User user1 = new User();
        user.setName("Terry1");
        user.setAge(22);
        user.setDob(new Date());
        Map<String,Object> map = new HashMap();
        map.put("name","Terrance");
        map.put("gender","male");
        map.put("user1",user1);

        request.setAttribute("map",map);
    %>
    <%--
        获取Map中的数据
     --%>
       ${map.gender}<br/>
       ${map["gender"]}<br/>
        ${map.user1.name}<br/>
        ${map.get("name")}<br/>
<%--   多个jsp页面可以共享一个session数据,但是不能共享request数据 --%>
    <h1>name=${name}</h1>
    <h1>name1=${name1 == null? "null" : name1}</h1>
</body>
</html>
