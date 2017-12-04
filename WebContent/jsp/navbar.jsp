<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'sb.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>
  </head>
  
  <body>
  	<div id="wrapper">
		<!--描述：导航条 -->
			<div class="container-fluid">
				<nav class="navbar navbar-default">
				  <div class="container-fluid">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false" >
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/xiaoyin/index.html">首页<span class="sr-only">(current)</span></a>
					</div>
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				         <li><a href="/xiaoyin/member/list.action?familyName=奎武一家"><iclass="fa fa-edit fa-fw"></i>奎武一家</a></li>
				        <li><a href="/xiaoyin/member/list.action?familyName=俞博一家"><iclass="fa fa-edit fa-fw"></i>俞博一家</a></li>
				        <li><a href="/xiaoyin/member/list.action?familyName=佳怡一家"><iclass="fa fa-edit fa-fw"></i>佳怡一家</a></li>
				        <li><a href="/xiaoyin/member/list.action?familyName=东麻子一家"><iclass="fa fa-edit fa-fw"></i>东麻子一家</a></li>
				        <li><a href="/xiaoyin/member/list.action" ><iclass="fa fa-edit fa-fw"></i> 全部成员</a></li>
						<li><a href="/xiaoyin/static/html/gallary1/gallary1.html"><iclass="fa fa-dashboard fa-fw"></i> 相册一</a></li>
						<li><a href="/xiaoyin/static/html/gallary2/gallary2.html"><iclass="fa fa-dashboard fa-fw"></i> 相册二</a></li>
						<li><a href="/xiaoyin/static/html/gallary4/gallary4.html"><iclass="fa fa-dashboard fa-fw"></i> 相册三</a></li>
						<li><a href="/xiaoyin/member/uploadDown.action"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a></li>
						<li><a href="/xiaoyin/member/sb.action"><iclass="fa fa-dashboard fa-fw"></i>上传相册</a></li>
						<li><a href="/xiaoyin/member/baiduMap.action"><iclass="fa fa-dashboard fa-fw"></i> 百度地图</a></li>
						<li><a href="/xiaoyin/static/OrgChart/tree.jsp"><iclass="fa fa-dashboard fa-fw"></i> 家族关系图</a></li>
						<li><a href="/xiaoyin/jsp/demo.jsp"><iclass="fa fa-dashboard fa-fw"></i> layer-demo</a></li>
				        
				      </ul>
				      
				      <ul class="nav navbar-nav navbar-right">
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">你好：${currentUser} <span class="caret"></span></a>
				          <ul class="dropdown-menu">
				            <li><a href="/xiaoyin/jsp/modifyPass.jsp">修改密码</a></li>
				            <li><a href="/xiaoyin/user/logout.action">退出登录</a></li>
				            <li role="separator" class="divider"></li>
				            <li><a href="javascript:">help</a></li>
				          </ul>
				        </li>
				      </ul>
				    </div><!-- /.navbar-collapse -->
				 </div><!-- /.container-fluid -->
			</nav>
		   </div>  
  	
  </body>
</html>

