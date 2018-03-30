<%@page import="com.jis.util.Token"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="btn-toolbar">
	<button class="btn btn-primary" id="updateBtn">
		<i class="icon-plus"></i> 添加歌曲
	</button>
	<a href="javascript:selLanguage('全部',1)" data-toggle="modal" class="btn">取消</a>
	<div class="btn-group"></div>
</div>
<form id="addSongForm"  action="addSongInfo.do" method="post"> 
	<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
	<div class="layui-form-item">
		<div class="layui-input-block">
			<input type="text" name="songName" lay-verify="title" autocomplete="off" placeholder="请输入歌名" class="layui-input">
		</div>
	</div>	
	<div class="layui-form-item">
		<div class="layui-input-block">
			<input type="text" name="songSinger" lay-verify="title" autocomplete="off" placeholder="请输入歌手" class="layui-input">
		</div>
	</div>	
	<div class="layui-input-inline">
		<select name="language">
			<option value="" selected="">请选择语种</option>
			<c:forEach var="language" items="${languageList }" varStatus="status">
				<option value="${language.language }" >${language.language }</option>
             </c:forEach>
		</select>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">歌曲时长:</label>
		<div class="layui-input-block">			
			<input type="time" name="songTime" lay-verify="title" autocomplete="off" placeholder="请输入时长" class="layui-input" id="songTime">
		</div>
	</div>
	<div class="layui-inline">
		<label class="layui-form-label">歌曲发布日期:</label>
		<div class="layui-input-block">
			<input type="date" name="pblishDate" id="date" lay-verify="date" placeholder="yyyy-mm-dd" autocomplete="off" class="layui-input" >
		</div>
	</div>	
	<input type="hidden" value="" name="songPath" id="songPath">
	<div class="layui-form-item">
		<label class="layui-form-label">歌曲风格:</label>	
		 <c:forEach var="songStyle" items="${allStyleList }">			
		<input type="checkbox" name="songStyle" value="${songStyle.styleTypeId }">${songStyle.styleTypeName }&nbsp;&nbsp;&nbsp;&nbsp;
		</c:forEach>			
	</div> 
	</form>
<form id="addSongForm"  action="uploadSong.do" method="post"  enctype="multipart/form-data" > 
	<label class="layui-form-label">歌曲上传:</label>	
	<input type="file" id="file1" class="subHeadPic" name="song"/>
</form>
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
<script src="js/ajaxfileupload.js" type="text/javascript"></script> 
</body>
<script type="text/javascript">
	$("#updateBtn").click(function(){
		 $("#songPath").attr("value",($(".subHeadPic").val()).substring(($(".subHeadPic").val()).lastIndexOf("\\")+1));
		for(var i=0;i<$("#songInfo").find("input").size();i++){
			if($($("#songInfo").find("input").get(i)).val()==""){
				alert("内容不能为空！");
				return;
			}
		}
		$("#addSongForm").submit();
	})
	$("#file1").change(function(){
		imageUpload();
	})
	function imageUpload(){
        $.ajaxFileUpload({
            url : 'uploadSong.do', //用于文件上传的服务器端请求地址
            fileElementId : 'file1', //文件上传空间的id属性  <input type="file" id="file" name="file" />
            type : 'post',
            dataType : 'text', //返回值类型 一般设置为json
            success : function(data, status) //服务器成功响应处理函数
            {
                alert("歌曲上传成功");
               
            },
            error : function(data, status, e)//服务器响应失败处理函数
            {
                alert("歌曲上传失败");
                
            }
        });
    }
</script>
</html>