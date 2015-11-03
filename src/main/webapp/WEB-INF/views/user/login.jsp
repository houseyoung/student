<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 2015/10/10
  Time: 9:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentLogin</title>
    <script type="text/javascript">
        //错误提示
        var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

        if(error != null && error != '') {
            alert(error);
        }
    </script>
</head>
<body>
<div style="width: 25%; margin-left: auto; margin-right: auto;">
    <p style="margin: 0;">登录</p>
    <form action="${website}user/login" method="post">
        用户名: <input type="text" name="studentId"/> <br/>
        密码: <input type="password" name="password"/> <br/>
        <input type="submit" value="登录"/>
        <input type="reset" value="重置"/>
    </form>
</div>
</body>
</html>
