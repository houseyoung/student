<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/10
  Time: 23:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>ScoreList</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<button onclick="location='${website}admin/score/insert'">增加</button>
<p>
<form method=post action="${website}admin/score">
  学号：<input type="text" name="studentId">
  课程名称：<input type="text" name="courseName">
  <input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>StudentId</td>
    <td>StudentName</td>
    <td>CourseId</td>
    <td>CourseName</td>
    <td>Score</td>
  </tr>
  <c:forEach var="scoreDto" items="${listScore}">
    <tr>
      <td>${scoreDto.id}</td>
      <td>${scoreDto.studentId}</td>
      <td>${scoreDto.studentName}</td>
      <td>${scoreDto.courseId}</td>
      <td>${scoreDto.courseName}</td>
      <td>${scoreDto.score}</td>
      <td><button onclick="location='${website}admin/score/edit?id=${scoreDto.id}'">修改</button></td>
      <td><button onclick="location='${website}admin/score/delete?id=${scoreDto.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>