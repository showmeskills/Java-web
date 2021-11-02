<%@ page import="com.example.conprehensivejavaweb.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="./utils/common.js"></script>
</head>
<body>
<%--<%--%>
<%--    HttpSession sessionCheck = request.getSession();--%>
<%--    User loginUser = (User)sessionCheck.getAttribute("loginUser");--%>
<%--    System.out.println("index;loginUser===>"+loginUser);--%>
<%--    if(loginUser != null){--%>
<%--%>--%>
<%--<h1 class="text-center text-primary">--%>
<%--    <span style="color:red">${loginUser.username}</span>,Welcome to back;--%>
<%--</h1>--%>
<%--<%--%>
<%--    }--%>
<%--    else {--%>
<%--        request.setAttribute("login_msg","please login in");--%>
<%--        request.getRequestDispatcher("/login.jsp").forward(request,response);--%>
<%--    }--%>
<%--%>--%>
<div class="container">
    <h3 class="text-center">添加联系人</h3>
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <div class="form-group">
            <label for="name">name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名"/>
        </div>
        <div class="form-group">
            <label>gender:</label>
            <input type="radio" name="gender" value="男" checked="checked"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>
        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="上海">上海</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button"  id="goback" value="返回" />
        </div>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        common.goBack("#goback")
    })
</script>
</body>
</html>
