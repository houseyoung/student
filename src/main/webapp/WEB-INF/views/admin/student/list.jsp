<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 20:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>StudentList</title>
</head>
<body>
<button onclick="location='${website}/admin/student/insert'">增加</button>
<p>
<form method=post action="${website}/admin/student">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>StudentID</td>
    <td>Name</td>
    <td>Sex</td>
    <td>Class</td>
    <td>Department</td>
    <td>School</td>
    <td>Birthday</td>
    <td>Hometown</td>
    <td>Interest</td>
  </tr>
  <c:forEach var="studentDto" items="${listStudent}">
    <tr>
      <td>${studentDto.studentId}</td>
      <td>${studentDto.studentName}</td>
      <td>${studentDto.sex}</td>
      <td>${studentDto.className}</td>
      <td>${studentDto.departmentName}</td>
      <td>${studentDto.schoolName}</td>
      <td>${studentDto.birthday}</td>
      <td>${studentDto.hometown}</td>
      <td>${studentDto.interest}</td>
      <td><button onclick="location='${website}/admin/student/edit?id=${studentDto.id}'">修改</button></td>
      <td><button onclick="location='${website}/admin/student/delete?id=${studentDto.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>