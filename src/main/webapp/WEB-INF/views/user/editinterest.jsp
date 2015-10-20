<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/20
  Time: 16:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditInterest</title>
</head>
<body>
<div style="width: 25%; margin-left: auto; margin-right: auto;">
    <form action="${website}user/editinterest" method="post">
        兴趣: <input type="text" name="interest"  value="${showHimself.interest}"/> <br/>
        <input type="submit" value="修改"/>
    </form>
</div>
</body>
</html>