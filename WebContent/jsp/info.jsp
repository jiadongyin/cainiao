<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
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
<title>个人信息</title>
<!-- Bootstrap Core CSS -->
<link href="/xiaoyin/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/xiaoyin/css/bootstrap-theme.min.css">  
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->  
<script src="/xiaoyin/js/jquery-2.0.3.min.js"></script>  
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
<script src="/xiaoyin/js/bootstrap.min.js"></script> 
<script src="/xiaoyin/js/jquery.min.js"></script>
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

</script>

  </head>
  
  <body style="background-image:  url(/xiaoyin/images/bgp.jpg);width: 100%;" >
    
    <!-- 客户编辑对话框 -->
		<div class="modal-dialog" role="document" style="position: 200px;background:rgba(0,0,0,0.3);">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_member_form" action="/xiaoyin/member/update.action" method="post" enctype="multipart/form-data">
						<input type="hidden" id="edit_memId" name="memId" value="${member.memId }" />
						<input type="hidden" id="edit_pic" name="pic" value="${member.pic }" />
						
						<div class="form-group">
							<label for="edit_memberName" class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="edit_memberName" placeholder="成员名称" name="memName" value="${member.memName }">
							</div>
							<label for="edit_memberSex" class="col-sm-2 control-label">性别</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="edit_memberSex" placeholder="性别" name="memSex" value="${member.memSex }">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_memMarry" class="col-sm-2 control-label">婚否</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="edit_memMarry" placeholder="婚否" name="memMarry" value="${ member.memMarry}">
							</div>
							<label for="edit_worh" class="col-sm-2 control-label">配偶</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="edit_worh" placeholder="配偶" name="worh" value="${member.worh }">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_memPhone" class="col-sm-2 control-label">电话</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="edit_memPhone" placeholder="电话" name="memPhone" value="${member.memPhone}">
							</div>
							<label for="edit_familyName" style="float:left;padding:7px 15px 0 27px;">成员家庭</label> 
							<div class="col-sm-3">
								<input type="text" class="form-control" id="edit_familyName" placeholder="成员家庭" name="familyName" value="${member.familyName}" disabled="disabled">
							</div>
						</div>
						
						<div class="form-group">
							<label for="edit_memChildren" class="col-sm-2 control-label">子女</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_memChildren" placeholder="子女" name="memChildren" value="${member.memChildren }">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_familyLocation" class="col-sm-2 control-label">家庭住址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_familyLocation" placeholder="家庭住址" name="familyLocation" value="${member.familyLocation}">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_memAddress" class="col-sm-2 control-label">现居地</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_memAddress" placeholder="现居地" name="memAddress" value="${member.memAddress}">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_pic" class="col-sm-2 control-label">照片</label>
							<div class="col-sm-5">
								<img  src="/pic/${picName }" width="270" height="335" alt="图片" />
								<label for="edit_pic" class="col-sm-5 control-label">更换照片</label>
								<div class="col-sm-5">
									 <input id="file" type="file" class="file"  name="myfile" multiple=true>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" onclick="back()">返回</button>
							<button type="submit" class="btn btn-primary"  >确认</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		function back(){
			window.history.back();
		}
	</script>
	
  </body>
</html>
