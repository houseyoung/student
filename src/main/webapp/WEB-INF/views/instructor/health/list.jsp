<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>健康状况信息管理</title>
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
								<li><a href="#">学生信息管理</a></li>
								<li class="active">健康状况信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>学生健康信息列表</h4>
									<a class="btn btn-primary add" href="${website}instructor/health/insert"><i class="fa fa-plus"></i>&nbsp;添加</a>
								</div>
								<div class="panel-body">
									<form class="form-horizontal" action="${website}instructor/health" method="post">
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">关键字</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="keywords" value="">
										    </div>
											<div class="col-sm-1">
										    	<button class="btn btn-primary" type="submit"><i class="fa fa-search"></i>&nbsp;搜索</button>
										    </div>
										</div>
									</form>
									<div class="table-responsive">
										<table class="table table-hover table-bordered">
											<thead>
												<tr>
													<th>学号</th>
													<th>姓名</th>
													<th>身高</th>
													<th>体重</th>
													<th>营养状况</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="healthDto" items="${listHealth}">
												<tr>
													<td>${healthDto.studentId}</td>
													<td>${healthDto.studentName}</td>
													<td>${healthDto.height}</td>
													<td>${healthDto.weight}</td>
													<td>${healthDto.nutrition}</td>
													<td>
														<a class="btn btn-primary btn-xs" href="${website}instructor/health/edit?id=${healthDto.id}"><i class="fa fa-pencil"></i>&nbsp;编辑</a>
														<a class="btn btn-primary btn-xs J_del" href="${website}instructor/health/delete?id=${healthDto.id}"><i class="fa fa-times"></i>&nbsp;删除</a>
													</td>
												</tr>
											</c:forEach>
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