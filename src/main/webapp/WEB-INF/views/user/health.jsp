<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/11
  Time: 23:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>ListScore</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<table>
  <tr>
    <td>身高</td>
    <td>体重</td>
    <td>营养状况</td>
  </tr>
  <c:forEach var="health" items="${listHimself}">
    <tr>
      <td>${health.height}</td>
      <td>${health.weight}</td>
      <td>${health.nutrition}</td>
    </tr>
  </c:forEach>
</table>
<br><button onclick="location='${website}user'">返回</button>
</body>
</html>