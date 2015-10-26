<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/27
  Time: 00:42
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InstructorIndex</title>
</head>
<body>
<table>
  <tr>
    <td>ID</td>
    <td>UserName</td>
    <td>Name</td>
    <td>ClassName</td>
    <td>DepartmentName</td>
    <td>SchoolName</td>
  </tr>
  <tr>
    <td>${showInstructorHimself.id}</td>
    <td>${showInstructorHimself.username}</td>
    <td>${showInstructorHimself.name}</td>
    <td>${showInstructorHimself.className}</td>
    <td>${showInstructorHimself.departmentName}</td>
    <td>${showInstructorHimself.schoolName}</td>
    <td>
      <button onclick="location='${website}admin/instructor/edithimself'">修改个人信息</button>
    </td>
  </tr>
</table>
</body>
</html>