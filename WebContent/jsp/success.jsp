<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>系统提示</title> 
<script language="javascript" type="text/javascript"> 
	var i = 5; 
	var intervalid; 
	intervalid = setInterval("fun()", 1000); 
	function fun() { 
		if (i == 0) { 
			window.location.href = "/xiaoyin/index.html"; 
			clearInterval(intervalid); 
		} 
		document.getElementById("mes").innerHTML = i; 
		i--; 
	} 
</script> 
</head> 
<body> 
	<div> 
		<h3>操作成功！</h3> 
		<div> 
			<p>将在 <span id="mes">5</span> 秒钟后返回首页！</p> 
		</div> 
	
	</div> 
</body> 
</html>
