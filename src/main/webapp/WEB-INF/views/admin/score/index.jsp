<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/11
  Time: 22:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
</head>
<body>
成绩查询：
<form method=post action="${website}/admin/score/list">
  学号：<input type="text" name="studentId"><br>
  课程名称：<input type="text" name="courseName">
  <input type="submit" value="搜索">
</form>
</body>
</html>
