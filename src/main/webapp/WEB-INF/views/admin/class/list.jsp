<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/9
  Time: 8:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ClassList</title>
</head>
<body>
<button onclick="location='${website}/admin/class/insert'">增加</button>
<p>
<form method=post action="${website}/admin/class">
    <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>DepartmentName</td>
        <td>SchoolName</td>
    </tr>
    <c:forEach var="classDto" items="${listClass}">
        <tr>
            <td>${classDto.id}</td>
            <td>${classDto.className}</td>
            <td>${classDto.departmentName}</td>
            <td>${classDto.schoolName}</td>
            <td><button onclick="location='${website}/admin/class/edit?id=${classDto.id}'">修改</button></td>
            <td><button onclick="location='${website}/admin/class/delete?id=${classDto.id}'">删除</button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>