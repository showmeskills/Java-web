<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Demo</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        #form{
            width:800px;
            height: 800px;
            margin:100px auto;
        }
        #form>input{
            width:100%
        }
    </style>
</head>
<body>
    <form id="form" action="/login" method="post">
        <label for="username">Username:</label>
        <input type="text" placeholder="please enter your name" name="username" id="username"/>
        <br/>
        <label for="password">Password</label>
        <input type="password" placeholder="please enter your password" name="password" id="password"/>
        <input type="submit" value="login"/>
    </form>

    <button id="btn">click to sendRedirect</button>
    <a href="/response-demo3">to Req.getRequestDispatcher</a>

    <div>
        <a href="/register.jsp">to Register</a>
    </div>

    <div>
        <a href="/img/2.jpg">图片1</a>
        <a href="/img/1.avi">视频</a>
        <hr>
        <a href="/downloadServlet?filename=九尾.jpg">图片1</a>
        <a href="/downloadServlet?filename=1.avi">视频</a>
    </div>
    <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.min.js"></script>
    <script type="text/javascript">
        window.onload = function(){
            let btn = document.getElementById("btn");
            const userWindow = (url,windowName)=>{
                let openWindow = window.open(url,windowName,"height=1000,width=1000");
                if(window.focus){openWindow.focus()}
                return false;
            }
            btn.onclick = function(){
                userWindow("/response-demo1","redirect")
            }

           axios.get("/servletContextDemo2").then((res)=>console.log(res)).catch(err=>console.log(err))

        }
    </script>
</body>
</html>