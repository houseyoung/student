<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/11
  Time: 23:16
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertHealth</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<form action="${website}admin/health/insert" method="post">
  学号: <input type="text" name="studentId" /> <br />
  身高: <input type="text" name="height" /> <br />
  体重: <input type="text" name="weight" /> <br />
  营养情况: <input type="text" name="nutrition" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>