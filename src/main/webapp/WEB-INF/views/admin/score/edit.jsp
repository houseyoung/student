<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/10
  Time: 23:09
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>EditScore</title>
</head>
<body>
<form action="${website}admin/score/edit?id=${scoreDto.id}" method="post">
  课程编号: <input type="text" name="courseId" value="${scoreDto.courseId}"/> <br />
  学号: <input type="text" name="studentId" value="${scoreDto.studentId}"/> <br />
  成绩: <input type="text" name="score" value="${scoreDto.score}"/> <br />
  <input type="submit" value="修改" />
  <input type="reset" value="重置" />
</form>
</body>
</html>