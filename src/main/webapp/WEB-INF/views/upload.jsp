<%--
  Created by IntelliJ IDEA.
  User: house
  Date: 2015/11/12
  Time: 16:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>上传文件</title>
    <script type="text/javascript" src="${website}resources/tool/jquery/jquery.js"></script>
    <script>
        $(document).ready(function () {
            var fileUrl = '<%=request.getAttribute("fileUrl") == null ? "" : request.getAttribute("fileUrl")%>';
            if (fileUrl != null && fileUrl != '') {
                var text = "<br>上传成功!</br>";
                var link = "<a href='${fileUrl}'>${fileName}</a>";
                $("body").append(text, link);
            }
        });
    </script>
</head>
<body>
<form action="${website}fileupload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/> <input type="submit" value="Submit"/>
</form>
</body>
</html>