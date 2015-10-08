<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 21:46
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertSchool</title>
</head>
<body>
<form action="${website}/school/insert" method="post">
  学院名称: <input type="text" name="name" /> <br />
  所属大学: <input type="text" name="university" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>