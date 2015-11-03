<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/25
  Time: 22:56
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertInstructor</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<form action="${website}admin/instructor/insert" method="post">
  用户名: <input type="text" name="username" /> <br />
  密码: <input type="password" name="password" /> <br />
  姓名: <input type="text" name="name" /> <br />
  所属班级: <input type="text" name="className" /> <br />
  所属系: <input type="text" name="departmentName" /> <br />
  所属学院: <input type="text" name="schoolName" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>