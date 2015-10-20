<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/11
  Time: 23:18
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>EditHealth</title>
</head>
<body>
<form action="${website}admin/health/edit?id=${healthDto.id}" method="post">
  学号: <input type="text" name="studentId" value="${healthDto.studentId}"/> <br />
  身高: <input type="text" name="height" value="${healthDto.height}"/> <br />
  体重: <input type="text" name="weight" value="${healthDto.weight}"/> <br />
  营养状况: <input type="text" name="nutrition" value="${healthDto.nutrition}"/> <br />
  <input type="submit" value="修改" />
  <input type="reset" value="重置" />
</form>
</body>
</html>