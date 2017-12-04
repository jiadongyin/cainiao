<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ attribute name="url" type="java.lang.String" required="true"%>
	<script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>  
<script src="/xiaoyin/static/js/layer-v2.3/layer/layer.js"></script>
<%-- 使用方法： 1.将本tag写在查询的form之前；2.传入controller的url --%>
<button id="btnImport" class="btn btn-default" data-toggle="tooltip" data-placement="left" >导入Excel</button>

<div id="importBox" class="hide">
	<form id="importForm" action="${url}" enctype="multipart/form-data" method="post" style="padding-left:20px;text-align:center;" ><br/>
		<input id="myfile" name="myfile" type="file" style="width:530px;" multiple=true/>　　
		<span style="font-color:red;color: red;" >（导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！）</span>
      </form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnImport").click(function(){
		top.layer.open({
		    type: 1, 
		    area: [500, 300],
		    title:"导入数据",
		    content:$("#importBox").html() , 
		      btn: ['下载模板','确定', '关闭'],
			    btn1: function(index, layero){
				window.location.href='/xiaoyin/member/exportExcel.action';
			  },
		      btn2: function(index, layero){
		    		layero.find('#importForm').submit();
				    top.layer.close(index);
			  },  
		    btn3: function(index){ 
			    top.layer.close(index);
   	        }  
		}); 
	});
    
});

</script>