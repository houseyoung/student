<%--
  Created by IntelliJ IDEA.
  User: houseyoung
  Date: 15/10/23
  Time: 23:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>EditAdminHimself</title>
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
  <form action="${website}admin/admin/edithimself" method="post">
    用户名: <input type="text" name="username" value="${showHimself.username}"/> <br/>
    <%--TODO: 输入两次密码检查是否一致--%>
    密码: <input type="password" name="password"/>（留空则不修改）<br/>
    姓名: <input type="text" name="name" value="${showHimself.name}"/> <br/>
    <input type="submit" value="修改"/>
  </form>
</div>
</body>
</html>
