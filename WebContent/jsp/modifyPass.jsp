<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改密码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script src="/xiaoyin/js/jquery-2.0.3.min.js"></script>  
<link rel="stylesheet" type="text/css" href="/xiaoyin/css/login.css">
<style type="text/css">
body,td,th { font-family: "Source Sans Pro", sans-serif; }
body { background-color: #2B2B2B; }
</style>
</head>
  
 <div class="wrapper">

	<div class="container">
		<h1>修改密码</h1>
		<font color="red">${ msg }</font>
		<form class="form" action="/xiaoyin/user/login.action" method="post" >
			<input type="password" placeholder="原始密码" name="username">
			<input type="password" placeholder="新密码" name="password">
			<input type="password" placeholder="确认密码" name="password">
			<br>
			<button type="submit" id="login-button" style="background-color: #50a3a2;">确认修改</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li><font color="red">${ msg }</font></li>
		<li><img src="/xiaoyin/images/yjy02.jpg" style="width: 200px; height: 300px;"></li>
		<li><img src="/xiaoyin/images/yjy02.jpg" style="width: 200px; height: 300px;"></li>
		<li></li>
		<li>f</li>
		<li>gt</li>
		<li><font color="red">${ msg }</font></li>
		<li>4</li>
		<li>567</li>
		<li>${ msg }</li>
	</ul>
	
</div>

  </body>
</html>
