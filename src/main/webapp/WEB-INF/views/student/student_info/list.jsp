<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>个人信息列表</h4>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
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
													<td>${showHimself.className}</td>
													<td>${showHimself.departmentName}</td>
													<td>${showHimself.schoolName}</td>
													<td>${showHimself.birthday}</td>
													<td>${showHimself.hometown}</td>
													<td>${showHimself.interest}</td>
									    			<td>
									    				<a class="btn btn-primary btn-xs" href="#"><i class="fa fa-pencil"></i>&nbsp;修改兴趣</a>
									    			</td>
									    		</tr>
											</tbody>
										</table>
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