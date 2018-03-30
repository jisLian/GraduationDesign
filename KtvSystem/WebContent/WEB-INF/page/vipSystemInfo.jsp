<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<style>
	.infoTab{
		font-size:15px;	
		border-collapse: collapse;
		width:800px;
	}
	.infoTab span{
		font-weight:bold;
		font-size:17px;
		}
		.infoArea{
			width:800px;
			height:400px;
			overflow:auto;
			margin-top:30px;
			margin-left:50px;		
		}
</style>
<body>
<div class="infoArea">
	<table class="infoTab" border="1">
		<c:forEach var="info" items="${infoList }" varStatus="staus">
			<tr>
			<td rowspan='2'>${staus.index+1 }</td>
			<td width="80px"><span>标题：</span></td>
			<td>${info.title }</td>
			<td width='80px' align='center' ><span>时间：</span></td>
			<td><fmt:formatDate value="${info.dateInfo }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
		</tr>
		<tr>
			<td><span>内容：</span></td>
			<td colspan='3'>${info.contentInfo }</td>
		</tr>
		<tr height='20px'>
			<td colspan='5' align='right'><!-- <input type="button" value="删除" style="background-color: brown;color:white;width:80px;" class="delete_btn"> --></td>
		</tr>
		</c:forEach>		
	</table>
</div>
<input type="hidden" id="tel" value="${loginUser.vipTel }">
</body>
<script type="text/javascript">
	
</script>
</html>