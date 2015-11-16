<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head>
		<title>班级信息管理</title>
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
								<li class="active">班级信息管理</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>班级信息列表</h4>
									<a class="btn btn-primary add" href="#"><i class="fa fa-plus"></i>&nbsp;添加</a>
								</div>
								<div class="panel-body">
									<form class="form-horizontal" action="" method="">
										<div class="form-group">
											<div class="col-sm-1 col-sm-offset-3">
												<label class="control-label">关键字</label>
											</div>
											<div class="col-sm-3">
												<input type="text" class="form-control" name="key" value="">
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
													<th>班级编号</th>
													<th>班级名称</th>
													<th>所属系</th>
													<th>所属学院</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="classDto" items="${listClass}">
												<tr>
													<td>${classDto.id}</td>
													<td>${classDto.className}</td>
													<td>${classDto.departmentName}</td>
													<td>${classDto.schoolName}</td>
													<td>
														<a class="btn btn-primary btn-xs" href="${website}instructor/class/edit?id=${classDto.id}"><i class="fa fa-pencil"></i>&nbsp;编辑</a>
													</td>
												</tr
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