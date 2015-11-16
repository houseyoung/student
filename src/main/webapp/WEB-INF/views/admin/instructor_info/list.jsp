<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>教职工信息管理</title>
		<%@ include file="../common/head.jsp" %>
		<link rel="stylesheet" href="${website}resources/css/admin/student-info-management/student-info-management.css" />
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
								<li><a href="#">教职工信息管理</a></li>
								<li class="active">辅导员信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>辅导员列表</h4>
									<a class="btn btn-primary add" href="${website}admin/instructor_info/insert"><i class="fa fa-plus"></i>&nbsp;添加</a>
								</div>
								<div class="panel-body">
									<form class="form-horizontal" action="${website}admin/instructor_info" method="post">
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
													<th>辅导员编号</th>
													<th>用户名</th>
													<th>姓名</th>
													<th>所属班级</th>
													<th>所属系</th>
													<th>所属学院</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="instructor" items="${listInstructor}">
												<tr>
													<td>${instructor.id}</td>
													<td>${instructor.username}</td>
													<td>${instructor.name}</td>
													<td>${instructor.classesName}</td>
													<td>${instructor.departmentName}</td>
													<td>${instructor.schoolName}</td>
									    			<td>
									    				<a class="btn btn-primary btn-xs" href="${website}admin/instructor_info/edit?id=${instructor.id}"><i class="fa fa-pencil"></i>&nbsp;编辑</a>
									    				<a class="btn btn-primary btn-xs J_del" href="${website}admin/instructor_info/delete?id=${instructor.id}"><i class="fa fa-times"></i>&nbsp;删除</a>
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