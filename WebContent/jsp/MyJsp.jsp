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
<title>成员主页</title>
<meta name="keywords" content="侧边导航菜单(可分组折叠)">
<meta name="description" content="侧边导航菜单(可分组折叠)" />
<meta name="HandheldFriendly" content="True" />
<link rel="shortcut icon" href="img/favicon.ico">
<!-- Bootstrap3.3.5 CSS -->
<link href="/xiaoyin/static/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/xiaoyin/static/layui/css/layui.css"  media="all">
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
                            <h4 class="panel-title"> 奎武一家<span class="glyphicon glyphicon-chevron-down right"></span></h4>
                        </div>
                        <!-- .panel-collapse和.collapse标明折叠元素 .in表示要显示出来 -->
                        <div id="collapseListGroup1" class="panel-collapse collapse " role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                            <ul class="list-group">
                              <li class="list-group-item">
                                 <a href="/xiaoyin/member/selectPageWhere.action?familyName=奎武一家"><iclass="fa fa-edit fa-fw"></i>成员列表</a>
                              </li>
						     <li class="list-group-item">
						         <a href="/xiaoyin/member/sb.action?picPrefix=奎武一家"><iclass="fa fa-dashboard fa-fw"></i>相册</a>
						     </li>
                             <li  class="list-group-item">
                                 <a href="/xiaoyin/member/uploadDown.action?picPrefix=奎武一家"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a>
                             </li>
                             <li class="list-group-item">
                                 <a href="/xiaoyin/member/baiduMap.action?picPrefix=奎武一家"><iclass="fa fa-dashboard fa-fw"></i> 位置地图</a>
                             </li>
                            </ul>
                        </div>
                    </div><!--panel end-->
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading2" data-toggle="collapse" data-target="#collapseListGroup2" role="tab" >
                            <h4 class="panel-title"> 俞博一家<span class="glyphicon glyphicon-chevron-down right"></span></h4>
                        </div>
                        <div id="collapseListGroup2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading2">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <a href="/xiaoyin/member/selectPageWhere.action?familyName=俞博一家"><iclass="fa fa-edit fa-fw"></i>成员列表</a>
                              </li>
                               <li class="list-group-item">
						         <a href="/xiaoyin/member/sb.action?picPrefix=俞博一家"><iclass="fa fa-dashboard fa-fw"></i>相册</a>
						     </li>
                             <li  class="list-group-item">
                                 <a href="/xiaoyin/member/uploadDown.action?picPrefix=俞博一家"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a>
                             </li>
                             <li class="list-group-item">
                                 <a href="/xiaoyin/member/baiduMap.action?picPrefix=俞博一家"><iclass="fa fa-dashboard fa-fw"></i> 位置地图</a>
                             </li>
                            </ul>
                        </div>
                    </div>  
                    <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading3" data-toggle="collapse" data-target="#collapseListGroup3" role="tab" >
                            <h4 class="panel-title"> 佳怡一家 <span class="glyphicon glyphicon-chevron-down right"></span></h4>
                        </div>
                        <div id="collapseListGroup3" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading3">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <a href="/xiaoyin/member/selectPageWhere.action?familyName=佳怡一家"><iclass="fa fa-edit fa-fw"></i>成员列表</a>
                              </li>
                               <li class="list-group-item">
						         <a href="/xiaoyin/member/sb.action?picPrefix=佳怡一家"><iclass="fa fa-dashboard fa-fw"></i>相册</a>
						     </li>
                             <li  class="list-group-item">
                                 <a href="/xiaoyin/member/uploadDown.action?picPrefix=佳怡一家"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a>
                             </li>
                             <li class="list-group-item">
                                 <a href="/xiaoyin/member/baiduMap.action?picPrefix=佳怡一家"><iclass="fa fa-dashboard fa-fw"></i> 位置地图</a>
                             </li>
                            </ul>
                        </div>
                    </div> 
                    
                      <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading4" data-toggle="collapse" data-target="#collapseListGroup4" role="tab" >
                            <h4 class="panel-title">  东麻子一家<span class="glyphicon glyphicon-chevron-down right"></span> </h4>
                        </div>
                        <div id="collapseListGroup4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading4">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <a href="/xiaoyin/member/selectPageWhere.action?familyName=东麻子一家"><iclass="fa fa-edit fa-fw"></i>成员列表</a>
                              </li>
                             <li class="list-group-item">
						         <a href="/xiaoyin/member/sb.action?picPrefix=东麻子一家"><iclass="fa fa-dashboard fa-fw"></i>相册</a>
						     </li>
                             <li  class="list-group-item">
                                 <a href="/xiaoyin/member/uploadDown.action?picPrefix=东麻子一家"><iclass="fa fa-dashboard fa-fw"></i> 图片上传</a>
                             </li>
                             <li class="list-group-item">
                                 <a href="/xiaoyin/member/baiduMap.action?picPrefix=东麻子一家"><iclass="fa fa-dashboard fa-fw"></i> 位置地图</a>
                             </li>
                            </ul>
                        </div>
                    </div>   
                      <div class="panel panel-primary leftMenu">
                        <div class="panel-heading" id="collapseListGroupHeading5" data-toggle="collapse" data-target="#collapseListGroup5" role="tab" >
                            <h4 class="panel-title"> 静态相册 <span class="glyphicon glyphicon-chevron-down right"></span></h4>
                        </div>
                        <div id="collapseListGroup5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="collapseListGroupHeading5">
                            <ul class="list-group">
                              <li class="list-group-item">
                                <a href="/xiaoyin/static/html/gallary1/gallary1.html"><iclass="fa fa-dashboard fa-fw"></i> 相册一</a>
                              </li>
                              <li class="list-group-item">
                                <a href="/xiaoyin/static/html/gallary2/gallary2.html"><iclass="fa fa-dashboard fa-fw"></i> 相册二</a>
                              </li>
                              <li class="list-group-item">
                                <a href="/xiaoyin/static/html/gallary4/gallary4.html"><iclass="fa fa-dashboard fa-fw"></i> 相册三</a>
                              </li>
                            </ul>
                        </div>
                    </div>   
                </div>
            </div>
            <!-- 主体内容 -->
            <div class="col-md-10">
                  <div id="page-wrapper" style="margin-left: 0px;margin-right: 30px;">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading" >
									<label > 成员列表</label> 
								 	<a href="javascript:" class="btn btn-primary " data-toggle="modal" data-target="#memberAddDialog" onclick="editmember(-1)">新增成员</a>
									<table:importExcel url="/xiaoyin/member/importExcel.action"></table:importExcel><!-- 导入按钮 -->					 	
									<a href="javascript:" class="btn btn-danger " onclick="deleteChecked()">复选删除</a>
			 						<table:exportExcel url="/xiaoyin/member/exportExcel.action"></table:exportExcel><!-- 导出按钮 -->					 				 	
			 						<table:exportPDF url="/xiaoyin/member/exportpdf.action"></table:exportPDF><!-- 导出按钮 -->		
							        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 						<form id="searchForm" class="form-inline" style="width: 400px;float: right;"  action="${pageContext.request.contextPath }/member/selectPageWhere.action" method="post">
										<div class="form-group">
											<label for="memberName">成员名称</label> 
											<input type="text" style="width: 100px;" class="form-control" id="memberName"  name="memName">
										</div>
										<div class="form-group">
											<label for="familyName">成员家庭</label> 
											<select	class="form-control" id="familyName" placeholder="成员家庭" name="familyName" >
									 		</select>
									 	</div>
									 	<button type="submit" class="btn btn-primary">查询</button>
								 	</form>
		 						</div> 
								<!-- /.panel-heading -->
								<table class="table table-bordered table-striped" id="myTable">
									<thead>
										<tr >
											<th style="text-align:center;"><input type="checkbox" id="selectAll" name="ids" ></th>
								 			<th style="text-align:center;">ID</th>
								 			<th style="text-align:center;">名称</th>
											<th style="text-align:center;">性别</th>
											<th style="text-align:center;">婚否</th>
											<th style="text-align:center;">子女</th>
											<th style="text-align:center;">配偶</th>
											<th style="text-align:center;">联系电话</th>
											<th style="text-align:center;">现居地</th>
											<th style="text-align:center;">成员家庭</th>
											<th style="text-align:center;">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${page.rows}" var="m">
											<tr>
												<td align="center"><input type="checkbox" name="ids" value="${m.memId}"></td>
												<td>${m.memId}</td>
												<td>${m.memName}</td>
												<td>${m.memSex}</td>
												<td>${m.memMarry}</td>
												<td>${m.memChildren}</td>
												<td>${m.memWorh}</td>
												<td>${m.memPhone}</td>
												<td>${m.memAddress}</td>
												<td>${m.familyName}</td>
												<td>
		<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#memberAddDialog" onclick="editmember(${m.memId})">详细信息</a>
				<input class="btn btn-danger btn-xs" type="button" name="getTableContent" value="删除" onclick="delRow(this)">
											    </td>
											</tr>
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
						<form id="edit_form" class="form-horizontal" action="/xiaoyin/member/add.action" method="post" >
						<input type="hidden" id="edit_memId" name="memId"  />
						<input type="hidden" id="edit_familyId" name="familyId"  />
						<input type="hidden" id="edit_pcatId" name="pcatId"  />
						<input type="hidden" id="provinceName" name="provinceName"  />
						<input type="hidden" id="cityName" name="cityName"  />
						<input type="hidden" id="areaName" name="areaName"  />
						<input type="hidden" id="townName" name="townName"  />
						
						<div class="row">
							<div class=" col-md-6">
								<div class="form-group">
									<label for="edit_memberName" style="float:left;padding:7px 15px 0 27px;">成员名称</label>
									<div  class="col-sm-6">
										<input type="text" class="form-control" id="edit_memberName" placeholder="成员名称" name="memName">
									</div>
								</div>
								<div class="form-group">
									<label for="edit_familyName" style="float:left;padding:7px 15px 0 27px;">成员家庭</label> 
									<div  class="col-sm-6">
									 	<select	class="form-control" id=edit_familyName placeholder="成员家庭" name="familyName" style="cursor:pointer;"></select>
											<script type="text/javascript">
												$.post("<%=basePath%>member/selectFamily.action",function(data){
													 $("#edit_familyName option").remove();//避免重复添加
													 $("#edit_familyName").append("<option value=''>---请选择---</option>");
													// $("#edit_familyName option[value='佳怡一家']").attr("selected","selected");//根据值让option选中  
													$.each(data,function(i,n){
														//根据id查找对象，
											           var obj = document.getElementById('edit_familyName');
											           //添加一个选项
											          obj.options.add(new Option(n.familyName,n.familyName)); //这个兼容IE与firefox  
													})								
												});
											</script>
									</div>
								</div>
								<div class="form-group">
									<label for="edit_memSex" style="float:left;padding:7px 15px 0 55px;">性别</label>
									<div class="col-sm-6">
										<input style="cursor:pointer;"  type="radio" name="memSex" value="男" >男
      									<input style="cursor:pointer;"  type="radio" name="memSex" value="女" >女
      									
									</div>
								</div>
								<div class="form-group">
									<label for="edit_memMarry" style="float:left;padding:7px 15px 0 55px;">婚否</label>
									<div class="col-sm-6">
										<input style="cursor:pointer;"  type="radio" name="memMarry" value="已婚"  onclick="allow()">已婚
      									<input style="cursor:pointer;"  type="radio" name="memMarry" value="未婚"  onclick="forbiden()">未婚
									</div>
								</div>
								<div class="form-group">
									<label for="edit_memWorh" style="float:left;padding:7px 15px 0 55px;">配偶</label>
									<div class="col-sm-6">
										<input id="edit_memWorh" type="text" class="form-control" id="edit_memWorh" placeholder="配偶" name="memWorh">
									</div>
								</div>
							</div>
				<!-- 头像区域 -->
							<div class="col-md-6">
								<div class="" id="test10">
								   <img  src="/xiaoyin/static/img/photo.png"   style="width: 180px;height: 220px;cursor:pointer;">
	    						   <input type="hidden" id="file"  name="memPic"  >
								</div>
							</div>
						</div>		
							
								<div class="form-group">
									<label for="edit_memChildren" class="col-sm-2 control-label">子女</label>
									<div class="col-sm-10">
										<input id="edit_memChildren" type="text" class="form-control"  placeholder="子女" name="memChildren">
									</div>
								</div>
								<div class="form-group">
									<label for="edit_memPhone" class="col-sm-2 control-label">电话</label>
									<div class="col-sm-5">
										<input type="text" class="form-control" id="edit_memPhone" placeholder="电话" name="memPhone">
									</div>
								</div>
								<div id="demo3" class="form-inline form-group">
								<label for="edit_memAddress" style="float:left;padding:7px 30px 0 42px;">现居地</label>
							    <span onclick="ditu()" style="z-index: 1; position: absolute;right: 30px;top: 69%;margin-top: -8px;height: 20px;width: 28px;
							     background: #FFF url('/xiaoyin/static/img/timg.jpg') no-repeat  scroll 0px 0px;cursor: pointer;">地图</span>
					                <p>
					                    <select id="province" name="province" class="form-control" style="width: 100px;cursor:pointer;"></select>
					                    <select id="city" name="city" class="form-control" style="width: 100px;cursor:pointer;"></select>
					                    <select id="area" name="area" class="form-control" style="width: 100px;cursor:pointer;"></select>
					                    <select id="town" name="town" class="form-control" style="width: 100px;cursor:pointer;"></select>
					                </p>
					            </div>
								<div class="form-group">
									<label for="edit_familyLocation" class="col-sm-2 control-label">家庭住址</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="edit_familyLocation" placeholder="家庭住址" name="familyLocation">
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal" style="cursor:pointer;">关闭</button>
									<button type="submit" class="btn btn-primary" style="cursor:pointer;" >确认</button>
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
<script src="/xiaoyin/static/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">

var demo3provinceName = '';
var demo3cityName = '';
var demo3areaName = '';
var demo3townName = '';
var pro = '';//为了将提交时的编码转换成城市名称
var shi = '';
var qu = '';
var flag = false; //onChange 是否执行标识

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
	if(s == ''){
		layer.alert("请选择至少一条记录！");
		return false;
	}
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

function editmember(id) {
	$.ajax({
		type:"get",
		url:"/xiaoyin/member/edit.action",
		data:{"id":id},
		async:false,
		success:function(data) {
		  //var member = JSON.parse(data);
			$("#edit_memId").val(data.memId);
			$("#edit_memberName").val(data.memName);
			$(":radio[name='memSex'][value='" + data.memSex + "']").prop("checked", "checked");
			$("#edit_familyName").val(data.familyName);
			$(":radio[name='memMarry'][value='" + data.memMarry + "']").prop("checked", "checked");
			$("#edit_memWorh").val(data.memWorh);
			$("#edit_memPhone").val(data.memPhone);
			$("#edit_familyLocation").val(data.familyLocation);
			$("#edit_memAddress").val(data.memAddress);
			$("#edit_memChildren").val(data.memChildren);
			$("#edit_familyId").val(data.familyId);
			$("#edit_pcatId").val(data.pcatId);
			data.memPic != null?$('img').attr("src",/pic/+data.memPic):$('img').attr("src","/xiaoyin/static/img/photo.png");
			demo3provinceName = (data.provinceName == null?'':data.provinceName);
			demo3cityName = (data.cityName == null?'':data.cityName);
			demo3areaName = (data.areaName == null?'':data.areaName);
			demo3townName = (data.townName == null?'':data.townName);
			pcat(demo3provinceName,demo3cityName,demo3areaName,demo3townName,data.town);
		}
	});
	
	 var val=$('input:radio[name="memMarry"]:checked').val();
     if(val!=null){
    	if(val == "已婚"){
    		allow();
    	}
    	if(val == "未婚"){
    		forbiden();
    	}
     }  
} 
	
function updatemember() {
	$.post("<%=basePath%>member/update.action",$("#edit_member_form").serialize(),function(data){
		alert("成员信息更新成功！");
		window.location.reload();
	});
}
	
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
		     //alert(n.familyName);
			//根据id查找对象，
           var obj = document.getElementById('familyName');
           //添加一个选项
          obj.options.add(new Option(n.familyName,n.familyName)); //这个兼容IE与firefox  
		})
	});
})

//省市区三级联动
function pcat(demo3provinceName,demo3cityName,demo3areaName,demo3townName,townNum){
	$('#demo3').citys({
		province:demo3provinceName,//初始化省，市，县
		city:demo3cityName,
		area:demo3areaName,
		onChange:function(info){
			townFormat(info);
			var text = info['direct']?'(直辖市)':'';
	        var addStr = info['province']+text+','+info['city']+','+info['area'];
	        pro = info['province'];
	        shi = info['city'];
	        qu = info['area'];
	        flag = true;
		}
	},function(api){
		var info = api.getInfo();
		townFormat(info);
	});
	
	if(demo3townName == ''){
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
	}else{
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
						$("#town option[value='"+townNum+"']").attr("selected","selected");//根据值让option选中  
					}
				});
			}
		};
	}
}

	
//头像上传
layui.use('upload', function(){
 	  var $ = layui.jquery
 	  ,upload = layui.upload;
 	  //拖拽上传
 	  upload.render({
 	    elem: '#test10'
 	    ,url: '/xiaoyin/member/ajax_upload.action'
 	    ,done: function(res){
 	    	if(res.code == 200){
 		    	 $('img').attr("src",/pic/+res.src);
 		    	 $('#file').val(res.msg);
 		        return layer.msg("上传成功！");
 		      }
 	    }
 	  });
});
    
    
function forbiden(){
	$("input[type='text']").each(function () {
	　　$("#edit_memWorh").attr("disabled", "disabled");
	　　$("#edit_memChildren").attr("disabled", "disabled");
	});
}
function allow(){
	$("input[type='text']").each(function (){
　　//文本框启用
	$("#edit_memWorh").removeAttr("disabled");
	$("#edit_memChildren").removeAttr("disabled");
	});
}
    
$("#edit_form").submit(function() {
  	
  	$provinceName = $('#provinceName');
  	$cityName = $('#cityName');
  	$areaName = $('#areaName');
  	$townName = $('#townName');
	if(flag){
  	  $provinceName.val(pro);
  	  $cityName.val(shi);
  	  $areaName.val(qu);
  	}
	if(!flag){
  	  $provinceName.val(demo3provinceName);
  	  $cityName.val(demo3cityName);
  	  $areaName.val(demo3areaName);
  	}
  	  
 	  var area = $("#area").val(); 
 	  var townNum = $("#town").val(); 
 	  $.ajax({
		url:'/xiaoyin/static/town/'+area+'.json',
		dataType:'json',
		async:false,
		success:function(data){
			$townName.val(data[townNum]);
		}
	}); 
 })
    
function ditu(){
	var city = demo3provinceName+demo3cityName+demo3areaName+demo3townName
	window.location.href = "/xiaoyin/member/baiduMapAddress.action?city="+city;
}
   
</script>	
</body>
</html>