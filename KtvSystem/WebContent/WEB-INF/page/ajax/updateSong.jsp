<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="btn-toolbar">
				<button class="btn btn-primary" id="updateBtn">
					<i class="icon-pencil"></i> 更新
				</button>
				<a href="#myModal" data-toggle="modal" class="btn">取消</a>
				<div class="btn-group"></div>
			</div>
			<div class="well">
				<div id="myTabContent" class="tab-content" style="height:550px;">
					<div class="tab-pane active in" id="home" >
						<form id="tab" action="updateSongInfo.do" method="post">
							<label>歌名</label>
							<input type="hidden" value="${song.songId }" name="songId" id="songId">
							<input type="text" value="${song.songName }" class="input-xlarge" name="songName"> 
							<label>语种</label>
							<input type="text" value="${song.songLanguage }" class="input-xlarge" name="songLanguage"> 
							<label>歌手</label>
							<input type="text" value="${song.songSinger }" class="input-xlarge" name="songSinger"> 
							<label>歌曲时长</label>
							<input type="text" value="<fmt:formatDate value='${song.songTime }' pattern="mm:ss"/>" class="input-xlarge" name="songTime">
						 </form>
							<label>歌曲风格</label>
							<div id="styleLabel">																
							<c:forEach var="songStyle" items="${styleList }">								
								   <div class="alert alert-error" style="width:80px;height:20px;float:left;margin-left:10px;">
								        <button type="button" class="close" data-dismiss="alert" >×</button>
								         <span value="${songStyle.styleTypeId }">${songStyle.styleTypeName }</span>
								   </div>
							</c:forEach>
							</div>						
							<div class="btn-group" style="clear:both;">
							  <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							    请选择歌曲风格
							    <span class="caret"></span>
							  </a>
							  <ul class="dropdown-menu">
							    <c:forEach var="songStyle" items="${allStyleList }">
							    	 <li><a href="javascript:getStyleName(${songStyle.styleTypeId },'${songStyle.styleTypeName }')">${songStyle.styleTypeName }</a></li>
							    </c:forEach>							     				                  
							  </ul>
							</div>							
						
					</div>
					<div class="modal small hide fade" id="myModal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">取消提示信息</h3>
						</div>
						<div class="modal-body">
							<p class="error-text">
								<i class="icon-warning-sign modal-icon"></i>确定要取消更新吗？
							</p>
						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
							<button class="btn btn-danger" data-dismiss="modal" id="cancel_updateBtn">确定</button>
						</div>
					</div>
				</div>
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
	</div>
</body>
<script type="text/javascript">	
	//添加风格标签
	function getStyleName(styleTypeId,styleTypeName){		
		var length=$("#styleLabel>div").length;
		for(var i=0;i<length;i++){
			if($($("#styleLabel>div").get(i)).find("span").html()==styleTypeName){								
				alert("已添加该风格！");
				return;				
			}
		}
		$("#styleLabel").append("<div class='alert alert-error' style='width:80px;height:20px;float:left;margin-left:10px;'>"
		        +"<button type='button' class='close' data-dismiss='alert' >×</button> <span value="+styleTypeId+">"+styleTypeName
		        +"</span></div>");
	}
	//提交表单内容
	$("#updateBtn").click(function(){
		var length=$("#tab>input").length;
		for(var i=0;i<length;i++){
			if($($("#tab>input").get(i)).val()==""){
				alert($($("#tab>input").get(i)).prev().html()+"内容不为空！");
				return;
			}
		}		
		$("#tab").submit();
		var length=$("#styleLabel>div").length;
		if(length==0){
			$.ajax({
				type:"post",
				url:"deleteSongToType.do",
				data:{"songId":$("#songId").val()},
				success:function(data){
					alert("更新歌曲成功！");
				}
			})
		}else{
			for(var i=0;i<length;i++){
				$.ajax({
					type:"post",
					url:"updateStyle.do",
					data:{"songId":$("#songId").val(),"styleId":$($("#styleLabel>div").get(i)).find("span").attr("value")},
					success:function(data){
						alert("更新歌曲成功！");
					}
				})
			}	
		}	
	})
	$("#cancel_updateBtn").click(function(){
		selLanguage('全部',1);
	})
</script>
</html>