<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/11
  Time: 23:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>HealthList</title>
</head>
<body>
<button onclick="location='${website}/admin/health/insert'">增加</button>
<p>
<form method=post action="${website}/admin/health">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>StudentID</td>
    <td>StudentName</td>
    <td>Height</td>
    <td>Weight</td>
    <td>Nutrition</td>
  </tr>
  <c:forEach var="healthDto" items="${listHealth}">
    <tr>
      <td>${healthDto.id}</td>
      <td>${healthDto.studentId}</td>
      <td>${healthDto.studentName}</td>
      <td>${healthDto.height}</td>
      <td>${healthDto.weight}</td>
      <td>${healthDto.nutrition}</td>
      <td><button onclick="location='${website}/admin/health/edit?id=${healthDto.id}'">修改</button></td>
      <td><button onclick="location='${website}/admin/health/delete?id=${healthDto.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>