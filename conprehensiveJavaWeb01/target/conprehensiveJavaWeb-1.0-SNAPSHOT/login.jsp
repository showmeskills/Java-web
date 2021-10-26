<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function (){
            $("#refreshCode :nth-child(1)").on("click",function (){
                this.src= "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
            })
        })
    </script>
</head>
<body>
    <div class="container" style="width:40%">
        <h3 style="text-align: center">管理员登录</h3>
        <form action="${pageContext.request.contextPath}/loginServlet" method="post">
            <div class="form-group">
                <label for="username">username:</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="please enter your username"/>
            </div>
            <div class="form-group">
                <label for="password">password:</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="please enter your password"/>
            </div>
            <div class="form-inline">
                <label for="verifiedCode">verified code</label>
                <input type="text" name="verifiedCode" class="form-control" id="verifiedCode" placeholder="please enter verified code" style="width: 120px;"/>
                <a href="javascript:void(0)" id="refreshCode">
                    <img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清点击刷新" id="vcode"/>
                </a>
            </div>
            <hr/>
            <div class="form-group" style="text-align: center;">
                <input style="width: 100%" class="btn btn-primary" type="submit" value="Login"/>
            </div>
        </form>

        <%--   错误信息提示    --%>
        <div class="alert alert-warning alert-dismissable" role="alert">
            <button type="button" class="close" data-dismiss="alert">
                <span>*</span>
            </button>
            <strong>${login_msg}</strong>
        </div>
    </div>
</body>
</html>
