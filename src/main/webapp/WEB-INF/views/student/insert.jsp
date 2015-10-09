<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/9
  Time: 22:18
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>InsertStudent</title>
</head>
<body>
<form action="${website}/student/insert" method="post">
  学号: <input type="text" name="studentId" /> <br />
  姓名: <input type="text" name="studentName" /> <br />
  性别: <input type="text" name="sex" /> <br />
  所属班级: <input type="text" name="className" /> <br />
  所属系: <input type="text" name="departmentName" /> <br />
  所属学院: <input type="text" name="schoolName" /> <br />
  生日: <input type="text" name="birthday" /> <br />
  籍贯: <input type="text" name="hometown" /> <br />
  爱好: <input type="text" name="interest" /> <br />
  <input type="submit" value="增加" />
  <input type="reset" value="重置" />
</form>
</body>
</html>