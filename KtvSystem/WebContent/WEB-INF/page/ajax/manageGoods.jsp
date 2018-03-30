<%@page import="com.jis.util.Token"%>
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
<body bg-color="#EAEAEA">
<div class="header">
	<h1 class="page-title">商品管理</h1>
	<div class="search-well">
		<form class="form-inline"
			style="float: right; position: relative; top: -60px; left: -90px">
			<input class="input-xlarge" placeholder="Search Goods..."
				id="appendedInputButton" type="text">
			<button class="btn" type="button" id="btn_seachGoods">
				<i class="icon-search"></i> Go
			</button>
		</form>
	</div>
</div>
<ul class="breadcrumb">
<li><a class="active">类别筛选</a><span class="divider">：</span></li>
         <li>&nbsp;&nbsp;&nbsp;<a href="javascript:manageGoods(0,1)">全部</a></li>  
          <c:forEach var="goodType" items="${goodTypeList }" varStatus="status">
	<li>&nbsp;&nbsp;&nbsp;<a href="javascript:manageGoods(${goodType.goodstypeId },1)">${goodType.goodstypename }</a></li>
          </c:forEach>        
</ul>
<div style="float:left; margin-top: 1em;margin-left: 2em;">
    <a href="#myModal1" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>&nbsp;&nbsp;添加商品</a>
    <a href="#myModal2" class="btn btn-danger" data-toggle="modal"><i class="icon-minus"></i>&nbsp;&nbsp;删除商品</a>
    <a href="#myModal3" class="btn btn-info" data-toggle="modal"><i class="icon-plus"></i>&nbsp;&nbsp;添加类别</a>
    <a href="#myModal4" class="btn btn-success" data-toggle="modal"><i class="icon-minus"></i>&nbsp;&nbsp;删除类别</a>
</div>
<div class="container-fluid">
<div class="well">
<table class="table"> 
<thead>
	<tr height="50px">
		<th colspan="2"><input type="checkbox" id="selOrcal_che"/>全选/取消</th>
		<th>商品名称</th>
		<th>类别</th>
		<th>价格</th>
		<th>库存</th>		
	</tr>
</thead>
	<tbody>
	<c:forEach var="goods" items="${goodsList }" varStatus="status">
		<tr>
			<td><input type="checkbox" class="singleCheckbox" value="${goods.goodsId }"/></td>			
			<td><img alt="" src="images/goodsImgs/${goods.goodspicture }" width="40px" height="40px"></td>
			<td>
				<div class="goodsInfo">${goods.goodsName}</div>					
				<input type="text" style="display:none;width:250px;height:10px;" index="${goods.goodsId}" index2="goodsName" >					
			</td>
			<td>
				<div>${goods.goodstype.goodstypename }</div>														
			</td>
			<td style="color:darkorange;font-weight:bold;">
				<div class="goodsInfo">￥${goods.goodsPrice }</div>					
				<input type="text" style="display:none;width:50px;height:10px;" index="${goods.goodsId}" index2="goodsPrice">					
			</td>
			<td><div class="goodsInfo">${goods.goodscount}</div>					
				<input type="text" style="display:none;width:50px;height:10px;" index="${goods.goodsId}" index2="goodsCount">					
			</td>			
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
				<li><a href="javascript:manageGoods(${goodstypeId },1)">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:manageGoods(${goodstypeId },${currentPage-1 })">上一页</a></li>
			</c:otherwise>
		</c:choose>
		 <c:forEach varStatus="i" begin="1" end="${sumPage}">
		 	<li class=""><a href="javascript:manageGoods(${goodstypeId },${i.count})">${i.count}</a></li>
		 </c:forEach>						
		<c:choose>
			<c:when test="${sumPage==currentPage }">
				<li><a href="javascript:manageGoods(${goodstypeId },${currentPage})">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:manageGoods(${goodstypeId },${currentPage+1 })">下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</c:if>
<!-- 添加商品模态框 -->
<div class="modal small hide fade" id="myModal1" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel"><i class="icon-plus-sign"></i>添加商品</h3>
	</div>
	<div class="modal-body">
		<form action="addGoods.do" method="post" id="addGoodsForm">
		<input type="hidden" name="token" value="<%=Token.createToken(session) %>">
			<table  style="width:350px;border-collapse: collapse;">
				<tr>
					<td>商品图：</td>
					<td><img src="images/140x140.gif" class="img-polaroid" width="140px" height="140px"><br>
						<input type="file" id="file" name="goodsImg" />
						<input type="button" value="上传" id="btn_uploadImg" style="display:none"/>					
					</td>
				</tr>
				<tr>
					<td>商品名：</td>
					<td><input type="hidden" value="" name="goodsImgName" id="goodsImgName">
					<input type="text" name="goodsName"></td>
				</tr>
				<tr>
					<td>价格：</td>
					<td><input type="text" name="goodsPrice"></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="text" name="goodsCount"></td>
				</tr>
				<tr>
					<td>分类：</td>
					<td>
						<select name="goodsType">
						<option value="" selected="">请选择分类</option>
							<c:forEach var="goodstype" items="${goodTypeList }" varStatus="status">
								<option value="${goodstype.goodstypeId }" >${goodstype.goodstypename }</option>
							</c:forEach>								
						</select>
					</td>
				</tr>				
			</table>	
			</form>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		<button class="btn btn-danger" data-dismiss="modal" id="saveBtn">保存</button>
	</div>
</div>
<!-- 删除商品 -->
<div class="modal small hide fade" id="myModal2" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">删除提示信息</h3>
	</div>
	<div class="modal-body">
		<p class="error-text">
			<i class="icon-warning-sign modal-icon"></i>确定要删除该商品吗?
		</p>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		<button class="btn btn-danger" data-dismiss="modal" id="deletBtn">删除</button>
	</div>
</div>
<!-- 添加商品分类 -->
<div class="modal small hide fade" id="myModal3" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">添加商品分类</h3>
	</div>
	<div class="modal-body">
		添加商品分类：<input text="text" id="GoodstypeName">
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		<button class="btn btn-danger" data-dismiss="modal" id="saveTypeBtn">保存</button>
	</div>
</div>
<!-- 删除商品分类 -->
<div class="modal small hide fade" id="myModal4" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">删除商品分类</h3>
	</div>
	<div class="modal-body">
		<p class="error-text">
			<i class="icon-warning-sign modal-icon"></i>此操作将同时删除该分类下的所属商品？
		</p>
		<div style="margin-left:70px;">
			<select id="delgoodsType">
			<option value="" selected="">请选择分类</option>
				<c:forEach var="goodstype" items="${goodTypeList }" varStatus="status">
					<option value="${goodstype.goodstypeId }" >${goodstype.goodstypename }</option>
				</c:forEach>								
			</select>
		</div>		
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		<button class="btn btn-danger" data-dismiss="modal" id="deleteTypeBtn">确定</button>
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
<script src="js/ajaxfileupload.js" type="text/javascript"></script>
</body>
<script type="text/javascript">	
	//搜索商品事件
	$("#btn_seachGoods").click(function(){
		if($("#appendedInputButton").val()!=""){
			$.ajax({
				type:"post",
				url:"searchGoods.do",
				data:{"searchContent":$("#appendedInputButton").val()},
				success:function(data){
					$(".container-fluid").html(data);
				}
			})
		}else{
			manageGoods(0,1);
		}
	})
	//全选事件
	$("#selOrcal_che").click(function(){
		if($("#selOrcal_che").attr("checked")){
			$(".singleCheckbox").attr("checked","checked");
		}else{
			$(".singleCheckbox").prop("checked",false);
		}
	})
	//添加商品图片事件
	$("#file").change(function(){
			imageUpload();
	})
		function imageUpload(){
        $.ajaxFileUpload({
            url : 'upload.do', //用于文件上传的服务器端请求地址
            fileElementId : 'file', //文件上传空间的id属性  <input type="file" id="file" name="file" />
            type : 'post',
            dataType : 'text', //返回值类型 一般设置为json
            success : function(data, status) //服务器成功响应处理函数
            {
                //alert("图片上传成功");
                //$("#picList").datagrid('reload');
                //$('#uploadPicWindow').window('close');
                // alert(data.msg);
                $(".img-polaroid").attr("src","images/goodsImgs/"+data);
                $("#goodsImgName").attr("value",data);
            },
            error : function(data, status, e)//服务器响应失败处理函数
            {
                alert("图片上传失败");
                //$("#picList").datagrid('reload');
                //$('#uploadPicWindow').window('close');
                // alert(data.msg);
            }
        });
    }
	$("#saveBtn").click(function(){
		$("#addGoodsForm").submit();
	})	
	//删除商品
	$("#deletBtn").click(function(){
		for(var i=0;i<$(".singleCheckbox").length;i++){
			if($($(".singleCheckbox").get(i)).attr("checked")){
				$.ajax({
					type:"post",
					url:"deleteGoods.do",
					data:{"goodsId":$($(".singleCheckbox").get(i)).val()},
					success:function(data){
						if(data=="1"){
							manageGoods(0,1);
						}
					}
				})
			}
		}
		
		
	})
	//添加商品分类
	$("#saveTypeBtn").click(function(){
		$.ajax({
					type:"post",
					url:"addGoodsType.do",
					data:{"GoodstypeName":$("#GoodstypeName").val()},
					success:function(data){						
							manageGoods(0,1);
					}
				})
	})
	//删除商品分类
	var typeId;
	$("#delgoodsType").change(function(){
		typeId=$(this).val();
	})
	$("#deleteTypeBtn").click(function(){		
		$.ajax({
			type:"post",
			url:"delGoodsType.do",
			data:{"GoodstypeId":typeId},
			success:function(data){						
					manageGoods(0,1);
			}
		})		
	})
	//修改商品信息
	$(".goodsInfo").click(function(){
		var flag=true;
		$(this).css("display","none");
		$(this).next().css("display","block");
		if($(this).html().indexOf("￥")==-1){
			$(this).next().val($(this).html());
		}
		else{
			$(this).next().val($(this).html().substring($(this).html().indexOf("￥")+1));
			flag=false;
		}
		$(this).next().focus();
		$(this).next().blur(function(){
			$(this).css("display","none");
			$(this).prev().css("display","block");
			if(flag){
				$(this).prev().html($(this).val());
			}else{
				$(this).prev().html("￥"+$(this).val());
			}			
			$.ajax({
				type:"post",
				url:"updateGoodsInfo.do",
				data:{"goodsId":$(this).attr("index"),"updateCon":$(this).val(),"flag":$(this).attr("index2")},
				success:function(data){		
					
				}
			}) 
		})
	})
</script>
</html>