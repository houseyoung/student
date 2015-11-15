<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>课程信息管理</title>
		<%@ include file="../common/head.jsp" %>
		<link rel="stylesheet" href="${website}resources/css/teacher/student-info-management/student-info-management.css" />
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
								<li><a href="#"><i class="fa fa-home"></i>&nbsp;辅导员</a></li>
								<li class="active">课程信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>编辑课程信息</h4>
								</div>
								<form id="defaultForm" class="form-horizontal" action="${website}instructor/course/edit?id=${course.id}" method="post">
									<div class="panel-body">
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">课程名称</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="name" value="${course.name}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">课时</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="courseHour" value="${course.courseHour}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">学分</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="credit" value="${course.credit}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">授课教师</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="teacherName" value="${course.teacherName}">
										    </div>
										</div>
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">授课地点</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="place" value="${course.place}">
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
							name: {
								validators: {
									notEmpty: {
										message: '课程名称不能为空'
									}
								}
							},
							courseHour: {
								validators: {
									notEmpty: {
										message: '课时不能为空'
									}
								}
							},
							credit: {
								validators: {
									notEmpty: {
										message: '学分不能为空'
									}
								}
							},
							teacherName: {
								validators: {
									notEmpty: {
										message: '授课教师不能为空'
									}
								}
							},
							place: {
								validators: {
									notEmpty: {
										message: '授课地点不能为空'
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
	</body>
</html>