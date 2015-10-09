<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/9
  Time: 22:59
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
  <title>EditStudent</title>
</head>
<body>
<form action="${website}/student/edit?id=${studentDto.id}" method="post">
  学号: <input type="text" name="studentId" value="${studentDto.studentId}"/> <br />
  姓名: <input type="text" name="studentName" value="${studentDto.studentName}"/> <br />
  性别: <input type="text" name="sex" value="${studentDto.sex}"/> <br />
  所属班级: <input type="text" name="className" value="${studentDto.className}"/> <br />
  所属系: <input type="text" name="departmentName" value="${studentDto.departmentName}"/> <br />
  所属学院: <input type="text" name="schoolName" value="${studentDto.schoolName}"/> <br />
  生日: <input type="text" name="birthday" value="${studentDto.birthday}"/> <br />
  籍贯: <input type="text" name="hometown" value="${studentDto.hometown}"/> <br />
  爱好: <input type="text" name="interest" value="${studentDto.interest}"/> <br />
  <input type="submit" value="修改" />
  <input type="reset" value="重置" />
</form>
</body>
</html>