<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/9/27
  Time: 14:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="width: 25%; margin-left: auto; margin-right: auto;">
  <p style="margin: 0;">请登录</p>
  <form action="${website}login" method="post">
    用户名: <input type="text" name="username" /> <br />
    密码： <input type="password" name="password" /> <br />
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
  </form>
</div>
</body>
</html>
