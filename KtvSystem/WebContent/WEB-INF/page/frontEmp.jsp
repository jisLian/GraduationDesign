<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jis.util.Token"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">   
    <title>openRoom</title>
    <link href="images/xiao2.ico" rel="shortcut icon">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <link rel="stylesheet" type="text/css" href="css/openRoom.css">
  <link rel="stylesheet" type="text/css" href="css/login.css"> 
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
  </head>
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="js/jquery-1.8.0.js"></script>
  
  <style>
  	.nav{
		height: 70px;
		line-height: 70px;
		font-size: 30px;
		color: white;
		background: #4E8CAE;
		width:1170px;
	}
	.total_right{
		display:inline-block;
		margin-left:520px;
		margin-top:10px;
		color:red;
		font-size:20px;
		font-family:"楷体";
		text-align: right;
		
	}
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
 	<div class="container">
	  	<div class="nav">
			<span class="glyphicon glyphicon-align-justify" style="margin-left: 10px;"></span>
			<span>KTV总台管理</span>
			<span class="glyphicon glyphicon-send" style="margin-left: 40px;margin-right:550px"></span>
			<a href="intoCommonPer.do"><button type="button" class="btn btn-primary" >前台人员：${loginUser.empName }</button></a>
			<a href="login.do" style="margin-left: 50px"><button type="button" class="btn btn-primary">退出</button></a>
	  	</div>
		<div class="main_part clear">
			<!--导航列表开始-->
			<div class="nav_left">
				<p id="price" align="center">包厢价格：<span class="price"></span>/小时</p>
				<div class="guide" id="btn_order" >预约包厢</div>
				<div class="guide" id="btn_con">续费包厢</div>
				<div class="guide" id="regVip">注册会员</div>
				<div class="guide" id="btn_exit">退订包厢</div>
				<div class="guide" id="btn_foodList">订单处理</div>
				<div class="guide" id="btn_backInfo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消息中心&nbsp;&nbsp;<span class="label label-info" id="infoCount">+0</span></div>
			</div>
			<div class="Left_part clear" id="leftContent">
			  	 <div class="total">
			  	 	<div class="total_left"><span class="glyphicon glyphicon-pushpin"></span>包厢状态列表</div>
	  			 	<div class="total_right">&nbsp;&nbsp;&nbsp;${RegSuccess }</div>
	  			</div>	  		
	  		<div class="bodyContent">
	   			<marquee direction="left" scrolldelay="5" onMouseOver="this.stop()" onMouseOut="this.start()" >
					<span class="moveDiv">18:00--23:00  高峰期  涨价50%&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;00:00--07:00  淡期  七折</span>
	   			</marquee>
	  
		   		<!-- 显示房间类型信息 -->
		 		<input type="hidden" id="hiddenArea">
		 		<input type="hidden" id="hiddenDiscount">
		 		<input type="hidden" id="hiddenTime">
				<table align="center">
					<tr class="typeTr">
						<c:forEach items="${roomTypeList}" var="list" >
							<td id="${list.roomTypeId}" class="roomTypeId">${list.typeName}</td>
						</c:forEach>
					</tr>
					<tr class="bodyDiv">					
						<td colspan="4" height="300px;" align="center">
						<div class="emptyRoomDiv">
							<div class="roomInfo"></div>
							<div class="chooseRoom">
								<form action="showRoom.do" method="post" id="ChooseRoom" onSubmit="return validateRoomInfo()">
								<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
								<table class="chooseRoomTab">
									<tr><td>选择包厢:<input type="text" id="selectedRoom" readonly name="selectedRoom" class="selectedRoom">&nbsp;&nbsp;&nbsp;&nbsp;<span class="selRoomTip"></span></td></tr>
									<tr>
										<td class="customerDiv">
											<div class="commonLogin">顾客姓名:<input type="text" name="vipName" class="vipName" style="outline:none">&nbsp;&nbsp;&nbsp;&nbsp;<span class="vipTip"></span></div>			
											<div class="commonTel">顾客电话:<input type="text" name="vipTel" class="vipTel" style="outline:none">&nbsp;&nbsp;&nbsp;&nbsp;<span class="vipTelTip"></span></div>
										</td>
									</tr>
									<tr><td>预订时间:<select name="orderTime" id="OrderTime" class="OrderTime" style="font-size:12px;"><option value="0">---------选择约定时间-------</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<span class="timeTip"></span></td></tr>
									<tr><td>应付金额:<input type="text" readonly name="money" class="Money">&nbsp;&nbsp;&nbsp;&nbsp;<span id="MoneyTip" class="MoneyTip"></span></td></tr>
									<tr><td height="40px;" style="text-align:center"><input type="submit" value="包厢提交"></td></tr>
								</table>
								</form>
							</div>	
						</div>
						<div class="UseRoomDiv">
							<div class="hasUseRoom"></div>
							<div class="chooseRoom">
							<!-- 续费包厢 -->
							<form action="renewRoom.do" method="post" id="ChooseRoom" onSubmit="return validateContinueRoom()">
								<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
								<table class="chooseRoomTab">
									<tr><td>续费包厢:<input type="text" id="ContinueRoom" readonly name="continueRoom">&nbsp;&nbsp;&nbsp;&nbsp;<span id="selRoomTip"></span></td></tr>		
									<tr>
										<td class="customerDiv">
											<div class="commonLogin">顾客电话:<input type="text" name="conVipTel" readonly id="vipTel">&nbsp;&nbsp;&nbsp;&nbsp;<span class="vipDiscount"></span></div>		
										</td>
									</tr>
									<tr><td><div>续订时间:<select id="ContinueTime" name="continueTime" style="font-size:12px;"><option value="0">--------选择约定时间-------</option></select>&nbsp;&nbsp;&nbsp;&nbsp;<span id="timeTip"></span></div></td></tr>
									<tr><td>应付金额:<input type="text" id="Money" readonly name="conMoney">&nbsp;&nbsp;&nbsp;&nbsp;<span class="MoneyTip"></span></td></tr>
									<tr><td height="40px;" style="text-align:center"><input type="submit" value="续费提交"></td></tr>
								</table>
							</form>				
							</div>
						</div>
								
						<!-- 注册会员地区 -->
						<div class="regVipArea">
							<form action="regVip.do" method="post" onSubmit="return validate()">
								<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
					  			<table class="regTab">
					  				<tr><td><input id="RegName" type="text" placeholder="请输入注册用户名" name="regName"/></td></tr>
					  				<tr height="30px"><td id="nameTip" style="color:red;font-size:15px"></td></tr>
					  				<tr><td><input type="text" placeholder="请输入电话号码" id="RegTel" name="regTel"/></td></tr>
					  				<tr height="30px"><td style="color:red;font-size:15px" id="reTelTip"></td></tr>	
					  				<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;生日：</td></tr>				  				
					  				<tr>
					  				<td><input type="date" name="birthday" placeholder="请输入生日"/>
					  				</td></tr>
					  				<tr  height="50px">
					  				<td>
					  				<input type="radio" name="vipSex" value="0" checked="checked" style="width:15px;height:15px;"/>男
					  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  				<input type="radio" name="vipSex" value="1"style="width:15px;height:15px;"/>女
					  				</td></tr>
					  				<tr><td><input type="submit" value="注册" id="loginBtn" style="background-color:brown;color:white;"/></td></tr>			  				
					  			</table> 				  			
					  		</form>
						</div>
						<div class="ExitRoomDiv">
							<div class="ExitRoomInfo"></div>
							<div class="chooseRoom">
							<form action="showExitRoom.do" method="post" onSubmit="return validateExitRoom()">
								<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
								<table class="chooseRoomTab">
									<tr><td>退订包厢:<input type="text" id="ExitRoomId" readonly name="exitRoomId">&nbsp;&nbsp;&nbsp;&nbsp;<span id="exitRoomTip"></span></td></tr>		
									<tr><td class="customerDiv"><div class="commonLogin">顾客电话:<input type="text" name="exitVipTel" readonly id="exitVipTel">&nbsp;&nbsp;&nbsp;&nbsp;<span class="ExitVipDiscount"></span></div></td></tr>
									<tr><td>开始时间:<input type="text" id="startTime" readonly></td></tr>
									<tr><td>预结时间:<input type="text" id="endTime" readonly></td></tr>
									<tr><td>补交金额:<input type="text" id="exitMoney" readonly name="exitMoney">&nbsp;&nbsp;&nbsp;&nbsp;<span class="exitMoneyTip"></span></td></tr>
									<tr><td height="40px;" style="text-align:center"><input type="submit" value="退订提交"></td></tr>
								</table>
							</form>					
							</div>
						</div>
						<div class="infoArea">
							<table class="infoTab" border="1">
								
							</table>
						</div>
						<div class="personal">
							
						</div>		
					</td>
				</tr>				
			</table>				
  		</div>
	  </div>
	</div>
	</div>
  </body>
  
<script>
Date.prototype.Format = function(fmt) { //author: meizz  
		var o = {
			"M+" : this.getMonth() + 1, //月份  
			"d+" : this.getDate(), //日  
			"h+" : this.getHours(), //小时  
			"m+" : this.getMinutes(), //分  
			"s+" : this.getSeconds(), //秒  
			"q+" : Math
					.floor((this.getMonth() + 3) / 3), //季度  
			"S" : this.getMilliseconds()
		//毫秒  
		};
		if (/(y+)/.test(fmt))
			fmt = fmt.replace(RegExp.$1, (this
					.getFullYear() + "")
					.substr(4 - RegExp.$1.length));
		for ( var k in o)
			if (new RegExp("(" + k + ")").test(fmt))
				fmt = fmt
						.replace(
								RegExp.$1,
								(RegExp.$1.length == 1) ? (o[k])
										: (("00" + o[k])
												.substr(("" + o[k]).length)));
		return fmt;
	}
	
window.onload=function(){
	getInfo();
	window.setInterval("getInfo()",5000);
	
}	
  	function getInfo(){
  		$.ajax({
  			type:"post",
  			url:"getInfo.do",
  			dataType:"json",
  			data:{"flag":2},
  			success:function(data){
  				$("#infoCount").html("+"+data.length);
  				$(".infoTab").html("");
  				for(var i=0;i<data.length;i++){
  					$(".infoTab").append("<tr><td rowspan='2'>"+(i+1)+"</td><td width='50px'><span>标题：</span></td>"
							+"<td>"+data[i].title+"</td>"
							+"<td width='80px' align='center' ><span>时间：</span></td>"
							+"<td>"+new Date(data[i].dateInfo).Format("yyyy-MM-dd hh:mm:ss")+"</td>"
							+"</tr><tr><td><span>内容：</span></td>"
						+"<td colspan='3'>"+data[i].contentInfo+"</td>"
							+"</tr><tr height='20px'><td colspan='5' align='right'></td></tr>");
  					
  				}
  			}
  		})
  	}
  	//初始化两个下拉列表
  	for(var i=1;i<=24;i++){
  		$("#OrderTime").html($("#OrderTime").html()+"<option value="+i+">"+i+"</option>");
  	}
  	for(var i=1;i<=24;i++){
  		$("#ContinueTime").html($("#ContinueTime").html()+"<option value="+i+">"+i+"</option>");
  	}
  
  	var $vipName=$(".c");
  	//var $vipPwd=$(".vipPwd");
  	var $vipTel=$(".vipTel");
  	var $OrderTime=$(".OrderTime");
  	var $Money=$(".Money");
  	
  	var $vipTip=$(".vipTip");
  	//var $vipPwdTip=$(".vipPwdTip");
  	var $vipTelTip=$(".vipTelTip");
  	var $timeTip=$(".timeTip");
  	var $MoneyTip=$(".MoneyTip");
  	
  	var telFlag=true;
  	var pwdFlag=true;
  	
  	
  	function validateExitRoom(){
  		$("#exitRoomTip").html("");
  		if($("#ExitRoomId").val()==""){
  			$("#exitRoomTip").html("还未选择退订包厢");
  			return false;
  		}
  		
  		return true;
  	}
  	
  	
  	$(".infoArea").css("display","none");
  	$("#btn_con").click(function(){
 		refreshRoomInfo();	
 		$(".guide").css("background-color","#424A5D");
 		$("#btn_con").css("background-color","darkcyan");
 		$(".emptyRoomDiv").css("display","none");	
 		$(".ExitRoomDiv").css("display","none");
 		$(".regVipArea").css("display","none");		
 		$(".UseRoomDiv").css("display","block");
 		$(".hasUseRoom").css("display","block");
 		$(".infoArea").css("display","none");
 		$(".personal").css("display","none");
 		//$(".total_right").html("");
 	})
 	
 	$("#btn_order").click(function(){
 		refreshRoomInfo(); 	
 		$(".guide").css("background-color","#424A5D");
 		$("#btn_order").css("background-color","darkcyan");
		$(".emptyRoomDiv").css("display","block");
		$(".ExitRoomDiv").css("display","none");
		$(".regVipArea").css("display","none");
		$(".vipPwdDiv").css("display","none");
		$(".infoArea").css("display","none");
		pwdFlag=false;
		$(".commonTel").css("display","block");
		telFlag=true;
		$(".UseRoomDiv").css("display","none");	
		$(".personal").css("display","none");
 	})
 	$("#btn_exit").click(function(){
 		refreshRoomInfo();
 		$(".guide").css("background-color","#424A5D");
 		$("#btn_exit").css("background-color","darkcyan");
 		$(".regVipArea").css("display","none");	
		$(".UseRoomDiv").css("display","none");
		$(".emptyRoomDiv").css("display","none");	
		$(".ExitRoomDiv").css("display","block");
		$(".ExitRoomInfo").css("display","block");
		$(".infoArea").css("display","none");
		$(".personal").css("display","none");
 	})
  	
  	//注册会员
	 $("#regVip").click(function(){
	 	refreshRegVip();
	 	$(".guide").css("background-color","#424A5D");
	 	$("#regVip").css("background-color","darkcyan");
		$(".emptyRoomDiv").css("display","none");	
		$(".hasUseRoom").css("display","none");
		$(".ExitRoomDiv").css("display","none");
		$(".regVipArea").css("display","block");
		$(".UseRoomDiv").css("display","none");	
		$(".infoArea").css("display","none");
		$(".personal").css("display","none");
		var $RegName=$("#RegName");
		$RegName[0].select();		
		refreshRegVip();
		
	  })
	  //商品订单处理
	  $("#btn_foodList").click(function(){
		  refreshRoomInfo();
	  	 $(".guide").css("background-color","#424A5D");
		 $("#btn_foodLiat").css("background-color","darkcyan");
		  window.location.href="foodList.do";
	  })
	//系统消息 
  	$("#btn_backInfo").click(function(){
  		refreshRoomInfo();
  		$(".guide").css("background-color","#424A5D");
	 	$("#btn_backInfo").css("background-color","darkcyan");
	 	$(".emptyRoomDiv").css("display","none");	
		$(".hasUseRoom").css("display","none");
		$(".ExitRoomDiv").css("display","none");
		$(".regVipArea").css("display","none");
		$(".UseRoomDiv").css("display","none");	
		$(".infoArea").css("display","block");
		$(".personal").css("display","none");
  	})
  	//预定时间
  	function validateTime(){
  		$timeTip.html("");
  		if($vipName.val()==""){
  			$vipTip.html("请先填写用户名");
  			$OrderTime.val("0");
			$vipName[0].select();
			return false;
  		}
  		if($OrderTime.val()=="0"){
  			$(".timeTip").html("未选择预订时间");
  			$(".Money").val("");
  			return false;
  		}
  		if($OrderTime.val()!="0"){
  			var time=$(".OrderTime").val();
  			var price=$(".price").html();
  			var discount=$("#hiddenDiscount").val();
  			if(discount==""){
  				discount=1;
  			}
  			$(".Money").val(time*price*discount);
  			return true;
  		}
  		return true;
  	}
  	
  	function validateContinueRoom(){
  		if(!validateConTime()){
  			return false;
  		}
  	}
  	
  	//续费时间
  	
  	function validateConTime(){
  		$("#selRoomTip").html("");
  		$("#timeTip").html("");
  		if($("#ContinueRoom").val()==""){
  			$("#selRoomTip").html("请先选择包厢");
  			$("#ContinueTime").val("0");
			return false;
  		}
  		if($("#ContinueTime").val()=="0"){
  			$("#timeTip").html("未选择预订时间");
  			$("#Money").val("");
  			return false;
  		}
  		if($("#ContinueTime").val()!="0"){
  			var time=$("#ContinueTime").val();
  			var price=$(".price").html();
  			var discount=$("#hiddenDiscount").val();
  			if(discount==""){
  				discount=1;
  			}
  			$("#Money").val(time*price*discount);
  			return true;
  		}
  		return true;
  	}
  	//电话
  	function validateCommonTel(){
  		$vipTelTip.html("");
  		if($vipTel.val()==""){
  			$vipTelTip.html("电话不能为空！");
  			//$vipTel[0].select();
  			return false;
  		}
  		if($vipTel.val()!=""){
  			var rule = /^(\d{3,4}-)?\d{11}$/;
			if(!rule.test($vipTel.val())){
				$vipTelTip.html("电话格式错误！");
				//选中当前文本框的值
				//$vipTel[0].select();
  				return false;
			}else{
				$.ajax({
					type:"post",
					url:"RegTest.do",
					data:{"userTel":$vipTel.val()},
					success:function(data){
						if(data!=""){
							var index=data.indexOf("/");
							var tel=data.substring(0,index);
							var discount=data.substring(index+1);
							$(".vipTip").html("该会员享受"+discount*10+"折优惠");						
							$("#hiddenArea").val(tel);
							$("#hiddenDiscount").val(discount);
							//$(".vipPwdDiv").css("display","block");
							//pwdFlag=true;
							//$(".commonTel").css("display","none");
							
							telFlag=false;
							//$vipPwd[0].select();
						}else{
							//$(".vipPwdDiv").css("display","none");
							//pwdFlag=false;
							
							//$(".commonTel").css("display","block");
							telFlag=true;
							//$vipTel[0].select();
						}
					}
				})
			}
  		}
  		return true;
  	}
  	//密码
  	/* function validateVipPwd(){
  		$vipPwdTip.html("");
  		if($vipName.val()==""){
  			$vipTip.html("请先填写用户名");
			$vipName[0].select();
			return false;
  		}
  		if($vipPwd.val()==""){
  			$vipPwdTip.html("密码不能为空");
  			$vipPwd[0].select();
  			return false;
  		}
  		if($vipPwd.val()!=""){
  			if($vipPwd.val()!=$("#hiddenArea").val()){
  				$vipPwdTip.html("密码错误!!");
  				$vipPwd[0].select();
  				return false;
  			}
  		}
  		return true;
  	} */
  	//电话号码
  	function validateVipTel(){
  		$("#reTelTip").html("");
		if($regTel.val()==""){
			$("#reTelTip").html("请填写电话！");
			$regTel[0].focus();
			return false;
		}
		if($regTel.val()!=""){
  			var rule = /^(\d{3,4}-)?\d{11}$/;
			if(!rule.test($regTel.val())){
				$("#reTelTip").html("电话格式错误！");
				//选中当前文本框的值
				$regTel[0].select();
  				return false;
			}else{
				$.ajax({
					type:"post",
					url:"RegTest.do",
					data:{"userTel":$regTel.val()},
					success:function(data){
						if(data!=""){
							var index=data.indexOf("/");
							var tel=data.substring(0,index);
							var discount=data.substring(index+1);
							$(".vipTip").html("该会员享受"+discount*10+"折优惠");
							
							$("#hiddenArea").val(tel);
							$("#hiddenDiscount").val(discount);
							$(".vipPwdDiv").css("display","block");
							pwdFlag=true;
							$(".commonTel").css("display","none");
							
							telFlag=false;
							//$vipPwd[0].select();
						}else{
							$(".vipPwdDiv").css("display","none");
							pwdFlag=false;
							
							$(".commonTel").css("display","block");
							telFlag=true;
							//$vipTel[0].select();
						}
					}
				})	
			}
			}
  		return true;
  	}	
  	//$(".vipName").blur(validateVipTel);
  	$(".vipTel").blur(validateCommonTel);
  	//$(".vipPwd").blur(validateVipPwd);
  	$(".OrderTime").click(validateTime);
  	
  	$("#ContinueTime").click(validateConTime);
  	function validateRoomInfo(){
  		$(".selRoomTip").html("");
  		$timeTip.html("");
  		if($(".selectedRoom").val()==""){
  			$(".selRoomTip").html("未选择包厢");
  			return false;
  		}
  		
  		if(!(validateTime()&&validateCommonTel())){
  			//return false;
  			return true;
  		}
  		return true;
  	}
  	
  	function refreshRegVip(){
  		$nameTip.html("");
  		$userName.val("");
  		//$pwdTip.html("");
  		$("#reTelTip").html("");
  		//$pwd.val("");
  		$regTel.val("");
  	}
  	function refreshRoomInfo(){
  		$(".selectedRoom").val("");
  		$OrderTime.val("");
  		$vipName.val("");
  		$("#vipTel").val("");
  		//$vipPwd.val("");
  		$vipTel.val("");
  		$Money.val("");
  		$vipTip.html("");
  		//$vipPwdTip.html("");
  		$vipTelTip.html("");
  		$timeTip.html("");
  		$("#timeTip").html("");
  		$MoneyTip.html("");
  		$("#ContinueTime").val("");
  		$("#Money").val("");
  		$(".vipDiscount").html("");
  		$("#ExitRoomId").val("");	
		$("#exitRoomTip").val("");
		$("#startTime").val("");		
		$("#endTime").val("");
		//$("#exitVipName").val("");	
			
		
		$("#exitMoney").val("");		
		$(".ExitVipDiscount").html("");	
		$(".exitMoneyTip").html("");
  	}
  	
 
  	var $userName=$("#RegName");
	//var $pwd = $("#RegPwd");
	var $regTel=$("#RegTel");
	var $nameTip=$("#nameTip");
	//var $pwdTip=$("#pwdTip");
	//var $rePwdTip=$("#rePwdTip");
  
  	
  	function validateName(){
		$nameTip.html("");
		if($userName.val() == ""){
			$nameTip.html("用户名不能为空");
			$userName[0].select();
			return false;
		}
		return true;
	}
  	//密码要求必须要有数字字母
	/* function validatePwd(){
		$pwdTip.html("");
		if($pwd.val() == ""){
			$pwdTip.html("请填写密码");
			$pwd[0].select();
			return false;
		}
		var rule = /^[a-z,A-Z,0-9]{3,}$/;
		if(!rule.test($pwd.val())){
			if($pwd.val().length>16||$pwd.val().length<8){
				$pwdTip.html("密码要在大于3位");			
			}else{
				$pwdTip.html("密码有且只有数字和字母") ;
			}
		
			$pwd[0].select();
			return false;
		}
		return true;
	} */
	
  	function validateReTel(){
		$("#reTelTip").html("");
		if($regTel.val()==""){
			$("#reTelTip").html("请填写电话！");
			$regTel[0].focus();
			return false;
		}
		if($regTel.val()!=""){
  			var rule = /^(\d{3,4}-)?\d{11}$/;
			if(!rule.test($regTel.val())){
				$("#reTelTip").html("电话格式错误！");
				//选中当前文本框的值
				$regTel[0].select();
  				return false;
			}else{
				$.ajax({
					type:"post",
					url:"RegTest.do",
					data:{"userTel":$regTel.val()},
					success:function(data){
						if(data!=""){
							$("#nameTip").html("该用户已是会员！");
						}
					}
				})
			}
  		}		
		return true;
	}
  	$("#RegName").blur(validateName);
  	//$("#RegPwd").blur(validatePwd);
  	$("#RegTel").blur(validateReTel);
  	
  	function validate(){
		//校验所有的验证方法
		if(!validateName() || !validatePwd()||!validateReTel()){		
			return false;
		}
	}
  //初始化
	function init(){
		$("#btn_order").css("background-color","darkcyan");
		$(".roomTypeId:eq(0)").css("background-color","gainsboro");
		$.ajax({
			type:"post",
			url:"EmptyRoom.do",
			data:{"roomTypeId":$(".roomTypeId:eq(0)").attr("id")},
			dataType:"json",
			success:function(data){
				var str="<table border='1' class='roomTab'><tr><td>未开包厢号</td></tr>";
				for(var i=0;i<data.length;i++){
					str+="<tr><td class='roomSelect'>"+data[i].roomId+"</td></tr>";
				}
				$(".roomInfo").html(str+"</table>");
				//点击房间将要触发的事件
				$(".roomSelect").click(function(){
					  var index=$(".roomSelect").index(this);
					  $("#selectedRoom").val($(".roomSelect:eq("+index+")").html());
					  
				})
			}
		})
		$.ajax({
			type:"post",
			url:"price.do",
			data:{"roomTypeId":$(".roomTypeId:eq(0)").attr("id")},
			success:function(data){
				$(".price").html(data);
			}
		})
		$.ajax({
			type:"post",
			url:"HasUseRoom.do",
			data:{"roomTypeId":$(".roomTypeId:eq(0)").attr("id")},
			dataType:"json",
			success:function(data){
				var str="<table border='1' class='roomTab'><tr><td>已开包厢号</td></tr>";
				var strs=str;
				for(var i=0;i<data.length;i++){
					str+="<tr><td class='roomSel'>"+data[i].roomId+"</td></tr>";
					strs+="<tr><td class='ExitroomSel'>"+data[i].roomId+"</td></tr>";
				}
				$(".hasUseRoom").html(str+"</table>");
				
				$(".ExitRoomInfo").html(strs+"</table>");
				//点击房间将要触发的事件
				$(".roomSel").click(function(){
					  var index=$(".roomSel").index(this);
					  $("#ContinueRoom").val($(".roomSel:eq("+index+")").html());	
					  refreshRoomInfo();  
					  $.ajax({
						  	type:"post",
							url:"vipTel.do",
							data:{"roomId":$("#ContinueRoom").val()},
							success:function(data){					
								if(data!=""){
									var index=data.indexOf("/");
									var name=data.substring(0,index);
									var discount=data.substring(index+1);
									
									$("#hiddenDiscount").val(discount);
									if(discount!="1"){
										$(".vipDiscount").html("该会员享受"+discount*10+"折优惠");
									}
									$("#vipTel").val(name);
								}
							}
					  })
				});
				$(".ExitroomSel").click(function(){
					  refreshRoomInfo();
					  var index=$(".ExitroomSel").index(this);
					  $("#ExitRoomId").val($(".ExitroomSel:eq("+index+")").html());		  
					  $.ajax({
						  	type:"post",
							url:"exitRoom.do",
							data:{"roomId":$("#ExitRoomId").val()},
							dataType:"json",
							success:function(data){	
									$("#startTime").val(data.startTime);		
									$("#endTime").val(data.endTime);
									
									var discount=data.discount;
									
									var price=$(".price").html();
									
									$("#exitMoney").val(parseInt(data.overTime.toFixed(2)*discount*price));		
		
									if(discount!="1"){
										$(".ExitVipDiscount").html("该会员享受"+discount.toFixed(2)*10+"折优惠");
									}			
									$("#exitVipTel").val(data.vipTel);
								
							}
					  })
				})
				
			}
		})
	}
	
	init();	
	//鼠标进入包厢类型触发事件
   	$(".roomTypeId").click(function(){
  		refreshRoomInfo();
   		var index=$(".roomTypeId").index(this);
   		$(".roomTypeId").css("background-color","#F6F6F6");
   		$(".roomTypeId:eq("+index+")").css("background-color","gainsboro");
   		$.ajax({
			type:"post",
			url:"EmptyRoom.do",
			data:{"roomTypeId":$(".roomTypeId:eq("+index+")").attr("id")},
			dataType:"json",
			success:function(data){
				var str="<table border='1' class='roomTab'><tr><td>未开包厢号</td></tr>";
				for(var i=0;i<data.length;i++){
					str+="<tr><td class='roomSelect'>"+data[i].roomId+"</td></tr>";
				}
				$(".roomInfo").html(str+"</table>");
				//点击房间将要触发的事件
				  $(".roomSelect").click(function(){
					  var index=$(".roomSelect").index(this);
					  $("#selectedRoom").val($(".roomSelect:eq("+index+")").html());
				  })
			}
		})
		$.ajax({
			type:"post",
			url:"price.do",
			data:{"roomTypeId":$(".roomTypeId:eq("+index+")").attr("id")},
			success:function(data){
				$(".price").html(data);
			}
		})
		$.ajax({
			type:"post",
			url:"HasUseRoom.do",
			dataType:"json",
			data:{"roomTypeId":$(".roomTypeId:eq("+index+")").attr("id")},
			success:function(data){
			var str="<table border='1' class='roomTab'><tr><td>已开包厢号</td></tr>";
				var strs=str;
				for(var i=0;i<data.length;i++){
					str+="<tr><td class='roomSel'>"+data[i].roomId+"</td></tr>";
					strs+="<tr><td class='ExitroomSel'>"+data[i].roomId+"</td></tr>";
				}
				$(".hasUseRoom").html(str+"</table>");
				
				$(".ExitRoomInfo").html(strs+"</table>");
				//点击房间将要触发的事件
				$(".roomSel").click(function(){
					  var index=$(".roomSel").index(this);
					  $("#ContinueRoom").val($(".roomSel:eq("+index+")").html());	
					  refreshRoomInfo();  
					  $.ajax({
						  	type:"post",
							url:"vipTel.do",
							data:{"roomId":$("#ContinueRoom").val()},
							success:function(data){					
								if(data!=""){
									var index=data.indexOf("/");
									var name=data.substring(0,index);
									var discount=data.substring(index+1);						
									$("#hiddenDiscount").val(discount);
									if(discount!="1"){
										$(".vipDiscount").html("该会员享受"+discount*10+"折优惠");
									}
									$("#vipTel").val(name);
								}
							}
					  })
				});
				$(".ExitroomSel").click(function(){
					  refreshRoomInfo();
					  var index=$(".ExitroomSel").index(this);
					  $("#ExitRoomId").val($(".ExitroomSel:eq("+index+")").html());		  
					  $.ajax({
						  	type:"post",
							url:"exitRoom.do",
							data:{"roomId":$("#ExitRoomId").val()},
							dataType:"json",
							success:function(data){	
									$("#startTime").val(data.startTime);		
									$("#endTime").val(data.endTime);
									var myDate = new Date();
									var date2=myDate.toLocaleDateString();
									var day2=date2.substring(date2.lastIndexOf("/")+1);
									if(day2<10){
										day2="0"+day2;
									}
									if(data.endTime.substring(data.endTime.lastIndexOf("-")+1,data.endTime.lastIndexOf(" "))>day2){
										$("#exitMoney").val("0");
										return;
									}
									var discount=data.discount;
									
									var price=$(".price").html();
									
									$("#exitMoney").val(parseInt(data.overTime*discount.toFixed(2)*price));		
		
									if(discount!="1"){
										$(".ExitVipDiscount").html("该会员享受"+discount.toFixed(2)*10+"折优惠");
									}			
									$("#exitVipTel").val(data.vipTel);
								
							}
					  })
				})
			}
		})
  })
  
</script>	
</html>
