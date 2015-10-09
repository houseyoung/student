<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/9
  Time: 8:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>InsertClass</title>
</head>
<body>
<form action="${website}/class/insert" method="post">
    班级名称: <input type="text" name="className" /> <br />
    所属系: <input type="text" name="departmentName" /> <br />
    所属学院: <input type="text" name="SchoolName" /> <br />
    <input type="submit" value="增加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>