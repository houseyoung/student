<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/25
  Time: 23:28
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>EditInstructor</title>
  <script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
      alert(error);
    }
  </script>
</head>
<body>
<form action="${website}admin/instructor/edit?id=${adminDto.id}" method="post">
  用户名: <input type="text" name="username" value="${adminDto.username}"/> <br />
  姓名: <input type="text" name="name" value="${adminDto.name}"/> <br />
  所属班级: <input type="text" name="className" value="${adminDto.className}"/> <br />
  所属系: <input type="text" name="departmentName" value="${adminDto.departmentName}"/> <br />
  所属学院: <input type="text" name="schoolName" value="${adminDto.schoolName}"/> <br />
  <input type="submit" value="修改" />
  <input type="reset" value="重置" />
</form>
</body>
</html>
