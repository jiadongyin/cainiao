<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
 
  <link rel="stylesheet" href="/xiaoyin/static/layui/css/layui.css" media="all">
  <script src="/xiaoyin/static/layui/layui.js"></script>
  <script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>  
 
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="/xiaoyin/static/images/yjy02.jpg" class="layui-nav-img">
         ${currentUser}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
          <dd><a href="/xiaoyin/jsp/modifyPass.jsp">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="/xiaoyin/user/logout.action">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
       
        <li class="layui-nav-item">
          <a href="javascript:;">奎武一家</a>
          <dl class="layui-nav-child">
            <dd><a href="<%=basePath%>member/list.action?familyName=奎武一家">成员</a></dd>
            <dd><a href="javascript:;">相册</a></dd>
            <dd><a href="javascript:;">地图</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">瑜博一家</a>
          <dl class="layui-nav-child">
             <dd><a href="<%=basePath%>member/list.action?familyName=俞博一家">成员</a></dd>
            <dd><a href="javascript:;">相册</a></dd>
            <dd><a href="javascript:;">地图</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">佳怡一家</a>
          <dl class="layui-nav-child">
             <dd><a href="<%=basePath%>member/list.action?familyName=佳怡一家">成员</a></dd>
            <dd><a href="javascript:;">相册</a></dd>
            <dd><a href="javascript:;">地图</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">东麻子一家</a>
          <dl class="layui-nav-child">
             <dd><a href="<%=basePath%>member/list.action?familyName=东麻子一家">成员</a></dd>
            <dd><a href="javascript:;">相册</a></dd>
            <dd><a href="javascript:;">地图</a></dd>
          </dl>
        </li>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding:5px 0px 0px 0px;">
    	<!-- 搜索栏 -->
			<div class="layui-form-item" style="width: 1149px;height: 20px;">
				  <div class="layui-inline">
				    <label class="layui-form-label">成员名称</label>
				    <div class="layui-input-inline" style="width: 150px;">
				      <input type="text" name="memName" placeholder="关键字"  class="layui-input">
				    </div>
				  </div>
				  <div class="layui-inline">
				    <label class="layui-form-label">成员家庭</label>
				    <div class="layui-input-block">
				     <select class="layui-select" id="familyName" placeholder="成员家庭" name="familyName"  style="width: 150px;">
					 </select>  
				    </div>
			       </div>
			
				 <button class="layui-btn layui-btn-primary layui-btn-radius">查询</button>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    <button class="layui-btn layui-btn-radius">新增</button>
			    <button class="layui-btn layui-btn-normal layui-btn-radius">导入</button>
			    <button class="layui-btn layui-btn-danger layui-btn-radius">复选删除</button>
		     </div>
		<!-- 表格 -->	
    	<table id="demo" lay-filter="test">
		  <script type="text/html" id="barDemo">
             <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
             <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
             <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	       </script>
		</table>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © xiaoyin - 版权所有，盗版必究
  </div>
</div>

<script>
//JavaScript代码区域
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
	});
})


layui.use('element', function(){
  var element = layui.element;
});

//table
layui.use('table', function(){
  var table = layui.table;
 
  //第一个实例
 table.render({
    elem: '#demo'
    ,height: 471
    ,url: '/xiaoyin/member/list_layui.action' //数据接口
    ,page: true //开启分页
    ,request: {
    	  pageName: 'page' //页码的参数名称，默认：page
    	  ,limitName: 'rows' //每页数据量的参数名，默认：limit
    	} 
    ,response:{
	     statusName: 'code' //数据状态的字段名称，默认：code
	     ,statusCode: 200 //成功的状态码，默认：0
	     ,msgName: 'msg' //状态信息的字段名称，默认：msg
	     ,countName: 'count' //数据总数的字段名称，默认：count
	     ,dataName: 'data' //数据列表的字段名称，默认：data
	  }
     ,cols: [[ //表头
        {type:'checkbox'}
        ,{field: 'memId', title: 'ID', width:80, sort: true}
        ,{field: 'memName', title: '用户名', width:80}
        ,{field: 'memSex', title: '性别', width:80}
        ,{field: 'memAddress', title: '现居地', width:220} 
        ,{field: 'familyLocation', title: '籍贯', width:200} 
        ,{field: 'familyName', title: '家庭名称', width:100} 
        ,{field: 'memPhone', title: '联系电话', width:150} 
        ,{title: '操作',fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
     ]]
  });
});

//监听工具条事件
layui.use('table', function(){
	  var table = layui.table;
	  //监听表格复选框选择
	  table.on('checkbox(test)', function(obj){
	    console.log(obj)
	  });
	  //监听工具条
	  table.on('tool(test)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	      //layer.msg('ID：'+ data.memId + ' 的查看操作');
	    	//iframe层
	    	layer.open({
	    	  type: 2,
	    	  title: 'layer mobile页',
	    	  shadeClose: true,
	    	  shade: 0.8,
	    	  area: ['700px', '80%'],
	    	  content: '/xiaoyin/jsp/info.jsp' //iframe的url
	    	}); 
	    } else if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        $.post("<%=basePath%>member/delete.action",{"memId":data.memId},function(data){
				if(data == 'succ') {
					layer.alert('删除成功');
					obj.del();
				}else {
					layer.open({
						  type: 1,
						  skin: 'layui-layer-rim', //加上边框
						  area: ['420px', '240px'], //宽高
						  content: data    //此处返回的data是一个流，是unauthorized.jsp页面
						});
				}
			}, 'html');
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	     // layer.alert('编辑行：<br>'+ JSON.stringify(data))
	    	//iframe层
	    	layer.open({
	    	  type: 2,
	    	  title: 'layer mobile页',
	    	  shadeClose: true,
	    	  shade: 0.8,
	    	  area: ['30%', '90%'],
	    	  content: '/xiaoyin/jsp/edit.jsp' //iframe的url
	    	}); 
	    }
	  });
	  
	  var $ = layui.$, active = {
	    getCheckData: function(){ //获取选中数据
	      var checkStatus = table.checkStatus('idTest')
	      ,data = checkStatus.data;
	      layer.alert(JSON.stringify(data));
	    }
	    ,getCheckLength: function(){ //获取选中数目
	      var checkStatus = table.checkStatus('idTest')
	      ,data = checkStatus.data;
	      layer.msg('选中了：'+ data.length + ' 个');
	    }
	    ,isAll: function(){ //验证是否全选
	      var checkStatus = table.checkStatus('idTest');
	      layer.msg(checkStatus.isAll ? '全选': '未全选')
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	});
</script>
</body>
</html>
