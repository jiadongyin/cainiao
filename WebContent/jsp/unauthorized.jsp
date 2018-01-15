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
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script language="javascript" type="text/javascript"> 
	var i = 3; 
	var intervalid; 
	intervalid = setInterval("fun()", 1000); 
	function fun() { 
		if (i == 0) { 
			window.location.href = "/xiaoyin/member/list.action"; 
			//layer.closeAll();
			clearInterval(intervalid); 
		} 
		document.getElementById("mes").innerHTML = i; 
		i--; 
	} 
</script> 

  </head>
  
  <body>
         <div align="center"><font color="red" size="10">你没有权限！！！</font></div> 
                 
         <div align="center"> 
			<p>将在 <span id="mes">3</span> 秒钟后关闭！</p> 
		</div>  
  </body>
</html>
