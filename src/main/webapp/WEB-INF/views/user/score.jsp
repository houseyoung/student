<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/10
  Time: 23:34
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>ListScore</title>
</head>
<body>
<table>
  <tr>
    <td>CourseID</td>
    <td>CourseName</td>
    <td>Score</td>
  </tr>
  <c:forEach var="score" items="${listHimself}">
  <tr>
    <td>${score.courseId}</td>
    <td>${score.courseName}</td>
    <td>${score.score}</td>
  </tr>
  </c:forEach>
</table>
<br><button onclick="location='${website}user'">返回</button>
</body>
</html>