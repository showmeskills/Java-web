<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: yantinglong
  Date: 18/10/21
  Time: 3:56 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
        Cookie[] cookies = request.getCookies();
        boolean isFlag = false;
        if(cookies.length > 0 && cookies != null){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    isFlag = true;

                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前:"+str_date);

                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后:"+str_date);

                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                    String value = cookie.getValue();
                    System.out.println("解码前:"+value);

                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后:"+value);
%>
                        <h1 style="color:pink">welcome back, your last time visit time:<%=value%></h1>
<%
                    break;
                }
            }
        }

    if(cookies == null || cookies.length == 0 || isFlag == false){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str_date = sdf.format(date);
        System.out.println("编码前:"+ str_date);
        str_date = URLEncoder.encode(str_date,"utf-8");
        System.out.println("编码后:"+str_date);
        Cookie cookie = new Cookie("lastTime",str_date);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);

        str_date = URLDecoder.decode(str_date,"utf-8");
%>
        <h1 style="color:blue">this is your first time to log<%=str_date%></h1>
<%
    }
%>
</body>
</html>
