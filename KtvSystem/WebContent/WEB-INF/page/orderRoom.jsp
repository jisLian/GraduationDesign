<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<style>
	.title_tab{
		
		border-collapse: collapse;
	}
	td{
		width:200px;
		height:50px;
		line-height:50px;
		font-size:28px;
		text-align: center;
		cursor:pointer;
		
	}
	.room{
		margin-top:20px;
		width:70px;
		height:70px;
		background-color: brown;
		float:left;
		margin-right:10px;
		font-size:20px;
		color:white;		
		border-radius:5px;
		text-align: center;
		line-height: 70px;
	}
	.room:hover{
		background-color: rgba(165, 42, 42,0.5);
		cursor:pointer;
	}
	.roomDiv{
		clear: both;
		content:"";
		display:block;
		margin-left:80px;
		margin-top:-80px;
	}
	.infoDiv{
		margin-top:200px;
		margin-left:50px;
	}
	#btn{
		margin-left:100px;
		width:100px;
		height:30px;
		font-size:16px;
		background-color: blue;
		color:white;
		cursor:pointer;
	}
</style>
<body>
<table  class="title_tab">
<tr>
	<c:forEach items="${roomTypeList}" var="roomType">
	   	<td index="${roomType.roomTypeId }" fee="${roomType.perFee }">${roomType.typeName }</td>
	</c:forEach>
</tr>
</table>
<hr>
<br>
<h3>包厢号：</h3>
<div class="roomDiv">	
	<c:forEach items="${roomList}" var="room">
	   	<div class="room" >${room.roomId }</div>
	</c:forEach>
</div>
<div class="infoDiv">
<form action="submitRoom.do" method="post" id="submitRoom">
<input type="hidden" name="vipId" value="${loginUser.vipId }">
预定包厢号：<input type="text" readonly="readonly" id="roomId" width="30px" name="roomId"><br><br>
预定时间段：<input type="date" id="date" name="orderDate">&nbsp;&nbsp;&nbsp;&nbsp;
		<select id="timeRange" name="hours">
			<option selected="selected">请选择时间段</option>
			<option value="6">12:00-18:00</option>
			<option value="7">19:00-02:00</option>
		</select>
		 <br><br>
包厢费用：<input type="text" readonly="readonly" id="fee" discount="${loginUser.vipDiscount }" name="roomFee">	
<br><br>
<input type="button" value="提交订单" id="btn">
</form>
</div>
</body>
<script type="text/javascript">
	$("table>tbody>tr>td:eq(0)").css("background-color","lightGray");
	$("table>tbody>tr>td").mouseenter(function(){	
		$("table>tbody>tr>td:eq(0)").css("background-color","rgba(0,0,0,0)");
		$(this).css("background-color","lightGray");
	})
	$("table>tbody>tr>td").mouseleave(function(){
		$(this).css("background-color","rgba(0,0,0,0)");		
	})
	var fee;
	$("table>tbody>tr>td").click(function(){
		fee=$(this).attr("fee");
		$.ajax({
			type:"post",
			url:"findRoom.do",
			data:{"roomTypeId":$(this).attr("index")},
			dataType:"json",
			success:function(data){
				$(".roomDiv").html("");
				for(var i=0;i<data.length;i++){				
					$(".roomDiv").append("<div class='room'>"+data[i].roomId+"</div>");
				}
 
				$(".room").click(function(){
					$("#roomId").val($(this).html());
					$("#date").val("");
					$("#fee").val("");
					$("#timeRange").val("");
				})
			}
		})
	})
	$(".room").click(function(){
		$("#roomId").val($(this).html());
		fee=$("table>tbody>tr>td:eq(0)").attr("fee");
		$("#date").val("");
		$("#fee").val("");
		$("#timeRange").val("");
	})
	var myDate = new Date();
	var dateFlag=false;
	$("#date").blur(vaidate);
	$("#timeRange").change(function(){
		if(!dateFlag){
			alert("请先选择日期！");
			$("#timeRange").val("");
			return ;
		}
		else if($("#timeRange").val()!=""){
			if($("#timeRange").val()=="19:00-02:00"){
				$("#fee").val(fee*7*$("#fee").attr("discount"));
			}else{
				$("#fee").val(fee*6*$("#fee").attr("discount"));
			}		
		}				
										
	})
	function vaidate(){
		if($("#roomId").val()==""){
			alert("请先选择包厢");
			$("#date").val("");
			return;
		}
		var date=$(this).val().replace("-","/");
		date=date.replace("-","/");
		var year1=date.substring(0,date.indexOf("/"));
		var month1=date.substring(date.indexOf("/")+1,date.lastIndexOf("/"));
		var day1=date.substring(date.lastIndexOf("/")+1);
		var date2=myDate.toLocaleDateString();
		var year2=date2.substring(0,date2.indexOf("/"));
		var month2=date2.substring(date2.indexOf("/")+1,date2.lastIndexOf("/"));
		var day2=date2.substring(date2.lastIndexOf("/")+1);
		if(month2<10){
			month2="0"+month2;
		}
		if(day2<10){
			day2="0"+day2;
		}
		if(year1>=year2&&month1>=month2&&day1>=day2){
			dateFlag=true;
			return;
		}else {
			alert("所选时间无效");
			dateFlag=false;
			return;
		}
		
	}
	$("#btn").click(function(){
		if($("#roomId").val()==""){
			alert("请选择包厢！");
			return;
		}else if(!dateFlag){
			alert("请选择正确的时间！");
			return;
		}else if($("#fee").val==""){
			alert("提交订单失败！");
			return ;
		}else{
			alert("预定包厢成功！");
			$("#submitRoom").submit();
			return;
		}
		
	})
</script>
</html>