<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
    <a href="hello-servlet.html">Hello Servlet</a>

    <form id="form">
        <input type="text" placeholder="please entry your name" id="user" name="user"/>
        <br/>
        <input type="password" placeholder="please entry your password" id="pwd" name="pwd"/>
        <br/>
        <input type="submit" value="submit" id="btn"/>
    </form>

    <a href="/request-demo-2?username='Terry'">click to demo-2</a>

    <div>
        <button id="submitBtn">click me</button>
    </div>


    <form action="/request-demo-3" method="post">
        <input type="text" placeholder="请输入用户名" name="user"><br>
        <input type="text" placeholder="请输入密码" name="pwd"><br>

        <input type="checkbox" name="hobby" value="game">游戏
        <input type="checkbox" name="hobby" value="study">学习
        <br>

        <input type="submit" value="注册">
    </form>

    <a href="/register.jsp">to Register page</a>


    <div style="margin-top:100px;width:100px;height:100px;border:1px solid red;">
        <a href="./img/2.jpg">image</a>
        <%--   高级版本会自动下载   --%>
        <a href="./img/1.avi">video</a>
        <br/>
        <%--   点击下载图片  --%>
        <a href="/downloadServlet?filename=九尾.jpg">image</a>
        <%--   点击下载video  --%>
        <a href="/downloadServlet?filename=1.avi">video</a>
    </div>

    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        $("document").ready(function(){
            $("#form").on("submit",function(event){
                event.preventDefault();
               let data =  JSON.stringify($(this).serialize());
                console.log(data);
                $.ajax({
                    url:"/request-demo-3",
                    type:"post",
                    data,
                    dataType:"json",
                    success(msg){
                        console.log(msg)
                    }
                })
            })
            $("#submitBtn").on("click",function(){
                $.ajax({
                    url:"/request-demo-3",
                    method:"post",
                    data:{
                        hobbies:["swimming","eating","sleeping"]
                    },
                    dataType:"json",
                })
            })
        })
    </script>
</body>
</html>