<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	video{
		background-color: black;
		margin:auto;
	}
</style>
<body>
	<video width="820" height="540" controls autoplay>
		  <source src="video/${songPath}" type="video/mp4">
	</video>
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
</body>
</html>