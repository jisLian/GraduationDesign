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
<body>
<div class="container-fluid">
<div class="well">
<table class="table"> 
<thead>
	<tr height="50px">
		<th colspan="2"><input type="checkbox"/>全选/取消</th>
		<th>商品名称</th>
		<th>类别</th>
		<th>价格</th>
		<th>库存</th>		
	</tr>
</thead>
	<tbody>
	<c:forEach var="goods" items="${goodsList }" varStatus="status">
		<tr>
			<td><input type="checkbox"/></td>			
			<td><img alt="" src="images/goodsImgs/${goods.goodspicture }" width="40px" height="40px"></td>
			<td>${goods.goodsName}</td>
			<td>${goods.goodstype.goodstypename }</td>
			<td style="color:darkorange;font-weight:bold;">￥${goods.goodsPrice }</td>
			<td>${goods.goodscount}</td>			
		</tr>	
	</c:forEach>																			
		</tbody>
	</table>
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
</html>