<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<link rel="stylesheet" type="text/css" href="css/openRoom.css">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
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
		.total_right{
		display:inline-block;
		margin-left:520px;
		margin-top:10px;
		color:red;
		font-size:20px;
		font-family:"楷体";
		text-align: right;
		
	}
	.container{
		width: 940px;
		height: 580px;
		text-align: center;
		background-image: url("images/bg.png");
		background-size:cover;
		overflow: hidden;
		margin:auto;
	}
  </style>
<body>
<div class="total">
 	<div class="total_left"><span class="glyphicon glyphicon-pushpin"></span>消息中心</div>
 	<div class="total_right">&nbsp;&nbsp;&nbsp;${RegSuccess }</div>
</div>
<div class="container">
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

window.onload=function(){
	getInfo();
	window.setInterval("getInfo()",5000);
	}	
	function getInfo(){
		$.ajax({
			type:"post",
			url:"getInfo.do",
			dataType:"json",
			data:{"flag":0},
			success:function(data){
				$("#infoCount").html("+"+data.length);
				$(".infoTab").html("");
				for(var i=0;i<data.length;i++){
					$(".infoTab").append("<tr><td rowspan='2'>"+(i+1)+"</td><td width='80px'><span>标题：</span></td>"
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
</script>
</html>