<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>管理员登录</title>
	<%@include file="../common/head.jsp"%>
	<link rel="stylesheet" href="${website}resources/css/admin/login/login.css" />
</head>
<body class="login-background">
<div class="page container clearfix">
	<div class="row">
		<div class="login-heading">
			<h3 class="text-center">学生资料管理系统</h3>
		</div>
	</div>
	<form method="post" action="${website}admin/login">
		<div class="row">
			<div class="login-body login-box">
				<div class="title">
					<h4 class="text-center margin-top-25 margin-bottom-30">欢迎管理员登录
					</h4>
				</div>
				<div class="form-group">
					<div class="input-group">
							<span class="input-group-addon">
								<span class="fa fa-user"></span>
							</span>
						<input class="form-control" type="text" name="username" value="">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
							<span class="input-group-addon">
								<span class="fa fa-lock"></span>
							</span>
						<input class="form-control" type="password" name="password" value="">
					</div>
				</div>
				<div class="checkbox pull-right margin-top-0 margin-bottom-15">
					<label>
						<input class="height-18" type="checkbox" name="remenber" value="0">
						记住我的登录信息
					</label>
				</div>
				<button class="btn btn-primary btn-block" type="submit">登录</button>
			</div>
		</div>
		<div class="row">
			<div class="login-footer clearfix">
				<div class="tip-info pull-left">
					<b>出现错误？</b>
					<p>请联系管理员</p>
				</div>
				<div class="pull-right">
					<button class="btn btn-default reset-btn" type="reset">重置
					</button>
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>