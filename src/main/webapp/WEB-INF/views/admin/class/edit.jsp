<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/9
  Time: 8:51
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>EditClass</title>
</head>
<body>
<form action="${website}/admin/class/edit?id=${classDto.id}" method="post">
    班级名称: <input type="text" name="className" value="${classDto.className}"/> <br />
    所属系: <input type="text" name="departmentName" value="${classDto.departmentName}"/> <br />
    所属学院: <input type="text" name="schoolName" value="${classDto.schoolName}"/> <br />
    <input type="submit" value="修改" />
    <input type="reset" value="重置" />
</form>
</body>
</html>