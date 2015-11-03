<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/23
  Time: 22:23
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
<a href="${website}admin/school">学院</a><br>
<a href="${website}admin/department">系</a><br>
<a href="${website}admin/class">班级</a><br>
<a href="${website}admin/course">课程</a><br>
<a href="${website}admin/score">成绩</a><br>
<a href="${website}admin/student">学生</a><br>
<a href="${website}admin/health">健康</a><br>
----------------------<br>
<a href="${website}admin/admin">管理员</a><br>
<a href="${website}admin/instructor">辅导员</a><br>
<p><button onclick="location='${website}admin/logoff'">退出登录</button>
</body>
</html>
