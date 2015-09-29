<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body><table>
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Role</td>
    </tr>
    <c:forEach var="user" items="${listUser}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>
            <%--<td><button onclick="location='${website}score/score_edit?id=${score.id}'">修改</button></td>--%>
            <%--<td><button onclick="location='${website}score/score_delete?id=${score.id}'">删除</button></td>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>