<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<link rel="stylesheet" type="text/css" href="css/openRoom.css">
<link rel="stylesheet" type="text/css" href="css/foodList.css"> 
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
</head>
<style>
	.total_right{
		display:inline-block;
		margin-left:520px;
		margin-top:10px;
		color:red;
		font-size:20px;
		font-family:"楷体";
		text-align: right;
		
	}
	.food_container{
		width: 940px;
		height: 580px;
		text-align: center;
		background-image: url("images/bg.png");
		background-size:cover;
		overflow: hidden;
		margin:auto;
	}
	table{
		font-size:15px;
		margin-top:20px;
		width:580px;
		border-color: gray;
	}
	.roomId_title{
		font-weight: bold;
		font-size:18px;
	}
</style>
<body>
	 <div class="total">
	 	<div class="total_left"><span class="glyphicon glyphicon-pushpin"></span>包厢状态列表</div>
	 	<div class="total_right">&nbsp;&nbsp;&nbsp;${RegSuccess }</div>
	</div>	
	<div class="food_container">  		
		<table align="center" border="1">
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
</body>
	<script>
		$(".btn_accept").click(function(){
			var index=$(".btn_accept").index(this);
			$.ajax({
				type:"post",
				url:"waiterGoods.do",
				data:{"roomId":$(".roomId:eq("+index+")").html()},
				success:function(data){
					window.location.href="waiterGoods.do";
				}
			})
		})	
	</script>
</html>