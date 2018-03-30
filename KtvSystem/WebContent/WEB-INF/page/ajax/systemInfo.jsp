<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<title>Insert title here</title>
<link rel="stylesheet" href="fontAwesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/richEditor.css">
</head>
<style>
*{
		-webkit-box-sizing:border-box;
			box-sizing:border-box;
			outline:none;
		}
		/* body{
			margin:0;
			padding:0;
			font-family:'microsoft yahei';
		}
		html,body{
			height:100%;
		} */		
		/* #editor{
			margin:30px auto;
		} */
	table{
		font-size:18px;
			
	}
</style>
<body>
 <div class="header">     
      <h1 class="page-title">通知中心</h1>
 </div>
 <br>
<div class="container-fluid">
<div class="well">
    <table class="table">
    <thead>
    	<tr>
    		<th style="width:150px"><i class="icon-envelope" style="color:gray;font-size:20px"></i>&nbsp;&nbsp;通知发送</th>
    	</tr>
    </thead>
      <tbody>
        <tr>
         <td style="width:100px">通知标题:</td><td><input type="text" style="width:300px;height:30px" placeholder="输入标题。。。" id="titleContent"></td>
          </tr>
          <tr> 
          <td style="width:100px">发送方式：</td><td><input type="radio" class="sendWay" name="sendWay" value="群发" checked="checked">群发&nbsp;&nbsp;&nbsp;<input type="radio" name="sendWay" class="sendWay" value="单发">单发</td>
          </tr>
          <tr> 
          <td class="send" style="width:100px">发送角色：</td>
          <td><input type='radio' value='0' name="send_role">VIP顾客&nbsp;&nbsp;<input type='radio' value='1' name="send_role">服务员&nbsp;&nbsp;<input type='radio' value='2' name="send_role">前台人员</td>
          </tr>
          <tr> 
          <td style="width:100px">通知内容:</td>
          <td></td>
          </tr>    
          <tr> 
          <td colspan="2" align="left">
          	<div id="editor">
			<p>请编写内容...</p>
			</div>
          </td>
          </tr>         
      </tbody>
    </table>
    <div class="btn-toolbar" style="margin-left:520px;">
		<button class="btn btn-primary" id="sendInfo_btn">
			<i class="icon-hand-right"></i> 发送
		</button>
		<div class="btn-group"></div>
	</div>
</div>
</div>
<script src="js/richEditor.min.js"></script>
</body>
<script type="text/javascript">
var val;
$(".send").next().find("input").click(function(){
	val=$('input:radio[name="send_role"]:checked').val();
})
	$(".sendWay").click(function(){
		if($(this).val()=="群发"){
			$(".send").html("发送角色：");
			$(".send").next().html("<input type='radio' value='0' name='send_role'>VIP顾客&nbsp;&nbsp;<input type='radio' value='1' name='send_role'>服务员&nbsp;&nbsp;<input type='radio' value='2' name='send_role'>前台人员");
			$(".send").next().find("input").click(function(){
				val=$('input:radio[name="send_role"]:checked').val();
			})
		}else{
			$(".send").html("联系电话：");
			$(".send").next().html("<input type='text' placeholder='输入电话。。。' style='width:300px;height:30px' id='relativeTel'><span><span>");
			$("#relativeTel").blur(function(){
				$.ajax({
					type:"post",
					url:"testRelativeTel.do",
					data:{"relativeTel":$("#relativeTel").val()},
					success:function(data){
						$(".send").next().find("span").css("color","red");
						$(".send").next().find("span").html("");
						$(".send").next().find("span").html(data);
					}
				})
			})
		}
	})
	
	var editor = new RichEditor("#editor", {
		width:600,
		height:300,
		toolBg:"#F6F6F6",
		buttons: {
				heading:{
					title:"标题",
					icon:"\uf1dc"
				},
				code: {
					title: "引用",
					icon: "\uf10d"
				},
				bold: {
					title: "加粗",
					icon: "\uf032"
				},
				italic: {
					title: "斜体",
					icon: "\uf033"
				},
				underline: {
					title: "下划线",
					icon: "\uf0cd"
				},
				strikethrough: {
					title: "删除线",
					icon: "\uf0cc"
				},
				foreColor: {
					title: "字体颜色",
					icon: "\uf1fc"
				},
				backColor: {
					title: "背景色",
					icon: "\uf043"
				},
				justifyLeft: {
					title: "居左",
					icon: "\uf036"
				},
				justifyCenter: {
					title: "居中",
					icon: "\uf037"
				},
				justifyRight: {
					title: "居右",
					icon: "\uf038"
				},
				justifyFull: {
					title: "两端对齐",
					icon: "\uf039"
				},
				insertOrderedList: {
					title: "有序列表",
					icon: "\uf0cb"
				},
				insertUnorderedList: {
					title: "无序列表",
					icon: "\uf0ca"
				},
				indent:{
					title:"indent",
					icon:"\uf03c"
				},
				outdent:{
					title:"outdent",
					icon:"\uf03b"
				},
				createLink: {
					title: "链接",
					icon: "\uf0c1"
				},
				insertImage: {
					title: "插入图片",
					icon: "\uf03e"
				},
				emotion: {
					title: "表情",
					icon: "\uf118"
				},
				fullscreen: {
					title: "全屏",
					icon: "\uf066"
				},
				save: {
					title: "保存",
					icon: "\uf0c7",
					click:function(){						
						
					}
				}
			}
	});
	
	//editor.getHTML()
	var relative;
	$("#sendInfo_btn").click(function(){
		if($('input:radio[name="sendWay"]:checked').val()=="群发"){
			relative=val;
		}else{
			relative=$("#relativeTel").val();
		}
		$.ajax({
			type:"post",
			url:"addSystemInfo.do",
			data:{"titleContent":$("#titleContent").val(),"relative":relative,"content":editor.getHTML()},
			success:function(data){				
					alert("发送成功！");
					systemInfo();				
			}
		})
	})
</script>
</html>