<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	th{
		font-size:17px;
		color:brown;
	}
</style>
<body>
<div class="header">
	<h1 class="page-title">包厢管理</h1>	
</div>
<ul class="breadcrumb">
<li>
	<a class="active">折扣时间段修改</a><span class="divider">+</span><a class="active">价格调整</a></li>   
</ul>
<div class="container-fluid">
<div class="well">
	<table class="table">  
		<thead>
			<tr>
				<th>包厢类型</th>
				<th>加价开始时间-加价结束时间</th>
				<th>折扣</th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="addPrice" items="${addPriceList }" varStatus="status">
				<tr>
					<td>&nbsp;${addPrice.roomTypeId.typeName }</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<fmt:formatDate value="${addPrice.timeId.startAddPrice }" pattern="hh:mm:ss"/>
						--
						<fmt:formatDate value="${addPrice.timeId.endAddprice }" pattern="hh:mm:ss"/>
					</td>
					<td>
					<div class="discount">&nbsp;${addPrice.discountPrice }</div>					
					<input type="text" style="display:none;width:30px;height:10px;" index="${addPrice.roomTypeId.roomTypeId}" index2="${addPrice.timeId.timeId}">
					</td>				
				</tr>
		</c:forEach> 																		
		</tbody>
	</table>
	</div>
</div>
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
	$(".discount").click(function(){
		$(this).css("display","none");
		$(this).next().css("display","block");
		$(this).next().val($(this).html().substring($(this).html().indexOf(";")+1));
		$(this).next().focus();
		$(this).next().blur(function(){
			$(this).css("display","none");
			$(this).prev().css("display","block");
			$(this).prev().html("&nbsp;"+$(this).val());
			$.ajax({
				type:"post",
				url:"updateRoomDis.do",
				data:{"RoomDis":$(this).val(),"roomTypeId":$(this).attr("index"),"timeId":$(this).attr("index2")},
				success:function(data){				
				}
			})
		})
	})
</script>
</html>