<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/9
  Time: 14:58
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>InsertCourse</title>
</head>
<body>
<form action="${website}admin/course/insert" method="post">
    课程名称: <input type="text" name="name" /> <br />
    课时: <input type="text" name="courseHour" /> <br />
    学分: <input type="text" name="credit" /> <br />
    授课教师: <input type="text" name="teacherName" /> <br />
    授课地点: <input type="text" name="place" /> <br />
    <input type="submit" value="增加" />
    <input type="reset" value="重置" />
</form>
</body>
</html>