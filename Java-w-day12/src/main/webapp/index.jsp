<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            margin:0;
            padding: 0;
        }
    </style>
</head>
<body>

    <%
        System.out.println("hello world");
        int i = 5;

    %>

    <%= "hello!!!!"%>

    <%! int i = 3; %>

   <div>
       <%
           response.getWriter().write("<h1 style=\"color:blue\">response.....</h1>");
       %>
   </div>

    <a href="/app.jsp">to app</a>
    <br/>
    <a href="/login.jsp"> to login </a>
    <script type="text/javascript">
        const getCookie = (cookieName)=>{
            let nameEQ = cookieName + "=";
            let cookie = document.cookie.split(";");
            for(let i = 0; i <cookie.length;i++){
                let c = cookie[i];
                while(c.charAt(0) == " "){
                    c = c.substring(1,c.length);
                    if(c.indexOf(nameEQ) == 0){
                        return c.substring(nameEQ.length,c.length)
                    }
                }
            }
            return null;
        }
        let value = getCookie("x-params-api");
        let value1 = getCookie("x-param-api");
        let value2 = getCookie("x-param-app");
        console.log(value)
        console.log(value1)
        console.log(value2)
    </script>
</body>
</html>