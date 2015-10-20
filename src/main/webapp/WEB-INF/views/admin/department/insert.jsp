<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 22:46
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertDepartment</title>
</head>
<body>
<form action="${website}admin/department/insert" method="post">
  系名称: <input type="text" name="departmentName" /> <br />
  所属学院: <input type="text" name="schoolName" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>