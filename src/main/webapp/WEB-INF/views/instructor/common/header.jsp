<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-static-top admin-nav">
  	<a class="logo-text menu-list-logo" href="javascript:;"><i class="fa fa-book"></i>学生资料管理系统</a>
	<ul class="nav navbar-nav hello pull-right">
		<li class="J_headMenu">
	  		<a class="menu-list" href="javascript:;">你好，${username}！<img src="${website}resources/upload/pic/instructor/${username}.png" onerror="javascript:this.src='${website}resources/img/common/empty.jpg'" width="30px" height="30px" /><span class="caret"></span></a>
	  		<ul class="dropdown-menu arrow J_headSubMenu" aria-labelledby="dLabel">
		    	<li><a href="${website}instructor/edithimself"><i class="fa fa-user"></i>&nbsp;修改个人信息</a></li>
		    	<li class="divider"></li>
		    	<li><a href="${website}instructor/logoff"><i class="fa fa-sign-out"></i>&nbsp;退出登录</a></li>
		  	</ul>
	  	</li>
	</ul>
</nav>
<script type="text/javascript">
	$(document).ready(function(){
		var 
			el = {
				//菜单头
				menuEl: '.J_headMenu',
				//子菜单
				subMenuEl: '.J_headSubMenu'
			};

		$(el.menuEl).hover(
			function(){
				$(el.subMenuEl).css("display","block");
			},
			function(){
				$(el.subMenuEl).css("display","none");
			}
		);
	});
</script>