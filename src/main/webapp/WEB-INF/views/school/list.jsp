<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 21:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>SchoolList</title>
</head>
<body>
<button onclick="location='${website}/school/insert'">增加</button>
<p>
<form method=post action="${website}/school">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>University</td>
  </tr>
  <c:forEach var="school" items="${listSchool}">
    <tr>
      <td>${school.id}</td>
      <td>${school.name}</td>
      <td>${school.university}</td>
      <td><button onclick="location='${website}/school/edit?id=${school.id}'">修改</button></td>
      <td><button onclick="location='${website}/school/delete?id=${school.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>