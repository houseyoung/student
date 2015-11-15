<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>欢迎页</title>
  <%@ include file="student/common/head.jsp" %>
  <link rel="stylesheet" href="${website}resources/css/base/welcome.css" />
</head>
<body>
<div class="welcome">
  <h2>欢迎使用学生资料管理系统</h2>
  <div class="entry">
    <h4>请选择登录入口&nbsp;:</h4>
    <div>
      <a href="${website}admin" class="btn-glow admin">管理员/辅导员登录</a>
      <a href="${website}student" class="btn-glow">学生登录</a>
    </div>
  </div>
</div>
</body>
</html>