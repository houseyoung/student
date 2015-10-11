<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/8
  Time: 20:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>UserIndex</title>
</head>
<body>
<table>
    <tr>
        <td>StudentID</td>
        <td>Name</td>
        <td>Sex</td>
        <td>Class</td>
        <td>Department</td>
        <td>School</td>
        <td>Birthday</td>
        <td>Hometown</td>
        <td>Interest</td>
    </tr>
    <tr>
        <td>${showHimself.studentId}</td>
        <td>${showHimself.studentName}</td>
        <td>${showHimself.sex}</td>
        <td>${showHimself.className}</td>
        <td>${showHimself.departmentName}</td>
        <td>${showHimself.schoolName}</td>
        <td>${showHimself.birthday}</td>
        <td>${showHimself.hometown}</td>
        <td>${showHimself.interest}</td>
        <td>
            <button onclick="location='${website}/user/editinterest'">修改兴趣</button>
            <button onclick="location='${website}/user/editpassword'">修改密码</button>
            <button onclick="location='${website}/user/score'">查看成绩</button>
            <button onclick="location='${website}/user/health'">查看健康信息</button>
        </td>
    </tr>
</table>
<p><button onclick="location='${website}/user/logoff'">退出登录</button>
</body>
</html>