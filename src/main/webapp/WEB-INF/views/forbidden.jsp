<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/9/27
  Time: 22:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forbidden</title>
</head>
<body>
您没有访问该页面的权限，请返回重试。
<br>
<input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回上一页">
<button onclick="javascript:window.location.href='${website}';">返回首页</button>
</body>
</html>
