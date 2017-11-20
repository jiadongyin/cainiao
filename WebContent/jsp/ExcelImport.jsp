<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'ExcelImport.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="/xiaoyin/js/jquery-2.0.3.min.js"></script>  
<script src="/xiaoyin/js/layer-v2.3/layer/layer.js"></script>
<script type="text/javascript">
	function daoru(){
		top.layer.open({
		    type: 1, 
		    area: [500, 300],
		    title:"导入数据",
		    content:$("#importBox").html() , 
		      btn: ['确定', '关闭'],
			    btn1: function(index, layero){
		    	 layero.find('#importForm').submit();
			    top.layer.close(index);
			  },
		     btn2: function(index, layero){
			    top.layer.close(index);
			  }
		}); 
	}
	
</script>
  </head>
  <body>
  		<button onclick="daoru()">导入</button>	
		 <div id="importBox" class="hide" style="display:none;">
			<form id="importForm" action="/xiaoyin/member/importExcel.action" enctype="multipart/form-data" 
			method="post" style="padding-left:20px;text-align:center;" ><br/>
				<input id="uploadFile" name="myfile" type="file" style="width:530px;" />　
			</form>
		 </div>
  
  </body>
  
</html>
