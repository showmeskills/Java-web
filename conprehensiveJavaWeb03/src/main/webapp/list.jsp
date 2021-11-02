<%@ page import="com.example.conprehensivejavaweb.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <title>用户信息管理系统</title>
</head>
<body>
<%--<%--%>
<%--    HttpSession sessionCheck = request.getSession();--%>
<%--    User loginUser = (User)sessionCheck.getAttribute("loginUser");--%>
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
        <h3 class="text-center">
            用户信息列表
        </h3>
        <div style="float: left;">
            <%--     search user       --%>
            <form class="form-inline" action="${pageContext.request.contextPath}/findUserByPageServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">姓名</label>
                    <%--  value值为什么 condition.name[0] 搜索后保持input内有值   --%>
                    <input type="text" name="name" value="${condition.name[0]}" class="form-control" id="exampleInputName2" >
                </div>
                <div class="form-group">
                    <label for="exampleInputName3">籍贯</label>
                    <input type="text" name="address" value="${condition.address[0]}" class="form-control" id="exampleInputName3" >
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail2">邮箱</label>
                    <input type="text" name="email" value="${condition.email[0]}" class="form-control" id="exampleInputEmail2"  >
                </div>
                <button type="submit" class="btn btn-default">查询</button>
            </form>

        </div>
        <%--  link to add.jsp      --%>
        <div style="float: right;margin: 5px;">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
            <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
        </div>
        <%--    user table    --%>
        <form  id="form" class="form-inline" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
                <table border="1" class="table table-bordered table-hover">
                    <tr class="success">
                        <th><input type="checkbox" id="firstCb"></th>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>地址</th>
                        <th>QQ</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pb.list}" var="user" varStatus="s">
                        <tr>
                            <td><input type="checkbox" class="uid" name="uid" value="${user.id}"/></td>
                            <td>${s.count}</td>
                            <td>${user.name}</td>
                            <td>${user.gender}</td>
                            <td>${user.age}</td>
                            <td>${user.address}</td>
                            <td>${user.qq}</td>
                            <td>${user.email}</td>
                            <td>
                                <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUserServlet?id=${user.id}">修改</a>&nbsp;
                                <a class="btn btn-default btn-sm " href="javascript:deleteUser(${user.id});">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        <%--   page pagination     --%>
        <div>
            <nav aria-label="Page navigation" style="display: flex;align-items: center;justify-content: flex-start">
                <ul class="pagination" >
                    <c:if test="${pb.currentPage == 1}"></c:if>
                    <c:if test="${pb.currentPage != 1}">
                        <li>
                            <%-- 为什么query parameters 上面 要保持name,adress and email 值 因为当分页跳转的时候可以保持模糊查询input的值 --%>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage - 1}&rows=${rows}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=${rows}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=${rows}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${pb.currentPage != pb.totalPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${pb.currentPage + 1}&rows=${rows}&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
                <span style="font-size: 25px;margin-left: 5px;">
                            共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
                <span style="font-size:25px;margin-left: 5px;">
                    输入改变当页显示的条数:<input type="text" name="rows" id="rows" style="width: 25px;height: 25px;"/>
                </span>
            </nav>
        </div>
    </div>

    <script type="text/javascript">
        $(document).ready(function(){
            function deleteUser(id){
                const confirm = window.confirm("你确定要删除吗?");
                if(confirm){
                    window.location.href="${pageContext.request.contextPath}/delUserServlet?id="+id;
                }
            }
            //jquery front end select all
            $(document).on("click","#firstCb",function(){
                for(let i = 0; i < $(".uid").length; i++){
                    $(".uid")[i].checked = this.checked;
                }
            })
            //delete selected users
            $(document).on("click","#delSelected",function(){
                let flag = false;
                let $uid = $(".uid");
                if(confirm("确定要删除吗")){
                    for(let i = 0; i < $uid.length;i++){
                        if($uid[i].checked){
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag){
                    document.getElementById("form").submit();
                }
            })
            //checkout rows
            $("#rows").on("change",function(){
                if($(this).val()){
                    window.location.href="${pageContext.request.contextPath}/findUserByPageServlet?rows="+$(this).val();
                }
            })
        })
    </script>
</body>
</html>
