<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登陆页面</title>
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
		<h1>Welcome</h1>
		<font color="red">${ msg }</font>
		<form class="form" action="/xiaoyin/user/login.action" method="post" >
			<input type="text" placeholder="Username" name="user_name">
			<input type="password" placeholder="Password" name="password">
			<!-- 验证码 -->
			<tr>
			   <td nowrap width="437"></td>
			   <td><input type="text" placeholder="验证码" name="valicode"></td>
			    <td>
			        <img id="img" src="/xiaoyin/authImage" />
			        <a  onclick="changeImg()" style="color:white;"><label style="color:white;cursor:hand;">看不清？</label></a>
			    </td>
			 </tr><br>
			<button type="submit" id="login-button" style="background-color: #50a3a2;">Login</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li><font color="red" size="2">${ msg }</font></li>
		<li><img src="/xiaoyin/images/yjy02.jpg" style="width: 200px; height: 300px;"></li>
		<li><img src="/xiaoyin/images/奎02.jpg" style="width: 200px; height: 300px;"></li>
		<li><img src="/xiaoyin/images/cb001.jpg" style="width: 300px; height: 300px;"></li>
		<li><img src="/xiaoyin/images/cq01.jpg" style="width: 300px; height: 200px;"></li>
		<li><img src="/xiaoyin/images/yjy01.jpg" style="width: 300px; height: 300px;"></li>
		<li><font color="red" size="10">${ msg }</li>
	</ul>
	
</div>

<script type="text/javascript" src="/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript">
<!-- 触发JS刷新-->
   function changeImg(){
       var img = document.getElementById("img"); 
       img.src = "/xiaoyin/authImage?date=" + new Date();
   }
</script>
  </body>
</html>
