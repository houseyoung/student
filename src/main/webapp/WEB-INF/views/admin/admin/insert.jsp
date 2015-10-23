<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/23
  Time: 23:07
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>InsertAdmin</title>
</head>
<body>
<form action="${website}admin/admin/insert" method="post">
    用户名: <input type="text" name="username" /> <br />
    密码: <input type="password" name="password" /> <br />
    姓名: <input type="text" name="name" /> <br />
    <input type="submit" value="增加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>