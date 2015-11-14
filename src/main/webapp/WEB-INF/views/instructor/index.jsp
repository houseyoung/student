<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
    <title>辅导员主页</title>
    <%@ include file="common/head.jsp" %>
    <link rel="stylesheet" href="${website}resources/css/teacher/student-info-management/student-info-management.css"/>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="page clearfix">
    <%@ include file="common/sidebar.jsp" %>
    <div class="holder">
        <div class="container">
            <div class="row">
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- holder -->
</div>
<!-- page -->
<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        $('.J_del').click(function () {
            var
                    tr = $(this).parent().parent();

            tr.remove();
        });
    });
</script>
</body>
</html>