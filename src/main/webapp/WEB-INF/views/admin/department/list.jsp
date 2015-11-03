<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 22:43
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>DepartmentList</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<button onclick="location='${website}admin/department/insert'">增加</button>
<p>
<form method=post action="${website}admin/department">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>SchoolName</td>
  </tr>
  <c:forEach var="departmentDto" items="${listDepartment}">
    <tr>
      <td>${departmentDto.id}</td>
      <td>${departmentDto.departmentName}</td>
      <td>${departmentDto.schoolName}</td>
      <td><button onclick="location='${website}/admin/department/edit?id=${departmentDto.id}'">修改</button></td>
      <td><button onclick="location='${website}/admin/department/delete?id=${departmentDto.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>