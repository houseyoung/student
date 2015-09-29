<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/9/29
  Time: 15:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${website}insert" method="post">
    username: <input type="text" name="username" /> <br />
    password: <input type="text" name="password" /> <br />
    role: <input type="text" name="role" /> <br />
    <input type="submit" value="增加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>
