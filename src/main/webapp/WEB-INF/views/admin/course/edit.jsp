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
    <title>EditCourse</title>
    <script type="text/javascript">
        //错误提示
        var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

        if(error != null && error != '') {
            alert(error);
        }
    </script>
</head>
<body>
<form action="${website}admin/course/edit?id=${course.id}" method="post">
    课程名称: <input type="text" name="name" value="${course.name}"/> <br />
    课时: <input type="text" name="courseHour" value="${course.courseHour}"/> <br />
    学分: <input type="text" name="credit" value="${course.credit}"/> <br />
    授课教师: <input type="text" name="teacherName" value="${course.teacherName}"/> <br />
    授课地点: <input type="text" name="place" value="${course.place}"/> <br />
    <input type="submit" value="修改" />
    <input type="reset" value="重置" />
</form>
</body>
</html>