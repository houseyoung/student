<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/10
  Time: 23:07
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertScore</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<form action="${website}admin/score/insert" method="post">
  课程编号: <input type="text" name="courseId" /> <br />
  学号: <input type="text" name="studentId" /> <br />
  成绩: <input type="text" name="score" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>