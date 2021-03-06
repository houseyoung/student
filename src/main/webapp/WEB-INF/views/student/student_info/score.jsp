<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
	<title>查看成绩信息</title>
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
								<li><a href="#"><i class="fa fa-home"></i>&nbsp;学生</a></li>
								<li class="active">查看成绩信息</li>
							</ol>
						</div>
						<div class="col-sm-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4>成绩信息列表</h4>
								</div>
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-hover table-bordered">
											<thead>
												<tr>
													<th>成绩编号</th>
													<th>课程名称</th>
													<th>成绩</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="score" items="${listHimself}">
												<tr>
													<td>${score.courseId}</td>
													<td>${score.courseName}</td>
													<td>${score.score}</td>
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