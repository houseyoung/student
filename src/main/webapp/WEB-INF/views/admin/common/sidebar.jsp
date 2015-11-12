<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- <nav class="J_sidebar">     -->
<ul class="nav nav-pills sidebar pull-left" id="sidebar">
  <li class="J_menu-li">
    <a href="javascript:;">
      <i class="fa fa-hand-o-right"></i>
      <span>学生信息管理</span>
                <span class="angle pull-right">
                    <i class="fa fa-angle-right"></i>
                </span>
    </a>
    <ul class="sub-menu J_subMenu">
      <li>
        <a href="${website}admin/student_info"><span>基本信息管理</span></a>
      </li>
      <li>
        <a href="${website}admin/health"><span>健康状况信息管理</span></a>
      </li>
    </ul>
  </li>
  <li class="">
    <a href="${website}admin/course">
      <i class="fa fa-hand-o-right"></i>
      <span>课程信息管理</span>
    </a>
  </li>
  <li class="">
    <a href="${website}admin/score">
      <i class="fa fa-hand-o-right"></i>
      <span>成绩信息管理</span>
    </a>
  </li>
  <li class="J_menu-li">
    <a href="javascript:;">
      <i class="fa fa-hand-o-right"></i>
      <span>学院基本信息管理</span>
                <span class="angle pull-right">
                    <i class="fa fa-angle-right"></i>
                </span>
    </a>
    <ul class="sub-menu J_subMenu">
      <li>
        <a href="${website}admin/school"><span>学院信息管理</span></a>
      </li>
      <li>
        <a href="${website}admin/department"><span>系信息管理</span></a>
      </li>
      <li>
        <a href="${website}admin/class"><span>班级信息管理</span></a>
      </li>
    </ul>
  </li>
  <li class="J_menu-li">
    <a href="javascript:;">
      <i class="fa fa-hand-o-right"></i>
      <span>教职工信息管理</span>
                <span class="angle pull-right">
                    <i class="fa fa-angle-right"></i>
                </span>
    </a>
    <ul class="sub-menu J_subMenu">
      <li>
        <a href="${website}admin/admin_info"><span>管理员信息管理</span></a>
      </li>
      <li>
        <a href="${website}admin/instructor_info"><span>辅导员信息管理</span></a>
      </li>
    </ul>
  </li>
</ul>
<!-- </nav> -->
<script type="text/javascript">
  $(document).ready(function(){
    var
            el = {
              //一级菜单项
              level_1_menu: '.J_menu-li',
              //二级菜单列表
              subMenuEl: '.J_subMenu'
            },
            ACTIVE = 'active',
            LEVEL_1_MENU = $(el.level_1_menu).children('a'),
            subMenu = $(el.subMenuEl);

    //打开页面时，将子列表隐藏
    $(el.subMenuEl).hide();

    $.each(LEVEL_1_MENU,function(index,elem){
      $(this).on('click',function(){
        toggle(elem);
        return false;
      });
    });

    /*
     **点击一级菜单项时，切换显示子列表
     */
    function toggle(ev){
      var
              that = this,
              li = $(ev).parent('li')
              siblingLi = li.siblings('li'),
              siblingUl = siblingLi.children('ul'),
              subMenu = $(ev).next('ul'),
              subMenuLi = subMenu.children('li');

      if(!li.hasClass(ACTIVE)){
        li.addClass(ACTIVE);
        subMenu.show();
        subMenuLi.addClass(ACTIVE);
        siblingLi.removeClass(ACTIVE);
        siblingUl.hide();
      }else{
        li.removeClass(ACTIVE);
        subMenu.hide();
        subMenuLi.removeClass(ACTIVE);
      }
    }
  });

  $("#sidebar").css("min-height", ($(document).height()-72));
</script>