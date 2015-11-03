<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/26
  Time: 22:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminIndex</title>
    <script type="text/javascript">
        //错误提示
        var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

        if(error != null && error != '') {
            alert(error);
        }
    </script>
</head>
<body>
<a href="${website}admin/class">班级</a><br>
<a href="${website}admin/score">成绩</a><br>
<a href="${website}admin/student">学生</a><br>
<a href="${website}admin/health">健康</a><br>
----------------------<br>
<a href="${website}admin/instructor/showhimself">个人信息</a><br>
<p><button onclick="location='${website}admin/logoff'">退出登录</button>
</body>
</html>
