<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 22:45
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>EditDepartment</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<form action="${website}admin/department/edit?id=${departmentDto.id}" method="post">
  系名称: <input type="text" name="departmentName" value="${departmentDto.departmentName}"/> <br />
  所属学院: <input type="text" name="schoolName" value="${departmentDto.schoolName}"/> <br />
  <input type="submit" value="修改" />
  <input type="reset" value="重置" />
</form>
</body>
</html>