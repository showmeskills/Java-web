<%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 19/10/21
  Time: 11:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        div{
            color:red;
        }
    </style>
</head>
<body>

    <form action="/login" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <img id="img" src="/check-code-servlet" style="width: 200px;height: 100px"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="login"/>
                </td>
            </tr>
        </table>
    </form>

    <div>
        <%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%>
    </div>
    <div>
        <%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
    </div>
    <script type="text/javascript">
        window.onload = function (){
            document.getElementById("img").onclick = function (){
                this.src = "/check-code-servlet?"+new Date().getTime();
            }
        }
    </script>
</body>
</html>
