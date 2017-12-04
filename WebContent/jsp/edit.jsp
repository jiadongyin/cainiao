<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="/xiaoyin/static/layui/css/layui.css" media="all">
  <script src="/xiaoyin/static/js/jquery-2.0.3.min.js"></script>
</head>
<body>
          
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>表单</legend>
</fieldset>
 
<form class="layui-form" action="/xiaoyin/member/add_back.action" id="userinfo_form" method="post">
  <input type="hidden" id="memId" name="memId">
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block" style="width: 180px">
      <input type="text" name="memName" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
    </div>
   </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input type="radio" name="memSex" value="男" title="男" checked="">
      <input type="radio" name="memSex" value="女" title="女">
    </div>
  </div> 
  
  <div class="layui-inline">
      <label class="layui-form-label">出身日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="birthday" name="birthday" placeholder="yyyy-MM-dd">
      </div>
   </div>
    
  <div class="layui-form-item">
    <label class="layui-form-label">婚否</label>
    <div class="layui-input-block">
      <input lay-filter="marry" type="radio" name="marry" value="已婚" title="已婚" checked>
      <input lay-filter="marry" type="radio" name="marry" value="未婚" title="未婚" >
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">配偶</label>
    <div class="layui-input-block"  style="width: 180px">
      <input type="text" id="worh" name="worh"  placeholder="配偶姓名"  class="layui-input" >
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">子女</label>
    <div class="layui-input-block"  style="width: 180px">
      <input type="text" id="memChildren" name="memChildren"  placeholder="子女姓名"  class="layui-input" >
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">成员家庭</label>
    <div class="layui-input-block"  style="width: 180px">
      <select name="interest" lay-filter="aihao">
        <option value=""></option>
        <option value="0">写作</option>
        <option value="1">阅读</option>
        <option value="2">游戏</option>
        <option value="3">音乐</option>
      </select>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label" >手机号</label>
      <div class="layui-input-inline"  style="width: 180px">
        <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
 <div class="layui-form-item">
      <label class="layui-form-label">现居地</label>
      <div class="layui-input-inline" style="width: 180px">
          <select name="province" lay-filter="province" >
              <option value="">请选择省</option>
          </select>
          <select name="city" lay-filter="city" >
              <option value="">请选择市</option>
          </select>
           <select name="area" lay-filter="area" >
              <option value="">请选择县/区</option>
          </select>
	      <input type="text" name="town" lay-verify="required" placeholder="详细地址" autocomplete="off" class="layui-input">
	    </div>
  </div>
  
  
	 <div class="layui-upload" style="margin-left: 100px;">
	  <button type="button" class="layui-btn" id="t1">上传图片</button>
	  <div class="layui-upload-list">
	     <img class="layui-upload-img" id="pic"   style="width: 180px;height: 200px;">
	     <input type="hidden" id="file"  name="pic"  >
	    <p id="demoText"></p>
	  </div>
	</div> 
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>


<script src="/xiaoyin/static/layui/layui.js"></script>
<script src="/xiaoyin/static/layui/mods/areas.js"></script>
<script src="/xiaoyin/static/layui/mods/cityselect.js"></script>
<script>
layui.use(['cityselect'],function(){
	//layui.cityselect.Init('userinfo_form',‘默认选中省份code’,'城市code','地区code');
    layui.cityselect.Init('userinfo_form','110000','110100','110101');
});    
</script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
   var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期常规用法
  laydate.render({
    elem: '#birthday'
  });

  form.on('radio(marry)', function(data){
	 if(data.value == '未婚'){
		 $('#worh').attr('disabled', true);
		 $('#memChildren').attr('disabled', true);
		 $('#worh').attr('placeholder', '禁用');
		 $('#memChildren').attr('placeholder', '禁用');
	 }
	 if(data.value == '已婚'){
		 $('#worh').attr('disabled', false);
		 $('#memChildren').attr('disabled', false);
		 $('#worh').attr('placeholder', '配偶姓名');
		 $('#memChildren').attr('placeholder', '子女姓名');
	 }
  });  

  
  //监听提交
  form.on('submit(demo1)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
   // return false;
  });
  
});


layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	    elem: '#t1'
	    ,url: '/xiaoyin/member/ajax_upload.action'
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#pic').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	      if(res.code == 200){
	    	 $('#file').val(res.src);
	       // return layer.msg('上传成功');
	      }
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
});




</script>

</body>
</html>