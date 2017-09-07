<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/public/metronic.jsp" %>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'metronicTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 开始引入页面css -->	
<link href="<%=basePath%>resources/plugin/metronic/assets/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>resources/plugin/metronic/assets/admin/layout3/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="<%=basePath%>resources/plugin/metronic/assets/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">
 <!-- 结束页面css引入 -->
  </head>
  
  <body>
  <!-- BEGIN HEADER -->
   <div class="page-header">
       <!--开始 页面头 top -->
       <div class="page-header-top">
            <div class="container">
                  <!--开始 LOGO  -->
                  <div class="pgee-logo">
                       <a href="/index.jsp"><img src="<%=basePath%>resources/plugin/metronic/assets/admin/layout3/img/logo-default.png" alt="logo" class="logo-default"></a>
                  </div>
                  <a href="javascript:;" class="menu-toggler"></a>
                  <!-- 结束 LOGO -->
                  <!-- todo -->
            </div>
       </div>
       <!-- 结束页面头 top -->
       <!-- 开始页面菜单 menu -->
       <div class="page-header-menu">
            <div class="container">
                 <!-- 开始 头部 搜索框 -->
                 <form class="search-form" action="#" method="GET">
                       <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search" name="query">
                            <span class="input-group-btn">
                            <a href="javascript:;" class="btn submit">
                               <i class="icon-magnifier"></i>
                            </a>
                            </span>
                       </div>
                 </form>
                 <!-- 结束 头部 搜索框 -->
                 <!-- 开始 MEGA 菜单栏 -->
                 <!-- DOC: Apply "hor-menu-light" class after the "hor-menu" class below to have a horizontal menu with white background -->
			     <!-- DOC: Remove data-hover="dropdown" and data-close-others="true" attributes below to disable the dropdown opening on mouse hover -->
                 <div class="hor-menu">
                      <ul class="nav navbar-nav">
                          <li class="active">
                              <a href="#">Dashboard</a>
                          </li>
                          <li class="menu-dropdown mega-menu-dropdown">
                              <a data-hover="dropdown" data-close-others="true" data-toggle="dropdown"
                              href="javascript:;" class="dropdown-toggle">Features<i class="fa fa-angle-down"></i>
                              </a>
                              <ul class="dropdown-menu" style="min-width:710px">
                                  <li>
                                      <div class="mega-menu-content">
                                           <div class="row">
                                                <div class="col-md-4">
                                                     <ul class="mega-menu-submenu">
                                                         <li>
                                                             <h3>eCommice</h3>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                             <i class="icon-home"></i>
                                                              first
                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="icon-home"></li>
                                                              second                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              third                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              four                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              five                                                              </a>
                                                         </li>
                                                     </ul>
                                                </div>
                                                <div class="col-md-4">
                                                                                                    
                                                     <ul class="mega-menu-submenu">
                                                         <li>
                                                             <h3>eCommice</h3>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                             <i class="icon-home"></i>
                                                              first
                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="icon-home"></li>
                                                              second                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              third                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              four                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              five                                                              </a>
                                                         </li>
                                                     </ul>
                                                </div>
                                                <div class="col-md-4">
                                                     <ul class="mega-menu-submenu">
                                                         <li>
                                                             <h3>eCommice</h3>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                             <i class="icon-home"></i>
                                                              first
                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="icon-home"></li>
                                                              second                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              third                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              four                                                              </a>
                                                         </li>
                                                         <li>
                                                              <a href="#" class="iconify>
                                                              <i class="home"></li>
                                                              five                                                              </a>
                                                         </li>
                                                     </ul>
                                                </div>
                                                
                                           </div>
                                      </div>
                                  </li>
                              </ul>
                          </li>
                          <li class="menu-dropdown mega-menu-dropdown mega-menu-full">
                          </li>
                          <li class="menu-dropdown classic-menu-dropdown">
                              <a data-hover="dropdown" data-close-other="true"
                              data-toggle="dropdown" href="javascrip:;">
                              Extra<i class="fa fa-angle-down"></i>
                              </a>
                              <ul class="dropdown-menu pull-left">
                                  <li class=" dropdown-submenu">
                                      <a href=":;">
                                      <i class="icon-briefcase"></i>
                                      DataTables</a>
                                      <ul class="dropdown-menu">
                                      <li class=" dropdown-submenu">
                                          <a href=":;">
                                          <i class="icon-briefcase"></i>
                                          Baseic Datatables</a>
                                          <ul class="dropdown-menu">
                                              <li class="">
                                              <a href="#">Test</a>
                                              </li>
                                              <li class="">
                                              <a href="#">Test</a>
                                              </li>
                                              <li class="">
                                              <a href="#">Test</a>
                                              </li>
                                              <li class="">
                                              <a href="#">Test</a>
                                              </li>
                                          </ul>
                                      </li>
                                      <li class=" ">
                                          <a href="#">Baseic Datatables</a>
                                      </li>
                                      <li class=" ">
                                          <a href="#">Baseic Datatables</a>
                                      </li>
                                      <li class=" ">
                                          <a href="#">Baseic Datatables</a>
                                      </li>
                                      </ul>
                                  </li>
                                  <li class="dorpdown-submenu">
                                  </li>
                                  <li class="dorpdown-submenu">
                                  </li>
                                  <li class="dorpdown-submenu">
                                  </li>
                                  <li class="dorpdown-submenu">
                                  </li>
                              </ul>
                          </li>
                          <li class="menu-dropdown mega-menu-dropdown mega-menu-full">
                          </li>
                          <li class="menu-dropdown">
                          </li>
                      </ul>
                 </div>
                 <!-- 结束 MEGA 菜单栏-->
            </div>
       </div>
       <!-- 结束页面菜单 menu -->
   </div>
  <!-- END HEADER --> 
  <!-- BEGIN PAGE CONTAINER -->
  <div class="page-container">
  </div>
  <!-- END PGE CONTAINER -->
  <!-- BEGIN PRE-FOOTER -->
  <div class="page-prefooter">
  </div>
  <!-- END PRE-FOOTER -->
  <!-- BEGAIN FOOTER -->
  <div class="pgee-footer">
  </div>
  <div class="scroll-to-top">
     <i class="icon-arrow-up"></i>
  </div>
   <!-- END FOOTER -->
  </body>
</html>
