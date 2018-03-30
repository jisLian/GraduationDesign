<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.roomTypeDiv{
		width:150px;
		height:150px;
		background-color: brown;
		color:white;
		font-size:17px;
		line-height:50px;
		radiu:5px;
		box-shadow:5px 5px 15px gray;
		text-align: center;
	}
	.roomTypeName{
		cursor:pointer;
		height:50px;
	}
	.roomTypeFee{
		height:50px;
		cursor:pointer;
	}
</style>
<body>
<div class="header">
	<h1 class="page-title">包厢管理</h1>	
</div>
<ul class="breadcrumb">
<li>
	<a class="active">包厢类型修改</a><span class="divider">+</span><a class="active">价格调整</a></li>   
</ul>
<div class="container-fluid">
<table>
<tr height="200px" valign="buttom">
<c:forEach var="roomType" items="${roomTypeList }" varStatus="status">
	<td width="200px">
		<div class="roomTypeDiv" id="roomTypeDiv${status.index }">
			<div class="roomTypeName">${roomType.typeName }</div>
			<div style="display:none;height:50px;">
			<input type="text" style="width:100px;height:20px;position:relative;top:10px;" maxlength="10" index="${roomType.roomTypeId }">
			</div>
			<div class="roomTypeFee">￥${roomType.perFee }/间</div>
			<div style="display:none;height:50px;">
			<input type="text" style="width:30px;height:20px;position:relative;top:10px;" maxlength="10" index="${roomType.roomTypeId }">
			</div>
		</div>
	</td>
</c:forEach> 
</tr>
</table>
<footer>
	<hr>
	<!-- 页脚部分 -->
	<p class="pull-right">
		In <a href="http://www.portnine.com/bootstrap-themes"
			target="_blank">JiShu.Lian</a> by <a href="#" title="在线KTV管理系统"
			target="_blank">在线KTV管理系统</a>
	</p>
	<p>
		&copy; 2017 <a href="#" title="在线KTV管理系统" target="_blank">在线KTV管理系统</a>
	</p>
</footer>
</div>
</body>
<script type="text/javascript">
	$("#roomTypeDiv0").css("background-color","brown");
	$("#roomTypeDiv1").css("background-color","orange");
	$("#roomTypeDiv2").css("background-color","blue");
	$("#roomTypeDiv3").css("background-color","purple");
	
	$(".roomTypeName").click(function(){
		$(this).css("display","none");
		$(this).next().css("display","block");
		$(this).next().find("input").focus();
		$(this).next().find("input").val($(this).html());
		$(this).next().find("input").blur(function(){
			$(this).parent().css("display","none");
			$(this).parent().prev().css("display","block");
			$(this).parent().prev().html($(this).val());
			$.ajax({
				type:"post",
				url:"updateRoomType.do",
				data:{"roomTypeName":$(this).val(),"roomTypeId":$(this).attr("index")},
				success:function(data){
					
				}
			})
		})
	})
	$(".roomTypeFee").click(function(){
		$(this).css("display","none");
		$(this).next().css("display","block");
		var index1=$(this).html().indexOf("/");
		$(this).next().find("input").focus();
		$(this).next().find("input").val($(this).html().substring(1,index1));
		$(this).next().find("input").blur(function(){
			$(this).parent().css("display","none");
			$(this).parent().prev().css("display","block");
			$(this).parent().prev().html("￥"+$(this).val()+"/间");
			$.ajax({
				type:"post",
				url:"updateRoomType.do",
				data:{"roomTypeFee":$(this).val(),"roomTypeId":$(this).attr("index")},
				success:function(data){				
				}
			})
		})
	})
	
</script>
</html>