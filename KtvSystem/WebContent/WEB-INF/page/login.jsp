<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录中心</title>
<link href="images/xiao2.ico" rel="shortcut icon">
</head>
<link href="bootstrap-3.3.7-dist/css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="css/login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<body background="images/login_bg.jpg">
	<div class="login_content">
	<form action="login_validate.do" method="post" id="login_form">
		<table class="login_tab" >
			<tr height="100px" >
				<td align="center" colspan="2">登录</td>
			</tr>
			<!-- 用户名 -->
			<tr height="40px">
				<td align="center" colspan="2">
					<div class="input-group">
						<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></span>
						<input id="userName" name="userName" type="text" class="form-control" placeholder="用户名" aria-describedby="sizing-addon2">
					</div>
				</td>
			</tr>
			<!-- 用户名的错误信息提示 -->
			<tr height="30px">
				<td colspan="2" align="center" id="userName_error"></td>
			</tr>
			<!-- 密码-->
			<tr height="40px">
				<td colspan="2" align="center">
					<div class="input-group">
						<span class="input-group-addon" id="sizing-addon2"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></span>
						<input id="pwd" name="pwd" type="password" class="form-control" placeholder="密码" aria-describedby="sizing-addon2">
					</div>
				</td>
			</tr>
			<!-- 密码错误提示 -->
			<tr height="30px">
				<td colspan="2" align="center" id="pwd_error">${pwdError }</td>
			</tr>
			<!-- 验证码 -->
			<tr>
				<td align="right"><input type="text" id="code_input" class="form-control" placeholder="验证码输入" aria-describedby="sizing-addon2" style="width:100px"></td>
				<td align="center">				
				<div id="v_container" style="width: 120px;height: 40px;"></div>
				</td>
			</tr>
			<!-- 验证码错误提示信息 -->
			<tr height="30px">
				<td align="right" id="code_error"></td>
				<td></td>
			</tr>
			<!-- <tr height="30px">
				<td align="center" colspan="2">
					<input type="radio">
				</td>
			</tr> -->
			<!-- 登录按钮 -->
			<tr height="30px">
				<td align="center" colspan="2"><a id="login_btn" class="btn btn-primary btn-lg" href="javascript:validate()" role="button" style="width:200px;">登录</a></td>
			</tr>
		</table>
	</form>
	</div>
<script src="js/gVerify.js"></script>	
</body>
<script>
	//验证码的校验
	var codeFlag=false;
	var verifyCode = new GVerify("v_container");
	$("*[id$=error]").css("color","red");
	$("#code_input").blur(function(){
		var res = verifyCode.validate(document.getElementById("code_input").value);
		if(res){
			codeFlag=true;
		}else{
			codeFlag=false;
			$("#code_error").html("验证码错误！");
		}
	})
	$("#code_input").focus(function(){
		$(this).val("");
		$("#code_error").html("");
	})
	//用户名的校验
	var nameFlag=false;
	$("#userName").focus();
	$("#userName").blur(function(){
		if($("#userName").val()!=""){
			$.ajax({
				type:"post",
				url:"validate_userName.do",
				data:{"userName":$("#userName").val()},
				success:function(data){
					if(data==""){
						nameFlag=true;						
					}else{
						nameFlag=false;
						$("#userName_error").html(data);
					}
				}
			})
		}else{
			nameFlag=false;
			$("#userName_error").html("用户名不为空!");
		}
	})
	$("#userName").focus(function(){
		$("#userName_error").html("");
	})
	//密码校验
	var pwdFlag=false;
	$("#pwd").blur(function(){
		if($("#pwd").val()!=""){
			pwdFlag=true;
		}else{
			pwdFlag=false;
			$("#pwd_error").html("密码不为空！");
		}
	})
	$("#pwd").focus(function(){
		$("#pwd_error").html("");
	})
	//提交表单
	function validate(){
		if(codeFlag&&nameFlag&&pwdFlag){
			$("#login_form").submit();			
		}
		else{
			alert("登录失败！");
		}
	}
</script>
</html>