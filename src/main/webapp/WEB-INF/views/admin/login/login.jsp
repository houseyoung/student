<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>管理员登录</title>
		<%@ include file="../common/head.jsp"%>
		<link rel="stylesheet" href="${website}resources/css/admin/login/login.css" />
	</head>
	<body class="login-background">
		<div class="page container clearfix">
			<form method="post" action="${website}admin/login">
				<div class="row-fluid login-wrapper">  
					<h3 style="margin-bottom:40px;color:#fff;">学生资料管理系统</h3>	
			        <div class="span4 box">
			            <div class="content-wrap">
			                <h6>欢迎登录</h6>
			                <input class="span12" name="username" type="text" placeholder="请填写用户名" />
			                <input class="span12" name="password" type="password" placeholder="请填写登录密码" />
			                <a href="#" class="forgot">忘记密码?</a>
			                <div class="remember">
			                    <input id="remember-me" type="checkbox" style="margin-left:14px;" />
			                    <label for="remember-me">记住密码</label>
			                </div>
							<button class="btn-glow primary login" type="submit">登录</button>
			            </div>
			        </div>
		    	</div>
			</form>
		</div>
	</body>
</html>