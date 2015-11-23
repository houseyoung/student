<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- <nav class="J_sidebar">     -->
<ul class="nav nav-pills sidebar pull-left" id="sidebar">
    <li class="">
        <a href="${website}student/student_info">
            <i class="fa fa-hand-o-right"></i>
            <span>个人信息管理</span>
        </a>
    </li>
    <li class="">
        <a href="${website}student/student_info/score">
            <i class="fa fa-hand-o-right"></i>
            <span>查看成绩信息</span>
        </a>
    </li>
    <li class="">
            <a href="${website}student/student_info/course">
                <i class="fa fa-hand-o-right"></i> 
                <span>查看课程信息</span>
            </a>
        </li>
    </ul>
<!-- </nav> -->
<script type="text/javascript">
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

    $("#sidebar").css("min-height", ($(document).height()-72));
</script>