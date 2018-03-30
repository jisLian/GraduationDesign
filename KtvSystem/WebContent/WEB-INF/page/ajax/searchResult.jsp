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
<body>
<div class="container-fluid">
			<div class="row-fluid">
				<div class="btn-toolbar">
					<button class="btn btn-primary">
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
								<td><a href="#"><i class="icon-play-circle"></i></a></td>
								<td><a href="#"><i class="icon-pencil"></i></a></td>
								<td><a href="#myModal" role="button" data-toggle="modal"><i
										class="icon-remove"></i></a></td>
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
								<li><a href="javascript:searchInput('${searchInput }',1)">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:searchInput('${searchInput }',${currentPage-1 })">上一页</a></li>
							</c:otherwise>
						</c:choose>
						 <c:forEach varStatus="i" begin="1" end="${sumPage}">
						 	<li class=""><a href="javascript:searchInput('${searchInput }',${i.count})">${i.count}</a></li>
						 </c:forEach>						
						<c:choose>
							<c:when test="${sumPage==currentPage }">
								<li><a href="javascript:searchInput('${searchInput }',${currentPage})">下一页</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:searchInput('${searchInput }',${currentPage+1 })">下一页</a></li>
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
						<button class="btn btn-danger" data-dismiss="modal">删除</button>
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
</script>
</html>