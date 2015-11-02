<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/11/02
  Time: 20:20
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>ListCourse</title>
</head>
<body>
<table>
  <tr>
    <td>课程ID</td>
    <td>课程名称</td>
    <td>课时</td>
    <td>学分</td>
    <td>授课教师</td>
    <td>上课地点</td>
  </tr>
  <c:forEach var="course" items="${listHimself}">
    <tr>
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.courseHour}</td>
      <td>${course.credit}</td>
      <td>${course.teacherName}</td>
      <td>${course.place}</td>
    </tr>
  </c:forEach>
</table>
<br><button onclick="location='${website}user'">返回</button>
</body>
</html>