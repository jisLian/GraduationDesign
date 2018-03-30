<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
</head>
<body>
<table style="margin-left:250px;margin-top:150px">
	<tr height="50px"><th style="color:brown;font-size:20px" colspan="2" align="center">修改密码</th></tr>
	<tr height="30px"><td>原密码：</td>
	<td><input type="password" id="oldPwd" index="${loginUser.vipId }"></td>
	<td style="color:red" id="error_pwd"></td></tr>
	<tr><td>新密码：</td><td><input type="password" id="newPwd" index="${loginUser.vipId }"></td></tr>
</table>

</body>
<script type="text/javascript">
	$("#oldPwd").blur(function(){
		$.ajax({
			type:"post",
			url:"queryPwd.do",
			data:{"vipId":$("#oldPwd").attr("index"),"pwd":$("#oldPwd").val()},
			success:function(data){
				$("#error_pwd").html(data);
				if(data==""){
					$("#newPwd").blur(function(){
						$.ajax({
							type:"post",
							url:"updateNewPwd.do",
							data:{"vipId":$("#newPwd").attr("index"),"pwd":$("#newPwd").val()},
							success:function(data){
								$("#newPwd").val("");
								$("#oldPwd").val("");
								$("#error_pwd").html(data);
							}
						})
					})
				}
			}
		})
	})
	
</script>
</html>