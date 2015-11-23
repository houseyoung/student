<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>个人信息管理</title>
		<%@ include file="../common/head.jsp" %>
		<link rel="stylesheet" href="${website}/resources/css/teacher/student-info-management/student-info-management.css" />
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
								<li><a href="#"><i class="fa fa-home"></i>&nbsp;学生</a></li>
								<li class="active">个人信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div id="accordion" class="accordion-style1 panel-group">
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" href="#collapseOne">
													个人基础信息
												</a>
											</h4>
										</div>
										<div class="panel-collapse collapse in" id="collapseOne">
											<div class="panel-body">
												<table class="table table-hover table-bordered">
													<thead>
													<tr>
														<th>学号</th>
														<th>姓名</th>
														<th>性别</th>
														<th>所属班级</th>
														<th>所属系</th>
														<th>所属学院</th>
														<th>生日</th>
														<th>籍贯</th>
														<th>兴趣</th>
														<th>操作</th>
													</tr>
													</thead>
													<tbody>
													<tr data-student-id="${showHimself.studentId}">
														<td>${showHimself.studentId}</td>
														<td>${showHimself.studentName}</td>
														<td>${showHimself.sex}</td>
														<td>${showHimself.classesName}</td>
														<td>${showHimself.departmentName}</td>
														<td>${showHimself.schoolName}</td>
														<td>${showHimself.birthday}</td>
														<td>${showHimself.hometown}</td>
														<td>${showHimself.interest}</td>
														<td>
															<a class="btn btn-primary btn-xs" href="${website}student/student_info/editinterest"><i class="fa fa-pencil"></i>&nbsp;修改兴趣</a>
														</td>
													</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a class="accordion-toggle" data-toggle="collapse" href="#collapseTwo">
													健康状况信息
												</a>
											</h4>
										</div>
										<div class="panel-collapse collapse in" id="collapseTwo">
											<div class="panel-body">
												<table class="table table-hover table-bordered">
													<thead>
													<tr>
														<th>身高</th>
														<th>体重</th>
														<th>营养状况</th>
													</tr>
													</thead>
													<tbody>
													<c:forEach var="health" items="${listHimselfHealth}">
													<tr>
														<td>${health.height}</td>
														<td>${health.weight}</td>
														<td>${health.nutrition}</td>
													</tr>
													</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 面板结束 end-->
						</div>
					</div><!-- row -->
				</div><!-- container -->
			</div><!-- holder -->
		</div><!-- page -->
		<%@ include file="../common/footer.jsp" %>
		<script type="text/javascript" src="${website}/resources/tool/bootstrap/js/bootstrap.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('.J_del').click(function(){
					var 
						tr = $(this).parent().parent();

					tr.remove();
				});
			});
		</script>
	</body>
</html>