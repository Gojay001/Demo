<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<h2>SSM_BookSystem</h2>
简单的查询、删除等基础功能<br />
日期：2017-10-22 01:00:00<br />
作者：Gojay<br />
网站：<a href="http://blog.gojay.cn" target="_blank">blog.gojay.cn</a>
<br /><br /><br /><br />
图书系统：<a href="<%=basePath%>/book/list">点击前往</a>
</body>
</html>
