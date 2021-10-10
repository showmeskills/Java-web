<%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 8/10/21
  Time: 11:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        #form{
            width:800px;
            height: 500px;
            margin:50px auto;
            padding:25px 50px;
        }
        #form>input{
            width:100%;
            height:50px;
        }
        #form>input:nth-child(2),
        #form>input:nth-child(6){
            height: 30px;
            padding-left:12px;
            margin-left:12px;
        }
        #form>input:last-child{
            border:none;
            background-color: aqua;
            border-radius: 10px;
            color:white;
            font-size:20px;
        }
        #form .info1,
        #form .info2{
            font-size:16px;
            color:red;
            opacity:0;
        }
    </style>
</head>
<body>
    <form id="form" action="/request-demo-3" method="post">
        <lable for="username" style="font-size:16px;font-weight:700">Username:</lable>
        <input type="text" name="username" id="username" placeholder="Please,enter your name" />
        <p class="info1">your username is invalid</p>
        <br/>
        <lable for="password" style="font-size:16px;font-weight:700">Password:</lable>
        <input type="text" name="password" id="password" placeholder="Please,enter your password" />
        <p class="info2">your password is invalid</p>
        <br/>
        <input type="submit" value="register"/>
    </form>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
       $(document).ready(function(){

         $("#username").on("change",function(){
            let value = $(this).val();
            if(value.trim() === ""){
                $(".info1").css({
                    opacity:1,
                })
            }else{
                $(".info1").css({
                    opacity:0,
                })
            }
         })

         $("#password").on("change",function(){
             let value = $(this).val();
             if(value.trim() === ""){
                 $(".info2").css({
                     opacity:1,
                 })
             }else{
                 $(".info2").css({
                     opacity:0,
                 })
             }
         })

       })
    </script>
</body>
</html>
