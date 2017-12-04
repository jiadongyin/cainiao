<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>基于Masonry瀑布流的全屏预览图片画廊插件</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 新 Bootstrap 核心 CSS 文件 -->  
	    <link rel="stylesheet" href="/xiaoyin/static/css/bootstrap.min.css">  
	    <!-- 可选的Bootstrap主题文件（一般不用引入） -->  
	    <link rel="stylesheet" href="/xiaoyin/static/css/bootstrap-theme.min.css">  
	    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->  
	    <script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>  
	    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
	    <script src="/xiaoyin/static/js/bootstrap.min.js"></script> 
	    
	<link rel="stylesheet" href="/xiaoyin/static/html/uploadgallary/dist/stylesheets/chromagallery.min.css">
<style type="text/css">
		body,html
		{ height: 100%; background-color: #191919; 		}
		.content
		{
			width: 100%;
			height: 100%;
			margin: 10px auto;
		}
		@media screen and (min-width: 980px) /* Desktop */ {
		  .content {
		    width: 70%;
		  }
		}		
		.mygallery
		{
			margin: 25px 0;
		}
	</style>
	
  </head>
  
  <body>
  <div id="wrapper">
		<!-- 导航条 -->
	    <jsp:include page="navbar.jsp" flush="true" />
  
    <div class="jq22-container">
		<div class="content">
			<div class="chroma-gallery mygallery">
					<c:forEach items="${fileDemo}" var="fileDemo">
					    <img src="/pic/${fileDemo.fileName} " alt="" data-largesrc="/pic/${fileDemo.fileName}">
					</c:forEach>
			</div>
		</div>
	
	</div>
	
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="/xiaoyin/static/html/uploadgallary/dist/scripts/chromagallery.pkgd.min.js"></script>
	<script type="text/javascript">
		// $(document).ready(function() 
		// {
		//     $(".mygallery").chromaGallery();
		// });
		$(document).ready(function(){
			$(".mygallery").chromaGallery
		    ({
		        color:'#000',
		        gridMargin:15,
		        maxColumns:5,
		        dof:true,
		        screenOpacity:0.8
		    });
			
		});
		
	</script>
  </body>
</html>
