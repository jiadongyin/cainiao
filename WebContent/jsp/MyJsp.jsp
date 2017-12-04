<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<%@ include file="/jsp/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>表格</title>
        <meta name="keywords" content="侧边导航菜单(可分组折叠)">
        <meta name="description" content="侧边导航菜单(可分组折叠)" />
        <meta name="HandheldFriendly" content="True" />
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Bootstrap3.3.5 CSS -->
        <link href="/xiaoyin/static/css/bootstrap.min.css" rel="stylesheet">

        <style>
            .panel-group{max-height:770px;overflow: auto;}
            .leftMenu{margin:10px;margin-top:5px;}
            .leftMenu .panel-heading{font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
            .leftMenu .panel-heading span{position:absolute;right:10px;top:12px;}
            .leftMenu .menu-item-left{padding: 2px; background: transparent; border:1px solid transparent;border-radius: 6px;}
            .leftMenu .menu-item-left:hover{background:#C4E3F3;border:1px solid #1E90FF;}
        </style>
    </head>

    <body>
     <!-- 导航条 -->
	<jsp:include page="navbar.jsp" flush="true" />
        <div class="row">
            <div class="col-md-2">
                <div class="panel-group table-responsive" role="tablist">
                    <div class="panel panel-primary leftMenu">
                        <!-- 利用data-target指定要折叠的分组列表 -->
                        <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab" >
                            <h4 class="panel-title">
                                                                                     分组1
                                <span class="glyphicon glyphicon-chevron-up right"></span>
                            </h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <!-- 利用data-target指定URL -->
                                <button class="menu-item-left" data-target="test2.html">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项1-1
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项1-2
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项1-3
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项1-4
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div><!--panel end-->
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title">
                                                                                    分组2
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项2-1
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项2-2
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项2-3
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项2-4
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>  
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                            <h4 class="panel-title">
                                                                                    分组3
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项3-1
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项3-2
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项3-3
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项3-4
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div> 
                    
                      <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
                            <h4 class="panel-title">
                                                                                    分组4
                                <span class="glyphicon glyphicon-chevron-down right"></span>
                            </h4>
                        </div>
                        <div id="collapseListGroup4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading4">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项4-1
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项4-2
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项4-3
                                </button>
                              </li>
                              <li class="list-group-item">
                                <button class="menu-item-left">
                                    <span class="glyphicon glyphicon-triangle-right"></span>分组项4-4
                                </button>
                              </li>
                            </ul>
                        </div>
                    </div>   
                </div>
            </div>
            <!-- 主体内容 -->
            <div class="col-md-10">
                  <div id="page-wrapper" style="margin-left: 0px;margin-right: 30px;">
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
											<th align="center"><input type="checkbox" id="selectAll" name="ids"></th>
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
												<td align="center"><input type="checkbox" name="ids" value="${m.memId}"></td>
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
            </div>
            <!-- 新增成员 -->
			<div class="modal fade" id="memberAddDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
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
							
						<div class="row">
							<div class=" col-md-8">
								<div class="form-group">
									<label for="add_memberName" style="float:left;padding:7px 15px 0 27px;">成员名称</label>
									<div  class="col-sm-5">
										<input type="text" class="form-control" id="add_memberName" placeholder="成员名称" name="memName">
									</div>
								</div>
								<div class="form-group">
									<label for="add_familyName" style="float:left;padding:7px 15px 0 27px;">成员家庭</label> 
									<div  class="col-sm-5">
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
									<label for="add_memSex" style="float:left;padding:7px 15px 0 55px;">性别</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="add_memSex" placeholder="性别" name="memSex">
									</div>
								</div>
								<div class="form-group">
									<label for="add_memMarry" style="float:left;padding:7px 15px 0 55px;">婚否</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="add_memMarry" placeholder="婚否" name="memMarry">
									</div>
								</div>
								<div class="form-group">
									<label for="add_worh" style="float:left;padding:7px 15px 0 55px;">配偶</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="add_worh" placeholder="配偶" name="worh">
									</div>
								</div>
							</div>
							<div class="col-md-4">.col-md-6</div>
						</div>		
								
								<div class="form-group">
									<label for="add_memChildren" class="col-sm-2 control-label">子女</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="add_memChildren" placeholder="子女" name="memChildren">
									</div>
								</div>
								<div class="form-group">
									<label for="add_memPhone" class="col-sm-2 control-label">电话</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="add_memPhone" placeholder="电话" name="memPhone">
									</div>
								</div>
								
								<div id="demo3" class="form-inline">
								<label for="add_familyLocation" style="float:left;padding:7px 15px 0 27px;">家庭住址</label>
					                <p>
					                    <select name="province" class="form-control" style="width: 100px;"></select>
					                    <select name="city" class="form-control" style="width: 100px;"></select>
					                    <select name="area" class="form-control" style="width: 100px;"></select>
					                    <select name="town" class="form-control" style="width: 100px;"></select>
					                </p>
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
			</div> <!-- 主体结束 -->      
			      
        </div>
        
<script src="/xiaoyin/static/js/jquery-2.0.3.min.js "></script>
<script src="/xiaoyin/static/js/bootstrap.min.js "></script>
<script src="/xiaoyin/static/js/layer-v2.3/layer/layer.js"></script> 
<script type="text/javascript" src="/xiaoyin/static/js/jquery.citys.js"></script>
<script type="text/javascript">
//侧边导航栏
$(function(){
    $(".panel-heading").click(function(e){
        /*切换折叠指示图标*/
        $(this).find("span").toggleClass("glyphicon-chevron-down");
        $(this).find("span").toggleClass("glyphicon-chevron-up");
    });
});

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
	layer.confirm('确实要删除所选成员吗?', {
		  btn: ['确定','取消'] //按钮
		}, function(){
			$.post("/xiaoyin/member/deleteChecked.action",{"Str":s},function(data){
				if(data == "OK"){
					window.location.reload();
				}else {
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
}

/* function editmember(id) {
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
} */
	
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

//省市区三级联动
var $town = $('#demo3 select[name="town"]');
var townFormat = function(info){
	$town.hide().empty();
	if(info['code']%1e4&&info['code']<7e5){	//是否为“区”且不是港澳台地区
		$.ajax({
			url:'/xiaoyin/static/town/'+info['code']+'.json',
			dataType:'json',
			success:function(town){
				$town.show();
				for(i in town){
						$town.append('<option value="'+i+'">'+town[i]+'</option>');
				}
			}
		});
	}
};
    $('#demo3').citys({
		province:'福建',
		city:'厦门',
		area:'思明',
		onChange:function(info){
			townFormat(info);
		}
	},function(api){
		var info = api.getInfo();
		townFormat(info);
	});
			           

</script>	
</body>
</html>