<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script type="text/javascript" src="js/jquery-1.8.0.js"></script>
</head>
<style>
	tr{
		height:50px;
	}
	tr:hover{
		background-color: lightgray;
	}
	table{
		border-collapse:collapse;
		width:1000px;
		margin-left:20px;
	}
</style>
<body>
<div style="width:1000px;height:700px;margin:auto;">
<div class="header">     
      <h1 class="page-title">个人中心</h1>
 </div>
 <div class="well">
<table class="table" >
	<tr><td width="50px">姓名：</td><td>${vip.vipName }</td></tr>
	<tr><td>性别：</td><td>${vip.VIPSex==0?'男':'女' }</td></tr>
	<tr><td>等级：</td><td>${vip.vipLevel }</td></tr>
	<tr><td>电话：</td><td>${vip.vipTel }</td></tr>
	<tr><td>生日：</td><td><fmt:formatDate value="${vip.vipBirth }" pattern="yyyy-MM-dd"/></td></tr>
</table>
</div>
</div>
</body>
<script type="text/javascript">
	
</script>
</html>