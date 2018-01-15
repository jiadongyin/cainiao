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
        <title>图片上传</title>
        <link href="/xiaoyin/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="/xiaoyin/static/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>
        <script src="/xiaoyin/static/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
    <!-- 顶部 -->
		  <div class="col-md-12">
			<!-- 导航条 -->
	        <jsp:include page="navbar.jsp" flush="true" />
		 <!--顶部结束  --> 
		
		 <!-- 图片上传部分 -->
        <div class="container kv-main">
            <div class="page-header">
            <h3 class="text-success">图片上传</h2>
            </div>
            <form  action="<%=basePath%>member/upload.action?picPrefix=${picPrefix}" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <input id="file-4" type="file" class="file" data-upload-url="#" name="myfile" multiple=true>
                </div>
                <div class="form-group">
                    <button class="btn btn-warning" type="button">禁用测试</button>
                    <button class="btn btn-info" type="reset">刷新测试</button>
                    <button class="btn btn-primary">提交</button>
                    <button class="btn btn-default" type="reset">重置</button>
                </div>
            </form>
        </div>
       
</body>


<script src="/xiaoyin/static/js/fileinput.js" type="text/javascript"></script>
<script src="/xiaoyin/static/js/fileinput_locale_de.js" type="text/javascript"></script>
<script>

    $("#file-0").fileinput({
        'allowedFileExtensions' : ['jpg', 'png','gif'],
    });
    $("#file-1").fileinput({
        uploadUrl: '#', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
	});
    /*
    $(".file").on('fileselect', function(event, n, l) {
        alert('File Selected. Name: ' + l + ', Num: ' + n);
    });
    */
	$("#file-3").fileinput({
		showUpload: false,
		showCaption: false,
		browseClass: "btn btn-primary btn-lg",
		fileType: "any",
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
	});
	$("#file-4").fileinput({
		uploadExtraData: {kvId: '10'}
	});
    $(".btn-warning").on('click', function() {
        if ($('#file-4').attr('disabled')) {
            $('#file-4').fileinput('enable');
        } else {
            $('#file-4').fileinput('disable');
        }
    });    
    $(".btn-info").on('click', function() {
        $('#file-4').fileinput('refresh', {previewClass:'bg-info'});
    });
    /*
    $('#file-4').on('fileselectnone', function() {
        alert('Huh! You selected no files.');
    });
    $('#file-4').on('filebrowse', function() {
        alert('File browse clicked for #file-4');
    });
    */
    $(document).ready(function() {
        $("#test-upload").fileinput({
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif'],
            'elErrorContainer': '#errorBlock'
        });
        /*
        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
        });
        */
    });
    $("#input-24").fileinput({
    initialPreview: [
        "<img src='/images/moon.jpg' class='file-preview-image' alt='The Moon' title='The Moon'>",
        "<img src='/images/earth.jpg' class='file-preview-image' alt='The Earth' title='The Earth'>",
    ],
    overwriteInitial: false,
    maxFileSize: 100,
    initialCaption: "The Moon and the Earth"
});
	</script>
</html>