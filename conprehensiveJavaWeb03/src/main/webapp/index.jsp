<%@ page import="com.example.conprehensivejavaweb.domain.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <script src="js/jquery-2.1.0.min.js"></script>
    <title>首页</title>
</head>
<body>

<%--<%--%>
<%--    HttpSession sessionCheck = request.getSession();--%>
<%--    User loginUser = (User)sessionCheck.getAttribute("loginUser");--%>
<%--    System.out.println("index;loginUser===>"+loginUser);--%>
<%--    if(loginUser != null){--%>
<%--%>--%>
<%--    <h1 style="color: red">--%>
<%--        ${loginUser.username},Welcome to back;--%>
<%--    </h1>--%>
<%--<%--%>
<%--    }--%>
<%--    else {--%>
<%--        request.setAttribute("login_msg","please login in");--%>
<%--        request.getRequestDispatcher("/login.jsp").forward(request,response);--%>
<%--    }--%>
<%--%>--%>

${loginUser.username}
<%--需要走后端路由然后再req.getRequestDispatcher转发到前端的jsp--%>
<a href="${pageContext.request.contextPath}/userListServlet">to all users list page </a>
<br>
<%--进入分页接口 页面--%>
<a href="${pageContext.request.contextPath}/findUserByPageServlet">to pagination page</a>
<br>
<%--前端路由是获取不到数据--%>
<a href="${pageContext.request.contextPath}/list.jsp">all users</a>

<br>
<input type="text" id="ipt" />
<h1 style="color:red" id="txt">${data}</h1>
<button class="btn btn-primary"> click</button>
<script type="text/javascript">
    $(".btn").on("click",function(){
        $.ajax({
            url:"http://localhost:8080/caseStudy/api/filterWords",
            data:{
                "ipt":$("#ipt").val(),
            },
            type:"get",
            success(response){
                console.log(response)
            },
            failed(){}
    })
   })
</script>
</body>
</html>