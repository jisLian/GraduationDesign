<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>myOrder</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" type="text/css" href="css/foodList.css">	
	 <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="js/jquery-1.8.0.js"></script>
  </head>
  <style>
  	.roomId_title{
		font-weight: bold;
		font-size:18px;
	}
	table{
		font-size:15px;
		margin-top:20px;
		width:580px;
		border-color: gray;
	}
  </style>
  <body bgcolor="#F3F3F3">
  <div class="bodyContent">
   <!-- 头部页面 -->
   <div class="head">
   		<div class="headTitle">KTV订单处理</div>
   		<a href="showRoom.do">返回</a>
   </div>
   <div class="food_container">  		
		<table align="center">
			<c:forEach var="roomGoods" items="${foodList}">
				<tr>
					<td colspan="2" class="roomId_title">包厢号:<span class="roomId">${roomGoods.roomId }</span></td>
					<td><div class="btn_accept">接单</div></td>
				</tr>
				<tr>
					<td colspan="2">商品名称</td>
					<td>商品数量</td>	
				</tr>
				<c:forEach var="goods" items="${roomGoods.roomGoodsList}">
					<tr>
					<td colspan="2">${goods.goodsName }</td>
						<td>${goods.orderCount }</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" ></td>
				</tr>
			</c:forEach>			
			
	</table>		
	</div>
	<!-- 尾部页面 -->
  	<div class="foot">
  		<a href="#">关于KTV</a>
  		&nbsp;|&nbsp;
  		<a href="#">服务条款</a>
  		&nbsp;|&nbsp;
  		<a href="#">客服中心</a>
  		&nbsp;|&nbsp;
  		<a href="#">联系我们</a>
  		&nbsp;|&nbsp;
  		<a href="#">帮助中心</a>
  		&nbsp;|&nbsp;
  		<span>©2017 KtvSystem.All Right Reserved</span>		
  	</div>
   </div>
  </body>
  <script>
		$(".btn_accept").click(function(){
			var index=$(".btn_accept").index(this);
			$.ajax({
				type:"post",
				url:"foodList.do",
				data:{"roomId":$(".roomId:eq("+index+")").html()},
				success:function(data){
					window.location.href="foodList.do";
				}
			})
		})	
	</script>
</html>
