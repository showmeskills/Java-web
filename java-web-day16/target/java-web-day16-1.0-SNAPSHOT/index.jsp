<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

    <input type="button" value="send msg" />
    <input type="text" id="ipt" />

    <script type="text/javascript">
        (()=>{
            //发送异步请求
            var xmlhttp;
            if(window.XMLHttpRequest){
                //code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp = new XMLHttpRequest();
            }else{
                //code for IE6, IE5
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //同步false；异步true
            xmlhttp.open("GET","ajaxServlet?username=tom",true);
            xmlhttp.send();

            xmlhttp.onreadystatechange = ()=>{
                if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                    var response = xmlhttp.responseText;
                    let result = JSON.parse(response);
                    console.log(result)

                }
            }
        })();
    </script>
</body>
</html>