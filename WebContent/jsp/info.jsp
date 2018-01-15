<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

</head>
<body>
    <div>${currentUser.loginName}</div>
    <div>${currentUser.zhName}</div>
    <div>${currentUser.id}</div>
    <div>${currentUser.enName}</div>
    <div>${currentUser.sex}</div>
    <div>${currentUser.email}</div>
    <div>${currentUser.phone}</div>
    <div>${currentUser.address}</div>
    
</body>
</html>
