<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传</title>
</head>
<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" /> <input type="submit" value="Submit" /></form>
</body>
</html>