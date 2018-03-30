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
<style>
	.searchDiv{
		width:282px;
		height:100px;
		border:1px solid #CCCCCC;
		float: right; 
		position: relative;
		top: -16px; 
		left: 194px;
		background-color:white;
		display:none;
		overflow:auto;
	}
	.searchDiv li{
		list-style-type: none;
		text-indent: 2px;
	}
	.searchDiv li>a:hover{
		color:red;
	}
</style>
<body>
<div class="header">
			<h1 class="page-title">曲库管理</h1>
			<div class="search-well">
				<form class="form-inline"
					style="float: right; position: relative; top: -60px; left: -90px">
					<input class="input-xlarge" placeholder="Search Music..."
						id="appendedInputButton" type="text">
					<button class="btn" type="button">
						<i class="icon-search"></i> Go
					</button>
				</form>
			</div>
			<div class="searchDiv">	
							
			</div>
		</div>
		<ul class="breadcrumb">
			<li><a class="active">语种筛选</a><span class="divider">：</span></li>
            <li>&nbsp;&nbsp;&nbsp;<a href="javascript:selLanguage('全部',1)">全部</a></li>  
             <c:forEach var="language" items="${languageList }" varStatus="status">
				<li>&nbsp;&nbsp;&nbsp;<a href="javascript:selLanguage('${language.language }',1)">${language.language }</a></li>
             </c:forEach>        
     	</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary" id="addSongBtn">
						<i class="icon-plus"></i> 添加歌曲
					</button>
					<div class="btn-group"></div>
				</div>
				<div class="well">
					<table class="table">  
						<thead>
							<tr>
								<th>编号</th>
								<th>歌名</th>
								<th>时长</th>
								<th>歌手</th>
								<th>语种</th>
								<th>发布日期</th>
								<th >播放</th>
								<th>编辑</th>
								<th>删除</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="song" items="${songList }" varStatus="status">
							<tr>
								<td>${song.songId }</td>
								<td>${song.songName }</td>
								<td><fmt:formatDate value="${song.songTime }" pattern="mm:ss"/></td>
								<td>${song.songSinger }</td>
								<td>${song.songLanguage }</td>
								<td><fmt:formatDate value="${song.songPublishTime }" pattern="yyyy-MM-dd"/></td>
								<td><a href="javascript:getsongPath('${song.songPath }')"><i class="icon-play-circle"></i></a></td>
								<td><a href="javascript:updateSong(${song.songId })"><i class="icon-pencil"></i></a></td>
								<td><a href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove" onClick="getDeleteId(${song.songId })"></i></a></td>
							</tr>	
						</c:forEach>																			
						</tbody>
					</table>
				</div>
				<c:if test="${sumPage!=1 }">
				<div class="pagination">
					<ul>
						<c:choose>
							<c:when test="${currentPage==1 }">
								<li><a href="javascript:selLanguage('${language }',1)">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:selLanguage('${language }',${currentPage-1 })">上一页</a></li>
							</c:otherwise>
						</c:choose>
						 <c:forEach varStatus="i" begin="1" end="${sumPage}">
						 	<li class=""><a href="javascript:selLanguage('${language }',${i.count})">${i.count}</a></li>
						 </c:forEach>						
						<c:choose>
							<c:when test="${sumPage==currentPage }">
								<li><a href="javascript:selLanguage('${language }',${currentPage})">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:selLanguage('${language }',${currentPage+1 })">下一页</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				</c:if>
				<div class="modal small hide fade" id="myModal" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h3 id="myModalLabel">删除提示信息</h3>
					</div>
					<div class="modal-body">
						<p class="error-text">
							<i class="icon-warning-sign modal-icon"></i>确定要删除该歌曲吗?
						</p>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-danger" data-dismiss="modal" id="deletBtn">删除</button>
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
	//搜索框键盘按键松开事件
	$("#appendedInputButton").keyup(function(){
		if($("#appendedInputButton").val()!=""){
			$(".searchDiv").css("display","block");
			$.ajax({
				type:"post",
				url:"searchMusic.do",
				dataType:"json",
				data:{"input":$(this).val()},
				success:function(data){
					$(".searchDiv").html("");					
					for(var i=0;i<data.length;i++){
						$(".searchDiv").append("<li><a class='songIndex' style='cursor:pointer' songName='"+data[i].songName+"'>"+data[i].songName+"&nbsp;&nbsp;&nbsp;--&nbsp;&nbsp;&nbsp;"+data[i].songSinger+"</a></li>");
					}
					//点击查询歌曲详细信息（歌名匹配）
					$(".songIndex").click(function(){
						$(".searchDiv").css("display","none");
						$("#appendedInputButton").val("");
						searchResult($(this).attr("songName"));
					})
				}
			})
		}else{
			$(".searchDiv").css("display","none");
		}		
	})	
	//根据歌名搜索结果显示函数
	function searchResult(searchContent){
			$.ajax({
				type:"post",
				url:"searchByName.do",
				data:{"songName":searchContent},
				success:function(data){
					$(".row-fluid").html(data);
				}
			})
		}
	
	//搜索按钮点击事件（模糊匹配）
	$(".btn").click(function(){
		 searchInput($("#appendedInputButton").val(),1);
	})
	function searchInput(searchContent,pageCode){
			$.ajax({
				type:"post",
				url:"searchInput.do",
				data:{"searchInput":searchContent,"pageCode":pageCode},
				success:function(data){					
					$(".row-fluid").html(data);
					$(".searchDiv").css("display","none");
					$("#appendedInputButton").val("");
					var len=$(".pagination ul > li>a").length;
					for(var i=1;i<len-1;i++){
						if($(".pagination ul > li>a:eq("+i+")").html()==pageCode){
							$(".pagination ul > li>a:eq("+i+")").parent().attr("class","active");
						}
					}
				}
			})
		}
	//点击删除按钮事件
	function getDeleteId(songId){
		$("#deletBtn").click(function(){
			$.ajax({
				type:"post",
				data:{"songId":songId},
				url:"deleteSong.do",
				success:function(data){
					selLanguage('全部',1);
				}
			})			
		})
	}
	 //修改歌曲信息
	 function updateSong(songId){
		 $.ajax({
			 type:"post",
			 data:{"songId":songId},
			 url:"updateSong.do",
			 success:function(data){
				 $(".container-fluid").html(data);
			 }
		 })
	 }
	 //获取歌曲路径
	 function getsongPath(songPath){
		 $.ajax({
			 type:"post",
			 data:{"songPath":songPath},
			 url:"playSong.do",
			 success:function(data){
				 $(".container-fluid").html(data);
			 }
		 })
	 }
	 //添加歌曲
	 $("#addSongBtn").click(function(){
		 $.ajax({
			 type:"post",
			 url:"addSong.do",
			 success:function(data){
				 $(".container-fluid").html(data);
			 }
		 })
	 })
	 
</script>
</html>