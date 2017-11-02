<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> 
	<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
	      
	    <link rel="stylesheet" href="<%=basePath%>css/bootstrap-theme.min.css">  
	    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->  
	    <script src="<%=basePath%>js/jquery-1.11.3.min.js"></script>  
	    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->  
	    <script src="<%=basePath%>js/bootstrap.min.js"></script> 
	<title>百度地图</title>  
	<style type="text/css">   
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#container {width: 100%; height:92%; overflow: hidden;}
		dl,dt,dd,ul,li{
			margin:0;
			padding:0;
			list-style:none;
		}
		p{font-size:12px;}
		dt{
			font-size:14px;
			font-family:"微软雅黑";
			font-weight:bold;
			border-bottom:1px dotted #000;
			padding:5px 0 5px 5px;
			margin:5px 0;
		}
		dd{
			padding:5px 0 0 5px;
		}
		li{
			line-height:28px;
		}
		
		
	</style>  
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=zvPR5yvDR5Q4rir2A4LbPYG5KFDdhajo"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/library/DistanceTool/1.2/src/DistanceTool_min.js"></script>
	<!--加载鼠标绘制工具-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css" />
	<!--加载检索信息窗口-->
	<script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.js"></script>
	<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.4/src/SearchInfoWindow_min.css" />
  </head>
  
  <body>
  <!--描述：导航条 -->
			<div class="container-fluid" style="height: 20px;width: 100%">
				<nav class="navbar navbar-default">
				  <div class="container-fluid" style="height: 20px;width: 100%">
				    <div class="navbar-header">
						<a class="navbar-brand" href="<%=basePath%>index.html">首页<span class="sr-only">(current)</span></a>
					</div>
					<div class="navbar-header" style="position: absolute;margin-top: 10px;margin-left: 50px">
						&nbsp;输入位置信息（省/市/县/乡）：<input id="wz" type="text" name="weizhi"/>&nbsp;&nbsp;
				  		<input id="butt" type="button" value="搜索" onclick="search()" class="btn btn-default"/>&nbsp;&nbsp;
				  		&nbsp;&nbsp;输入行政区信息（省/市/县）：
				  		<input id="xzq" type="text" name="xingzhengqu"/>&nbsp;&nbsp;
				  		<input id="butt2" type="button" value="获取行政区划" class="btn btn-default" onclick="getBoundary()"/>&nbsp;&nbsp;
				  		<button onclick="ce()" class="btn btn-default">测量</button>&nbsp;&nbsp;
				  		<button onclick="jingwei()" class="btn btn-default">点击获取经纬度</button>&nbsp;&nbsp;
					</div>
				 </div>
			</nav>
		 </div>  
  
  	
	
	<div id="container" style="overflow:hidden;zoom:1;position:relative;">	
		<div id="map" style="height:100%;-webkit-transition: all 0.5s ease-in-out;transition: all 0.5s ease-in-out;"></div>
	</div>

	<script type="text/javascript">
		var map = new BMap.Map("container");          // 创建地图实例  
		var point = new BMap.Point(115.156, 30.916);  // 创建点坐标  30.9107202,115.1505606
		map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别  
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
		map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
		
		var myDis = new BMapLib.DistanceTool(map);//测量尺
		
		var overlays = [];
		var overlaycomplete = function(e){
	        overlays.push(e.overlay);
	    };
	    var styleOptions = {
	        strokeColor:"red",    //边线颜色。
	        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
	        strokeWeight: 3,       //边线的宽度，以像素为单位。
	        strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
	        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
	        strokeStyle: 'solid' //边线的样式，solid或dashed。
	    }
	    //实例化鼠标绘制工具
	    var drawingManager = new BMapLib.DrawingManager(map, {
	        isOpen: false, //是否开启绘制模式
	        enableDrawingTool: true, //是否显示工具栏
	        drawingToolOptions: {
	            anchor: BMAP_ANCHOR_BOTTOM_RIGHT, //位置
	            offset: new BMap.Size(5, 5), //偏离值
	        },
	        circleOptions: styleOptions, //圆的样式
	        polylineOptions: styleOptions, //线的样式
	        polygonOptions: styleOptions, //多边形的样式
	        rectangleOptions: styleOptions //矩形的样式
	    });  
		 //添加鼠标绘制工具监听事件，用于获取绘制结果
	    drawingManager.addEventListener('overlaycomplete', overlaycomplete);
	    function clearAll() {
			for(var i = 0; i < overlays.length; i++){
	            map.removeOverlay(overlays[i]);
	        }
	        overlays.length = 0   
	    }
		
		function jingwei(){
			var geoc = new BMap.Geocoder();    //逆地址解析，点击地图展示详细地址
			map.addEventListener("click", function(e){        
				var pt = e.point;
				geoc.getLocation(pt, function(rs){
					var addComp = rs.addressComponents;
					alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber+"\n"+"经度："+e.point.lng + ",纬度：" + e.point.lat);
				});        
			});
			
		}
		
		function ce(){
			myDis.open();
		}
	
		function search(){
		    var p = document.getElementById("wz").value;
		    //alert(p);
			// 百度地图API功能
			// 创建地址解析器实例
			var myGeo = new BMap.Geocoder();
			// 将地址解析结果显示在地图上,并调整地图视野
			myGeo.getPoint(p, function(point){
				if (point) {
					map.centerAndZoom(point, 13);
					map.addOverlay(new BMap.Marker(point));
				}else{
					alert("您选择地址没有解析到结果!");
				}
			}, p);
		}
	
		function getBoundary(){    
		var xzq = document.getElementById("xzq").value;
		var bdary = new BMap.Boundary();
		bdary.get(xzq, function(rs){       //获取行政区域
			map.clearOverlays();        //清除地图覆盖物       
			var count = rs.boundaries.length; //行政区域的点有多少个
			if (count === 0) {
				alert('未能获取当前输入行政区域');
				return ;
			}
          	var pointArray = [];
			for (var i = 0; i < count; i++) {
				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
				map.addOverlay(ply);  //添加覆盖物
				pointArray = pointArray.concat(ply.getPath());
			}    
			map.setViewport(pointArray);    //调整视野  
			addlabel();               
		});   
	}
	</script>
  </body>
  
</html>

