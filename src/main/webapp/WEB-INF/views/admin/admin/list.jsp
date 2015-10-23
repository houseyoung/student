<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/23
  Time: 23:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>AdminList</title>
</head>
<body>
<button onclick="location='${website}admin/admin/insert'">增加</button>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>UserName</td>
    <td>Name</td>
  </tr>
    <tr>
      <td>${showHimself.id}</td>
      <td>${showHimself.username}</td>
      <td>${showHimself.name}</td>
      <td><button onclick="location='${website}admin/admin/edithimself'">修改个人信息</button></td>
    </tr>
</table>
----------------------<p>
其他管理员: <br>
<form method=post action="${website}admin/admin">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>UserName</td>
    <td>Name</td>
  </tr>
  <c:forEach var="admin" items="${listAdmin}">
    <tr>
      <td>${admin.id}</td>
      <td>${admin.username}</td>
      <td>${admin.name}</td>
      <td><button onclick="location='${website}admin/admin/delete?id=${admin.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>