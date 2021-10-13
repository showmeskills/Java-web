<%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 13/10/21
  Time: 1:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
        <img id="checkCode" src="/checkCodeServlet" />
        <a id="change" href="register.jsp">看不清换一张？</a>
        <script type="text/javascript">
            window.onload = function(){
                let date = new Date().getTime();//加时间戳的原因是防止缓存
                //点击图片本身切换
                let img = document.getElementById("checkCode");
                img.onclick = function(){
                    img.src = `/checkCodeServlet?${date}`
                }
                //点击链接切换
                let change = document.getElementById("change");
                change.onclick = function(){
                    img.src = `/checkCodeServlet?${date}`
                }
            }
        </script>
</body>
</html>
