<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/10
  Time: 15:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditPassword</title>
</head>
<body>
<div style="width: 25%; margin-left: auto; margin-right: auto;">
    <form action="${website}/user/editpassword" method="post">
        <%--TODO: 输入两次密码检查是否一致--%>
        新密码: <input type="password" name="password"/> <br/>
        <input type="submit" value="修改"/>
    </form>
</div>
</body>
</html>
