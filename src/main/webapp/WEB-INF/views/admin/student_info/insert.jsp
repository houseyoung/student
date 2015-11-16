<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>学生信息管理</title>
		<%@ include file="../common/head.jsp" %>
		<link rel="stylesheet" href="${website}/resources/css/admin/student-info-management/student-info-management.css" />
	</head>
	<body>
		<%@ include file="../common/header.jsp" %>
		<div class="page clearfix">
			<%@ include file="../common/sidebar.jsp" %>
			<div class="holder">
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a href="#"><i class="fa fa-home"></i>&nbsp;管理员</a></li>
								<li><a href="#">学生信息管理</a></li>
								<li class="active">学生基本信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>添加学生</h4>
								</div>
								<form id="defaultForm" class="form-horizontal" action="${website}admin/student_info/insert" method="post">
									<div class="panel-body">
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">学号</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="studentId" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">姓名</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="studentName" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">性别</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="sex" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">所属班级</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="classesName" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">所属系</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="departmentName" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">所属学院</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="schoolName" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">生日</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="birthday" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">籍贯</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="hometown" value="">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">兴趣</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="interest" value="">
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
		<%@ include file="../common/footer.jsp" %>
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
								studentId: {
									validators: {
										notEmpty: {
											message: '学号不能为空'
										}
									}
								},
								studentName: {
									validators: {
										notEmpty: {
											message: '姓名不能为空'
										}
									}
								},
								sex: {
									validators: {
										notEmpty: {
											message: '性别不能为空'
										}
									}
								},
								classesName: {
									validators: {
										notEmpty: {
											message: '所属班级不能为空'
										}
									}
								},
								departmentName: {
									validators: {
										notEmpty: {
											message: '所属系不能为空'
										}
									}
								},
								schoolName: {
									validators: {
										notEmpty: {
											message: '所属学院不能为空'
										}
									}
								},
								birthday: {
									validators: {
										notEmpty: {
											message: '生日不能为空'
										}
									}
								},
								hometown: {
									validators: {
										notEmpty: {
											message: '籍贯不能为空'
										}
									}
								},
								interest: {
									validators: {
										notEmpty: {
											message: '兴趣不能为空'
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