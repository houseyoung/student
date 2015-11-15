<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<link rel="icon" href="${website}resources/img/common/favicon.ico" />
<link rel="stylesheet" href="${website}resources/css/base/reset.css" />
<link rel="stylesheet" href="${website}resources/tool/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" href="${website}resources/tool/bootstrap/css/bootstrapValidator.css" />
<link rel="stylesheet" href="${website}resources/tool/base-widget/css/font-awesome.css" />
<link rel="stylesheet" href="${website}resources/css/admin/common/common.css" />
<!--[if lt IE 9]>
<link rel="stylesheet" href="${website}resources/tool/base-widget/css/ie8.css">
<script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/respond.js/1.1.0/respond.min.js"></script>
<script type="text/javascript" src="assets/plugins/charts-flot/excanvas.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${website}resources/tool/jquery/jquery.js"></script>
<script type="text/javascript" src="${website}resources/tool/bootstrap/js/bootstrapValidator.js"></script>
<script type="text/javascript">
    //错误提示
    var error = '<%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>'

    if(error != null && error != '') {
        alert(error);
    }
</script>