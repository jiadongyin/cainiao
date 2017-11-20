<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<%@ include file="/jsp/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>成员列表</title>
<!-- Bootstrap Core CSS -->
<link href="/xiaoyin/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/xiaoyin/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->  
<script src="/xiaoyin/js/jquery-2.0.3.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
<script src="/xiaoyin/js/bootstrap.min.js"></script> 
<script src="/xiaoyin/js/jquery.min.js"></script>
<script src="/xiaoyin/js/layer-v2.3/layer/layer.js"></script>
<!-- MetisMenu CSS -->
<link href="/xiaoyin/css/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="/xiaoyin/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/xiaoyin/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/xiaoyin/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="/xiaoyin/css/boot-crm.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
//复选框全选和全不选
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
	$("#selectAll").click(function(){
		$(":checkbox[name='ids']").prop("checked",this.checked);
	});
});

function deleteChecked(){
	var obj=document.getElementsByName('ids'); //选择所有name="'test'"的对象，返回数组 
	//取到对象数组后，我们来循环检测它是不是被选中 
	var s=''; 
	for(var i=1; i<obj.length; i++){ 
	if(obj[i].checked) s+=obj[i].value+','; //如果选中，将value添加到变量s中 
	} 
	//那么现在来检测s的值就知道选中的复选框的值了 
	//alert(s).val(); 
	if(confirm('确实要删除所选成员吗?')) {
		$.post("/xiaoyin/member/deleteChecked.action",{"Str":s},function(data){
			window.location.reload();
		});
	}
}

function editmember(id) {
	$.ajax({
		type:"get",
		url:"/xiaoyin/member/edit.action",
		data:{"id":id},
		success:function(data) {
		  //var member = JSON.parse(data);
			$("#edit_memId").val(data.memId);
			$("#edit_memberName").val(data.memName);
			$("#edit_memberSex").val(data.memSex);
			$("#edit_familyName").val(data.familyName)
			$("#edit_memMarry").val(data.memMarry)
			$("#edit_worh").val(data.worh)
			$("#edit_memPhone").val(data.memPhone);
			$("#edit_familyLocation").val(data.familyLocation);
			$("#edit_memAddress").val(data.memAddress);
			$("#edit_memChildren").val(data.memChildren);
			$("#edit_pic").val(data.pic);
		}
	});
}
	
function updatemember() {
	$.post("<%=basePath%>member/update.action",$("#edit_member_form").serialize(),function(data){
		alert("成员信息更新成功！");
		window.location.reload();
	});
}
	
<%-- function deletemember(id) { 
	if(confirm('确实要删除该成员吗?')) {
		$.post("<%=basePath%>member/delete.action",{"memId":id},function(data){
			alert("成员删除成功！");
			//window.location.reload();
		});
	}
} --%>
//删除行,页面不做跳转
function delRow(node){
	layer.confirm('确实要删除该成员吗?', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			var tr1 = node.parentNode.parentNode;  
	       // alert(tr1.rowIndex);  
	       // alert(tr1.cells[0].childNodes[0].value);   
	        var id = tr1.cells[0].childNodes[0].value;
			$.post("<%=basePath%>member/delete.action",{"memId":id},function(data){
				if(data == 'succ') {
					layer.alert('删除成功');
					tr1.style.display="none";
				}
				else {
					//$("#msgDiv").html(data);
					layer.open({
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['420px', '240px'], //宽高
						  content: data    //此处返回的data是一个流，是unauthorized.jsp页面
						});
				}
			}, 'html');
		}, function(){
			closeBtn: 0
		});
	
	/* if(confirm('确实要删除该成员吗?')) {
		
	} */
}

$(document).ready(function(){
	$.post("<%=basePath%>member/selectFamily.action",function(data){
		 $("#familyName option").remove();//避免重复添加
		 $("#familyName").append("<option value=''>---请选择---</option>");
		$.each(data,function(i,n){
		    // alert(n.family_name);
			//根据id查找对象，
           var obj = document.getElementById('familyName');
           //添加一个选项
          obj.options.add(new Option(n.family_name,n.family_name)); //这个兼容IE与firefox  
		})
		
		 $("#familyGrade option").remove();//避免重复添加
		 $("#familyGrade").append("<option value=''>---请选择---</option>");
		$.each(data,function(i,n){
		    // alert(n.family_name);
			//根据id查找对象，
           var obj = document.getElementById('familyGrade');
           //添加一个选项
          obj.options.add(new Option(n.family_grade,n.family_grade)); //这个兼容IE与firefox  
		})
	});
})

</script>
</head>
  
<body>
    <!-- 导航条 -->
	<jsp:include page="navbar.jsp" flush="true" />
		<!-- 侧边栏 -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="<%=basePath%>member/list.action" ><iclass="fa fa-edit fa-fw"></i> 成员管理</a></li>
					<li><a href="<%=basePath%>html/gallary1/gallary1.html"><iclass="fa fa-dashboard fa-fw"></i> 相册一</a></li>
					<li><a href="<%=basePath%>html/gallary2/gallary2.html"><iclass="fa fa-dashboard fa-fw"></i> 相册二</a></li>
					<li><a href="<%=basePath%>html/gallary4/gallary4.html"><iclass="fa fa-dashboard fa-fw"></i> 相册三</a></li>
					<li><a href="<%=basePath%>member/uploadDown.action"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a></li>
					<li><a href="<%=basePath%>member/sb.action"><iclass="fa fa-dashboard fa-fw"></i>上传相册</a></li>
					<li><a href="<%=basePath%>member/baiduMap.action"><iclass="fa fa-dashboard fa-fw"></i> 百度地图</a></li>
					<li><a href="/xiaoyin/OrgChart/tree.jsp"><iclass="fa fa-dashboard fa-fw"></i> 家族关系图</a></li>
				</ul>
			</div>
		</div>
	 </nav>
		<div id="msgDiv" style="">
		</div>
		<!-- 搜索栏 -->
		<div id="page-wrapper">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/member/list.action" method="get">
						<div class="form-group">
							<label for="memberName">成员名称</label> 
							<input type="text" class="form-control" id="memberName" value="${memName }" name="memName">
						</div>
						<div class="form-group">
							<label for="familyName">成员家庭</label> 
							<select	class="form-control" id="familyName" placeholder="成员家庭" name="familyName" >
					 		</select>
					 	</div>
					 	<div class="form-group">
						 	<label for="familyGrade">成员家庭级别</label> 
						 	<select	class="form-control" id="familyGrade"  name="familyGrade">
						 	</select>
						</div>
					 	<button type="submit" class="btn btn-primary">查询</button>
				 	</form>
				</div>
			</div>	

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">成员信息列表 
					 	<a href="javascript:" class="btn btn-primary " data-toggle="modal" data-target="#memberAddDialog" onclick="javascript:void(0)">新增成员</a>
						<table:importExcel url="/xiaoyin/member/importExcel.action"></table:importExcel><!-- 导入按钮 -->					 	
						<a href="javascript:" class="btn btn-danger " onclick="deleteChecked()">复选删除</a>&nbsp;
 						<table:exportExcel url="/xiaoyin/member/exportExcel.action"></table:exportExcel><!-- 导出按钮 -->					 				 	
 						<table:exportPDF url="/xiaoyin/member/exportpdf.action"></table:exportPDF><!-- 导出按钮 -->					 				 	
 						</div> 
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped" id="myTable">
							<thead>
								<tr>
									<th><input type="checkbox" id="selectAll" name="ids"></th>
						 			<th>ID</th>
						 			<th>名称</th>
									<th>性别</th>
									<th>成员家庭</th>
									<th>联系电话</th>
									<th>现居地</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.rows}" var="m">
							<form id="searchForm" modelAttribute="member" action="/xiaoyin/member/edit.action?id=${m.memId }" method="post">
									<tr>
										<td><input type="checkbox" name="ids" value="${m.memId}"></td>
										<td>${m.memId}</td>
										<td>${m.memName}</td>
										<td>${m.memSex}</td>
										<td>${m.familyName}</td>
										<td>${m.memPhone}</td>
										<td>${m.memAddress}</td>
										<td>
<!-- <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#memberEditDialog" onclick="editmember(${m.memId})">详细信息</a> -->
 		<button type="submit" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#memberEditDialog" >详细信息</button>		
		<input class="btn btn-danger btn-xs" type="button" name="getTableContent" value="删除" onclick="delRow(this)">
									    </td>
									</tr>
								</form>
								</c:forEach>
							</tbody>
						</table>
						<div class="col-md-12 text-right">
							<itcast:page url="${pageContext.request.contextPath }/member/list.action" />
						</div>
					<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	
	
	
	
	<!-- 新增成员 -->
	<div class="modal fade" id="memberAddDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">成员信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" action="/xiaoyin/member/add.action" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<label for="add_memberName" class="col-sm-2 control-label">成员名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memberName" placeholder="成员名称" name="memName">
							</div>
						</div>
						<div class="form-group">
							<label for="add_familyName" style="float:left;padding:7px 15px 0 27px;">成员家庭</label> 
							<div class="col-sm-10">
							 	<select	class="form-control" id=add_familyName placeholder="成员家庭" name="familyName"></select>
									<script type="text/javascript">
										$.post("<%=basePath%>member/selectFamily.action",function(data){
											 $("#add_familyName option").remove();//避免重复添加
											 $("#add_familyName").append("<option value=''>---请选择---</option>");
											$.each(data,function(i,n){
											    // alert(n.family_name);
												//根据id查找对象，
									           var obj = document.getElementById('add_familyName');
									           //添加一个选项
									          obj.options.add(new Option(n.family_name,n.family_name)); //这个兼容IE与firefox  
											})
										});
									</script>
							</div>
						</div>
						<div class="form-group">
							<label for="add_memSex" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memSex" placeholder="性别" name="memSex">
							</div>
						</div>
						<div class="form-group">
							<label for="add_memMarry" class="col-sm-2 control-label">婚否</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memMarry" placeholder="婚否" name="memMarry">
							</div>
						</div>
						<div class="form-group">
							<label for="add_worh" class="col-sm-2 control-label">配偶</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_worh" placeholder="配偶" name="worh">
							</div>
						</div>
						<div class="form-group">
							<label for="add_memChildren" class="col-sm-2 control-label">子女</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memChildren" placeholder="子女" name="memChildren">
							</div>
						</div>
						<div class="form-group">
							<label for="add_memPhone" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memPhone" placeholder="电话" name="memPhone">
							</div>
						</div>
						<div class="form-group">
							<label for="add_familyLocation" class="col-sm-2 control-label">家庭住址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_familyLocation" placeholder="家庭住址" name="familyLocation">
							</div>
						</div>
						<div class="form-group">
							<label for="add_memAddress" class="col-sm-2 control-label">现居地</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="add_memAddress" placeholder="现居地" name="memAddress">
							</div>
						</div>
						<div class="form-group">
							<label for="add_pic" class="col-sm-2 control-label">上传照片</label>
							<div class="col-sm-5">
								 <input id="file" type="file" class="file"  name="myfile" multiple=true>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary"  >确认</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
	
</body>
	
</html>
