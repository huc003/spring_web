<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/1
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>SSE demo</title>
</head>
<body>
    <div id="msgFrompPush"></div>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.js"/>"></script>
    <script>
        if (!!window.EventSource){//EventSource对象只有新式的浏览器才有（Chrome、Firefox）等，EventSource是SSE的客户端
            var source = new EventSource('push');
            s = '';
            source.addEventListener('message',function (e) {//2添加SSE客户端的监听，在此获得服务端推送的消息
                s+=e.data+"<br/>";
                $("#msgFrompPush").html(s);
            });

            source.addEventListener('open',function (e) {
                console.log("链接打开.");
            },false);

            source.addEventListener('error',function (e) {
                if(e.readyState==EventSource.CLOSED){
                    console.log("链接关闭.");
                }else {
                    console.log(e.readyState);
                }
            });
        }else {
            console.log("您的浏览器不支持SSE");
        }
    </script>




</body>
</html>
