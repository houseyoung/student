<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 21:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>SchoolList</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<button onclick="location='${website}admin/school/insert'">增加</button>
<p>
<form method=post action="${website}admin/school">
  <input type="text" name="keywords"><input type="submit" value="搜索">
</form>
<p>
<table>
  <tr>
    <td>ID</td>
    <td>Name</td>
    <td>University</td>
  </tr>
  <c:forEach var="school" items="${listSchool}">
    <tr>
      <td>${school.id}</td>
      <td>${school.name}</td>
      <td>${school.university}</td>
      <td><button onclick="location='${website}admin/school/edit?id=${school.id}'">修改</button></td>
      <td><button onclick="location='${website}admin/school/delete?id=${school.id}'">删除</button></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>