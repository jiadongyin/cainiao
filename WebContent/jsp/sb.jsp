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
    <script src="/xiaoyin/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript">
	function goBack(){
		window.history.back();
	}
	// 复选框全选和全不选
		$(function(){
			// 获得上面的复选框:
			//var $selectAll = $("#selectAll");
			// alert($selectAll.attr("checked"));
			/*$selectAll.click(function(){
				// alert($selectAll.prop("checked"));
				if($selectAll.prop("checked") == true){
					// 上面的复选框被选中
					$(":checkbox[name='ids']").prop("checked",true);
				}else{
					// 上面的复选框没有被选中
					$(":checkbox[name='ids']").prop("checked",false);
				}
			});*/
			
			// 简化：
			$("#ck").click(function(){
				$(":checkbox[name='ids']").prop("checked",this.checked);
			});
		});   
	</script>
  </head>
  
  <body>
    	大傻逼啊  ，，说了这个功能没写啊！！！！！！！！！！！！！！！！ <br>
    
   <dir>
    <a href="javaScript:void(0)" onclick="goBack()">返回</a>
   </dir>
	   <td>
	  		 <input type="checkbox" id="ck" name="ids">哈哈哈哈吼
	   </td>
   <td><input type="checkbox" name="ids"></td>
				<td>aaaaaaaaaaa</td>
		
		<div>
		 	

		</div>		
  </body>
  
</html>
