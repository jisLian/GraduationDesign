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
    <title>个人中心</title>
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
			<span>个人中心</span>
		<span class="glyphicon glyphicon-send" style="margin-left: 40px;margin-right:600px"></span>
		 <a href="inVip.do" style="magin-right:100px"><button type="button" class="btn btn-primary" >vip顾客：${loginUser.vipName}</button></a>
		  <a href="login.do"style="magin-left:100px"><button type="button" class="btn btn-primary">退出</button></a>
		 </div>
		 <input type="hidden" id="tel" value="${loginUser.vipTel }">
		<div class="content clear">
			<!--导航列表开始-->
			<div class="nav_left">
				<li id="user">
					<img src="images/head/${loginUser.vipHead }" alt="" class="head"><br>
					<span style="color: white">${loginUser.vipName}</span>
				</li>
				<a href="#myModal"  data-toggle="modal">
				<li><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;购买商品</li></a>
				<a href="orderRoom.do" target="iFrame1"><li><span class="glyphicon glyphicon-th-list"></span>&nbsp;&nbsp;预定包厢</li></a>
				<a href="updatepwd.do" target="iFrame1"><li><span class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;修改密码</li></a>
				<a href="intoVipSystemInfo.do?tel=${loginUser.vipTel }&flag=0" target="iFrame1"><li><span class="glyphicon glyphicon-bell"></span>&nbsp;&nbsp;消息中心</span></li></a>
			</div>
			<!--导航列表结束-->
			<!--内容开始-->
			<div class="right">
			<iframe name="iFrame1" width="100%" height="100%" src="vipInfo.do?vipId=${loginUser.vipId }" frameborder= "0" scrolling="no"></iframe> 
			</div>
			<!--内容结束-->
		</div>
	</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">提示信息</h4>
      </div>
      <div class="modal-body">
        	请输入包厢号：<input type="text" id="roomId"><span style="color:red" id="error"></span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="roomId_btn">确定</button>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript">
	$("#roomId").blur(function(){
		var regex = /^[A-Z]\d{3}$/;
		if($("#roomId").val().match(regex)) {
			$.ajax({
				type:"post",
				url:"queryRoom.do",
				data:{"roomId":$("#roomId").val()},
				success:function(data){
					$("#error").html(data);
				}
			})
			
		} else {
			$("#error").html("输入包厢无效！");
		}
		
	})
	$("#roomId_btn").click(function(){
		window.location.href="BuyGoods.do?typeId=0&pageCode=1&roomId="+$("#roomId").val();
	})
</script>
</html>
