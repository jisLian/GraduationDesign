<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
  <script type="text/javascript" src="js/jquery-1.8.0.js"></script>
</head>
<style>
	tr:hover{
		background-color: lightgray;
	}
	.infoTab{
		font-size:15px;	
		border-collapse: collapse;
		width:600px;
		
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
<div style="width:900px;height:500px;margin:auto;background-color: lightgrey;">
 <div class="header">     
      <h1 class="page-title">个人中心</h1>
 </div>
  <ul class="breadcrumb">
        <li><a href="Javascript:back(${loginUser.empFlag})">返回</a> <span class="divider">/</span></li>
         <li><a href="Javascript:per()">个人信息</a> <span class="divider">/</span></li>
        <li><a href="Javascript:info()">消息&nbsp;&nbsp;<span class="label label-info" id="infoCount">+0</span></a></li>
   		
   </ul>
<div class="well">
    <table class="table">
      <tbody>
        <tr>
          <td width="100px">编号:</td><td>${loginUser.empId }</td>
          </tr>
          <tr> 
          <td>姓名:</td><td>${loginUser.empName }</td>
          </tr>
          <tr> 
          <td>性别:</td><td>${loginUser.empSex==0?'男':'女' }</td>
          </tr> 
          <tr>
          <td>电话:</td><td class="telClass">${loginUser.empTel }</td>
          </tr>
          <tr> 
          <td>身份:</td><td>${loginUser.empFlag==0?'服务员':loginUser.empFlag==2?'管理员':'前台人员' }</td>
          </tr>
          <tr> 
          <td>生日:</td><td><fmt:formatDate value="${loginUser.birthday }" pattern="yyyy-MM-dd"/></td>
          </tr> 
          <tr>
          <td>入职日期:</td><td><fmt:formatDate value="${loginUser.hire_date }" pattern="yyyy-MM-dd"/></td>
           </tr>
          <tr>
          <td>住址:</td><td>${loginUser.empAddress  }</td>
        </tr>        
      </tbody>
    </table>
	</div>
<div class="infoArea">
	<table class="infoTab" border="1">
		
	</table>
</div>
</div>
</body>
<script type="text/javascript">
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

	function back(empFlag){
		if(empFlag==0){
			window.location.href="intoWaiter.do";
		}else if(empFlag==1){
			window.location.href="showRoom.do";
		}
	}
	window.onload=function(){
		getInfo();
		$(".infoTab").css("display","none");		
		window.setInterval("getInfo()",5000);
		
	}
	function per(){
		$(".well").css("display","block");
		$(".infoTab").css("display","none");
	}
	function info(){
		$(".well").css("display","none");
		$(".infoTab").css("display","block");
	}
	function getInfo(){
  		$.ajax({
  			type:"post",
  			url:"getInfoByTel.do",
  			dataType:"json",
  			data:{"tel":$(".telClass").html()},
  			success:function(data){ 				
  				if(data==null){
  					return;
  				}
  				$("#infoCount").html("+"+data.length);
  				$(".infoTab").html("");
  				for(var i=0;i<data.length;i++){
  					$(".infoTab").append("<tr><td rowspan='2'>"+(i+1)+"</td><td style='width:80px'><span>标题：</span></td>"
							+"<td style='width:200px'>"+data[i].title+"</td>"
							+"<td width='80px' align='center' style='width:100px'><span>时间：</span></td>"
							+"<td style='width:200px'>"+new Date(data[i].dateInfo).Format("yyyy-MM-dd hh:mm:ss")+"</td>"
							+"</tr><tr><td><span>内容：</span></td>"
						+"<td colspan='3'>"+data[i].contentInfo+"</td>"
							+"</tr><tr height='20px'><td colspan='5' align='right'></td></tr>");
  				}
  			}
  		})
  	}
</script>
</html>