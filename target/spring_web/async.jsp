<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/2
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>async</title>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.js"/>"></script>
    <script>

        deferred();//1页面打开就会向后台发送请求

        function deferred() {
            $.get('defer',function (data) {
                console.log(data);//2在控制台输出服务端推送的数据
                deferred();//3一次请求完成后再向后台发送请求
            })
        }
    </script>
</head>
<body>

</body>
</html>
