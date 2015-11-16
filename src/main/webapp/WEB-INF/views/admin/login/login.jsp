<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<title>管理员/辅导员登录</title>
		<%@ include file="../common/head.jsp"%>
		<link rel="stylesheet" href="${website}resources/css/admin/login/login.css" />
	</head>
	<body class="login-background">
		<div class="page container clearfix">
			<form id="defaultForm" method="post" action="${website}admin/login">
				<div class="row-fluid login-wrapper">  
					<h3 style="margin-bottom:40px;color:#fff;">学生资料管理系统</h3>	
			        <div class="span4 box">
			            <div class="content-wrap">
			                <h6>欢迎登录</h6>
							<div class="form-group">
								<input type="text" class="span12 form-control" placeholder="请输入用户名" name="username" value="">
							</div>
							<div class="form-group">
								<input type="password" class="span12 form-control" placeholder="请输入登录密码" name="password" value="">
							</div>
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
		<script type="text/javascript">
			$(document).ready(function(){
				$('#defaultForm')
						.bootstrapValidator({
							feedbackIcons: {
								valid: 'glyphicon glyphicon-ok',
								invalid: 'glyphicon glyphicon-remove',
								validating: 'glyphicon glyphicon-refresh'
							},
							fields: {
								username: {
									validators: {
										notEmpty: {
											message: '用户名不能为空'
										}
									}
								},
								password: {
									validators: {
										notEmpty: {
											message: '密码不能为空'
										},
										stringLength: {
											min: 5,
											max: 20,
											message: '密码长度为5~20个字符'
										}
									}
								}
							}
						})
						.on('success.form.bv', function(e) {
							var $form = $(e.target);
							$form[0].submit();
						});
			});
		</script>
	</body>
</html>