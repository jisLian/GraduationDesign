<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>waiter</title>
     <link href="images/xiao2.ico" rel="shortcut icon">
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	
  </head>
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
  <style>
	.container{
		margin:auto;
	}
	.nav{
		height: 80px;
		line-height: 80px;
		font-size: 30px;
		color: white;
		background: #4E8CAE;
	}
	.nav_left{
		background-color: #424A5D;
		width: 200px;
		list-style: none;
		height: 580px;
		color:darkgrey;
		font-size: 15px;
		display: inline-block;
		float: left;
	}
	.nav_left li{
		height:40px;
		text-align: center;
		line-height: 40px;
	}
	
	#user{
		height:150px;
		text-align: center;
		vertical-align: middle;
		padding-top:10px;
		
	}
	.head{
		width:70px;
		height: 70px;
		border-radius: 50%;
		margin: auto;
		background-size:cover;
		
	}
	.right{
		width: 940px;
		height: 580px;
		float:right;
		text-align: center;
		background-image: url("images/bg.png");
		background-size:cover;
		overflow: hidden;		
	}
	.clear:after{
		clear:both;
		display: block;
		content: "";
	}
	#user:hover{
		background-color:#424A5D ;
	}
	.nav_left a{
		text-decoration: none;
		color:darkgrey;
	}
	.nav_left li:hover{
		background-color: darkcyan;
		cursor: pointer;
	}
</style>
<body>
	<div class="container">
	  <div class="nav">
		<span class="glyphicon glyphicon-align-justify" style="margin-left: 10px;"></span>
			<span>服务管理</span>
		<span class="glyphicon glyphicon-send" style="margin-left: 40px;margin-right:600px"></span>
		 <a href="intoCommonPer.do" style="magin-right:100px"><button type="button" class="btn btn-primary" >服务员：${loginUser.empName}</button></a>
		  <a href="login.do"style="magin-left:100px"><button type="button" class="btn btn-primary">退出</button></a>
		 </div>
		<div class="content clear">
			<!--导航列表开始-->
			<div class="nav_left">
				<li id="user">
					<img src="images/head2.jpg" alt="" class="head"><br>
					<span style="color: white">${loginUser.empName}</span>
				</li>
				<a href="waiterGoods.do" target="iFrame1"><li><span class="glyphicon glyphicon-gift"></span>&nbsp;&nbsp;配送商品</li></a>
				<a href="getWaiterInfo.do?flag=0" target="iFrame1"><li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;消息中心&nbsp;&nbsp;<span class="label label-info" id="infoCount">+0</span></li></a>
			</div>
			<!--导航列表结束-->
			<!--内容开始-->
			<div class="right">
			<iframe name="iFrame1" width="100%" height="100%" src="waiterGoods.do" frameborder= "0" scrolling="no"></iframe> 
			</div>
			<!--内容结束-->
		</div>
	</div>
</body>
<script type="text/javascript">
window.onload=function(){
	getInfo();
	window.setInterval("getInfo()",5000);
	}
function getInfo(){
	$.ajax({
		type:"post",
		url:"getInfo.do",
		dataType:"json",
		data:{"flag":1},
		success:function(data){
			$("#infoCount").html("+"+data.length);
			}
	})
}
</script>
</html>
