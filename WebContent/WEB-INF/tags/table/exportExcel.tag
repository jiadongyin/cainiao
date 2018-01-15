<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/jsp/taglib.jsp"%>
<%@ attribute name="url" type="java.lang.String" required="true"%>
<script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>  
<script src="/xiaoyin/static/js/layer-v2.3/layer/layer.js"></script>
<%-- 使用方法： 1.将本tag写在查询的form之前；2.传入url --%>
<button id="btnExportExcel" class="btn btn-default" data-toggle="tooltip" data-placement="left" />导出EXCEL</button>
<script type="text/javascript">
$(document).ready(function() {

	$("#btnExportExcel").click(function(){
		top.layer.confirm('确认要导出Excel吗?', function(index){
		    alert("asss");
	    	//导出之前备份
	    	var url =  $("#searchForm").attr("action");
	    	var pageNo =  $("#pageNo").val();
	    	var pageSize = $("#pageSize").val();
	    	//导出excel
	        $("#searchForm").attr("action","${url}");
		    $("#pageNo").val(-1);
			$("#pageSize").val(-1);
			$("#searchForm").submit();

			//导出excel之后还原
			$("#searchForm").attr("action",url);
		    $("#pageNo").val(pageNo);
			$("#pageSize").val(pageSize);
		    top.layer.close(index);
		});
	});
    
});


</script>