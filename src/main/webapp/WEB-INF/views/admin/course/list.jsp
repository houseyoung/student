<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/9
  Time: 14:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CourseList</title>
</head>
<body>
<button onclick="location='${website}/admin/course/insert'">增加</button>
<p>
<form method=post action="${website}/admin/course">
    <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>CourseHour</td>
        <td>Credit</td>
        <td>TeacherName</td>
        <td>Place</td>
    </tr>
    <c:forEach var="course" items="${listCourse}">
        <tr>
            <td>${course.id}</td>
            <td>${course.name}</td>
            <td>${course.courseHour}</td>
            <td>${course.credit}</td>
            <td>${course.teacherName}</td>
            <td>${course.place}</td>
            <td><button onclick="location='${website}/admin/course/edit?id=${course.id}'">修改</button></td>
            <td><button onclick="location='${website}/admin/course/delete?id=${course.id}'">删除</button></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
