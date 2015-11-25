<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
	<title>修改个人信息</title>
	<%@ include file="common/head.jsp" %>
	<link rel="stylesheet" href="${website}/resources/css/admin/student-info-management/student-info-management.css" />
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="page clearfix">
	<%@ include file="common/sidebar.jsp" %>
			<div class="holder">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a href="#"><i class="fa fa-home"></i>&nbsp;辅导员</a></li>
								<li class="active">修改个人信息</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>修改个人信息</h4>
								</div>
								<form id="defaultForm" class="form-horizontal" action="${website}instructor/edithimself" method="post" name="form" enctype="multipart/form-data">
									<div class="panel-body">
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">用户名</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="username" value="${showHimself.username}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">密码</label>
											</div>
											<div class="col-sm-3">
												<input type="password" class="form-control" name="password" value="">（留空则不修改）
											</div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">姓名</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="name" value="${showHimself.name}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">修改头像</label>
											</div>
											<div class="col-sm-3">
												<img src="${website}resources/upload/pic/instructor/${username}.png" onerror="javascript:this.src='${website}resources/img/common/empty.jpg'" width="80px" height="80px" style="margin-right:30px" /><button type="button" onclick="upload()" class="btn-primary btn"><i class="fa fa-save"></i>&nbsp;上传头像</button>
												<input type="file" name="file" />
											</div>
										</div>
									</div>
									<div class="row foot">
							      		<div class="col-sm-6 col-sm-offset-4">
							      			<div class="btn-toolbar">
								      			<button class="btn-primary btn save" type="submit"><i class="fa fa-save"></i>&nbsp;保存</button>
								      			<button class="btn-primary btn" type="reset"><i class="fa fa-undo"></i>&nbsp;重置</button>
							      			</div>
							      		</div>
							      	</div>
								</form>
							</div>
						</div>
					</div><!-- row -->
				</div><!-- container -->
			</div><!-- holder -->
		</div><!-- page -->
		<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
	$(document).ready(function() {
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
						name: {
							validators: {
								notEmpty: {
									message: '姓名不能为空'
								}
							}
						},
					}
				})
				.on('success.form.bv', function(e) {
					var $form = $(e.target);
					$form[0].submit();
				});
	});
</script>
<script type="text/javascript">
	function upload()
	{
		document.form.action="${website}uploadicon_instructor";
		document.form.submit();
	}
</script>
	</body>
</html>