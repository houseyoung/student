<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/25
  Time: 22:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>InstructorList</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<button onclick="location='${website}admin/instructor/insert'">增加</button>
<p>
<form method=post action="${website}admin/instructor">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>UserName</td>
    <td>Name</td>
    <td>ClassName</td>
    <td>DepartmentName</td>
    <td>SchoolName</td>
  </tr>
  <c:forEach var="instructor" items="${listInstructor}">
    <tr>
      <td>${instructor.id}</td>
      <td>${instructor.username}</td>
      <td>${instructor.name}</td>
      <td>${instructor.className}</td>
      <td>${instructor.departmentName}</td>
      <td>${instructor.schoolName}</td>
      <td><button onclick="location='${website}admin/instructor/edit?id=${instructor.id}'">修改</button></td>
      <td><button onclick="location='${website}admin/instructor/delete?id=${instructor.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>