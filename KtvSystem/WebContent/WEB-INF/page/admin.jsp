<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员中心</title>
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
 <script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<!-- Demo page code -->

<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="lib/html5.js"></script>
    <![endif]-->

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="images/xiao2.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="../assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="../assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="../assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="">
	<!--<![endif]-->

	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav pull-right">

				<li><a href="showRoom.do"
					class="hidden-phone visible-tablet visible-desktop" role="button">总台管理</a></li>
				<li id="fat-menu" class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i> ${loginUser.empName } <i
						class="icon-caret-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="javascript:intoPersonal()">个人中心</a></li>
						<li class="divider"></li>
						
						<li><a tabindex="-1" href="login.do">退出</a></li>
					</ul>
				</li>

			</ul>
			<a class="brand"><span class="first">Wellcome</span> <span
				class="second">Admin</span></a>
		</div>
	</div>
	<div class="sidebar-nav">
		<a href="javascript:selLanguage('全部',1)" class="nav-header"><i
			class="icon-music"></i>曲库管理</a>
		<a href="javascript:manageGoods(0,1)" class="nav-header"><i
			class="icon-shopping-cart"></i>商品管理</a>

		<a href="#error-menu2" class="nav-header collapsed"
			data-toggle="collapse"><i class="icon-th"></i>包厢管理<i
			class="icon-chevron-up"></i></a>
		<ul id="error-menu2" class="nav nav-list collapse">
			<li><a href="javascript:manageRoom()">包厢类型管理</a></li>
			<li><a href="javascript:manageRoomDis()">包厢折扣管理</a></li>
		</ul>		
		<a href="#error-menu4" class="nav-header collapsed"
			data-toggle="collapse"><i class="icon-user"></i>顾客管理<i
			class="icon-chevron-up"></i></a>
			<ul id="error-menu4" class="nav nav-list collapse">
			<li><a href="Javascript:initVip(1)">会员信息管理</a></li>
			<li><a href="javascript:initUser(1)">普通顾客信息管理</a></li>
		</ul>
			<a href="javascript:manageEmp(1)" class="nav-header">
		<i class="icon-bookmark"></i>员工管理</a>
		
		<a href="javascript:systemInfo()" class="nav-header"><i
			class="icon-info-sign"></i>消息通知</a>
	</div>
	<div class="content">	
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
	//跳转到曲库管理页面
	function selLanguage(language,pageCode){
		$.ajax({
			type:"post",
			url:"findSongByLanguage.do",
			data:{"language":language,"pageCode":pageCode},
			success:function(data){
				$(".content").html(data);
				var len=$(".pagination ul > li>a").length;
				for(var i=1;i<len-1;i++){
					if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
						$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
					}
				}
			}	
				
		})
	}
	window.onload=function(){
		selLanguage('全部',1);
		//manageGoods(0,1);
		//initVip(1);
	}
		$("[rel=tooltip]").tooltip();
		$(function() {
			$('.demo-cancel-click').click(function() {
				return false;
			});
		});
	//进入商品管理中心
	function manageGoods(goodsTypeId,pageCode){
		$.ajax({
			type:"post",
			url:"manageGoods.do",
			data:{"goodsTypeId":goodsTypeId,"pageCode":pageCode},
			success:function(data){
				$(".content").html(data);
				var len=$(".pagination ul > li>a").length;
				for(var i=1;i<len-1;i++){
					if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
						$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
					}
				}
			}
		})
	}
	//包厢管理
	function manageRoom(){
		$.ajax({
			type:"post",
			url:"manageRoom.do",
			success:function(data){
				$(".content").html(data);
			}
		})
	}
	//包厢折扣管理
	function manageRoomDis(){
		$.ajax({
			type:"post",
			url:"manageRoomDis.do",
			success:function(data){
				$(".content").html(data);
			}
		})
	}
	//初始化vip用户
	function initVip(pageCode){
		$.ajax({
			type:"post",
			url:"vipUsers.do",
			data:{"pageCode":pageCode},
			success:function(data){
				$(".content").html(data);
				var len=$(".pagination ul > li>a").length;
				for(var i=1;i<len-1;i++){
					if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
						$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
					}
				}
			}
		})
	}
	//初始化普通用户
	function initUser(pageCode){
		$.ajax({
			type:"post",
			url:"commonUser.do",
			data:{"pageCode":pageCode},
			success:function(data){
				$(".content").html(data);
				var len=$(".pagination ul > li>a").length;
				for(var i=1;i<len-1;i++){
					if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
						$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
					}
				}
			}
		})
	}
	//初始化员工
	function manageEmp(pageCode){
		$.ajax({
			type:"post",
			url:"manageEmp.do",
			data:{"pageCode":pageCode},
			success:function(data){
				$(".content").html(data);
				var len=$(".pagination ul > li>a").length;
				for(var i=1;i<len-1;i++){
					if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
						$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
					}
			}}
		})
	}
	//进入员工个人页面
	function intoPersonal(){
		$.ajax({
			type:"post",
			url:"intoPerson.do",
			success:function(data){
				$(".content").html(data);
			}})
	}
	//消息通知
	function systemInfo(){
		$.ajax({
			type:"post",
			url:"systemInfo.do",
			success:function(data){
				$(".content").html(data);
			}})
	}
	</script>
</body>
</html>