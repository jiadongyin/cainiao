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
	
<style type="text/css">
body,td,th { font-family: "Source Sans Pro", sans-serif; }
body { background-color: #2B2B2B; }
</style>
<link rel="stylesheet" type="text/css" href="/xiaoyin/static/css/login.css">
<script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>  
<script src="/xiaoyin/static/js/layer-v2.3/layer/layer.js"></script>
<script type="text/javascript">
	 
</script>
</head>
<body>
	 <div class="wrapper">
		<div class="container">
			<h1>修改密码</h1>
			<font color="red">${ msg }</font>
			<form class="form" action="/xiaoyin/user/modifyPass.action" method="post" >
				<input  type="password" placeholder="原始密码" name="oldPass" >
				<input  type="password" placeholder="新密码" name="newPass">
				<input  type="password" placeholder="确认密码" name="confirmPass">
				<br>
				<button type="submit" id="login-button" style="background-color: #50a3a2;">确认修改</button>
			</form>
		</div>
	</div>
 </body>
</html>
