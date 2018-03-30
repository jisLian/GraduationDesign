<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jis.bean.Goods"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>KTV商品中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" type="text/css" href="css/foods.css">
	<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
  </head>
  <body bgcolor="#F3F3F3">
    <div class="bodyContent">
    	<div class="overDiv"></div>
	   <!-- 头部页面 -->
	   <div class="head">
	   		<div class="headTitle">KTV商品中心</div>
	   		<div class="home"></div>
	   </div>
	   <!-- 主体部分 -->
	   <div class="body">
	   		<div class="clear">
	   		<div class="typeDiv">
	   			<a href="inVip.do">返回</a>
	   			<span>>>商品分类：</span>
	   			<a href="BuyGoods.do?typeId=0&pageCode=1&roomId=${roomId }">全部</a>&nbsp;
	   			<c:forEach items="${goodTypeList}" var="goodType">
	   				<a href="BuyGoods.do?typeId=${goodType.goodstypeId }&pageCode=1&roomId=${roomId }">${goodType.goodstypename }</a>
	   				&nbsp;
	   			</c:forEach>
	   		</div>
	   		<input type="hidden" value="${typeId }" id="nowtypeId">
	   		<div class="county clear">
	   			<div>   		
		   		<img src="images/car.png" width="40px" height="40px"/>
		   		</div>
		   		<div>		   							   		
	   			包厢号:<span id="roomId">${roomId }</span>
	   			</div>
	   			<div>
	   			<input type="button" value="结算" id="btnCount">
	   			</div>
	   			<div class="buyCount" value="${buyCount }"></div>	
	   		</div>
	   		</div>
	   		<div class="food clear">	   			  				
		   			<c:forEach items="${goodsList}" var="goods" varStatus="status">
		   				<div class="imgs">			   				
		   				<img src="images/goodsImgs/${goods.goodspicture }" width="225px" height="226px"/>
		   				<p>￥${goods.goodsPrice }</p>
		   				<div class="count">库存:${goods.goodscount}</div>
		   				<div class="foodName">${goods.goodsName}</div>		   				
		   				<div class="opt clear">
		   					<span class="sub">-</span>   					
		   							<c:forEach items="${newList}" var="newGoods">
		   								<c:if test="${newGoods.goodsId eq goods.goodsId }">
		   								<input type="hidden" value="${newGoods.goodscount }" class="fcount" index="${newGoods.goodsId }">
		   								</c:if>		   								
		   							</c:forEach>		   					
		   					<span class="content" count="0" value="${goods.goodsId }"></span>		
		   					<span class="add">+</span>
		   				</div>		  			
		   				</div>				   					   					   							   						   				
		   			</c:forEach>	   					   			
	   		</div>
	   </div>
	   <!-- 分页部分 -->
	   <input type="hidden" value="${currentPage }" id="nowPage">
	   <div class="pageContent clear">
	   		<div class="uppage">＜上一页</div>
	   		<div class="code"></div>   		
	   		<div class="downpage">下一页＞</div>
	   		<div class="pagetotal">共<span style="font-weight: bold" id="totalFoods">${sumPage }</span>页</div>
	   		<div class="looppage">到第<input type="text" id="jumpPage"/>页&nbsp;<input type="button" value="确定" id="btn"/></div>	   		
	   </div>
	   <div class="sumMoney">
	   		<div class="sumTital">扫码支付</div>
	   		<img src="images/code.png" width="264px" height="304px"/>
	   		<br/>
	   		<span id="totalMoney"></span>
	   		<br>
	   		<input type="button" value="取消" class="countBtn">	   		
	   </div>
	   <!-- 尾部页面 -->
	  	<div class="foot">
	  		<a href="#">关于KTV</a>
	  		&nbsp;|&nbsp;
	  		<a href="#">服务条款</a>
	  		&nbsp;|&nbsp;
	  		<a href="#">客服中心</a>
	  		&nbsp;|&nbsp;
	  		<a href="#">联系我们</a>
	  		&nbsp;|&nbsp;
	  		<a href="#">帮助中心</a>
	  		&nbsp;|&nbsp;
	  		<span>©2017 KtvProject.All Right Reserved</span>		
	  	</div>
  </div>
  </body>
 <script type="text/javascript">
 	if($(".buyCount").attr("value")!=0){
 		$(".buyCount").html($(".buyCount").attr("value"));
 		$(".buyCount").css("display","block");
 	}	
 	if($(".fcount")!=null){
 		if($(".fcount").length!=0){
 			for(var i=0;i<$(".fcount").length;i++){	
 				for(var j=0;j<$(".content").length;j++){	 									
 				if($($(".fcount")[i]).attr("index")==$($(".content")[j]).attr("value")){
 					$($(".content")[j]).attr("count",$($(".fcount")[i]).attr("value"));
 					$($(".content")[j]).html($($(".content")[j]).attr("count"));
 				}
 			}
 			}
 		}
 	}
 	$(".add").click(function(){	
 		var buycount=parseInt($(".buyCount").attr("value"));		
 		buycount+=1;		
 		var count=parseInt($(this).prev().attr("count"));
	 	$(this).prev().attr({"count":count+=1});
	 	$(this).prev().html($(this).prev().attr("count"));
	 	$(".buyCount").html(buycount);	 	
		$(".buyCount").attr("value",buycount);	
	 	$(".buyCount").css("display","block");
	 	var foodId=$(this).prev().attr("value");
	 	$.ajax({
		type:"post",
		url:"AjaxBuyFood.do",
		data:{"count":$(this).prev().attr("count"),"buycount":buycount,"foodId":foodId},
		success:function(data){
			
		}			
		}) 	 		 	
 		
 	})
 	$(".sub").click(function(){		
 		var buycount=parseInt($(".buyCount").attr("value"));		
 		 var count=parseInt($(this).parent().find(".content").attr("count"));
 		 if(count>0){
 		 	$(this).parent().find(".content").attr({"count":count-=1});
 		 	if(parseInt($(".buyCount").attr("value"))>0){
		 		buycount--;
		 		$(".buyCount").attr("value",buycount);
	 		}	
	 		else{
	 			buycount=0;
	 			$(".buyCount").attr("value",buycount);
	 		}
	 		$(".buyCount").css("display","block");
	 		$(".buyCount").html(buycount);
 		 }
	 	else{
	 		$(this).parent().find(".content").attr({"count":count=0});
	 	}
	 	$(this).parent().find(".content").html($(this).parent().find(".content").attr("count"));
	 	var foodId=$(this).parent().find(".content").attr("value");	 	
	 	 $.ajax({
		type:"post",
		url:"AjaxBuyFood.do",
		data:{"count":$(this).parent().find(".content").attr("count"),"buycount":buycount,"foodId":foodId},
		success:function(data){}			
		})	
 	})
 	//分页
 	for(var i=1;i<=$("#totalFoods").html();i++){
 		$(".code").append("<div class='pagecode'>"+i+"</div>");
 	}
 	var nowpage=parseInt($("#nowPage").val());
 	$(".pagecode:eq("+(nowpage-1)+")").css({"background-color":"brown","color":"white"});
 	$(".pagecode").click(function(){
 		$(this).css({"background-color":"brown","color":"white"});		
 		window.location.href="BuyGoods.do?pageCode="+$(this).html()+"&typeId="+$("#nowtypeId").val()+"&roomId="+$("#roomId").html();						
 	})
 	$(".uppage").click(function(){
 		if(nowpage==1){
 			return;			
 		}
 		else{
 			window.location.href="BuyGoods.do?pageCode="+(nowpage-1)+"&typeId="+$("#nowtypeId").val()+"&roomId="+$("#roomId").html();
 		}		
 	})
 	$(".downpage").click(function(){
 		if(nowpage==$("#totalFoods").html()){
 			return;			
 		}
 		else{
 			window.location.href="BuyGoods.do?pageCode="+(nowpage+1)+"&typeId="+$("#nowtypeId").val()+"&roomId="+$("#roomId").html();
 		}		
 	})
 	$("#btn").click(function(){
 		var jumppage=parseInt($("#jumpPage").val());
 		if(jumppage<=$("#totalFoods").html()&&jumppage>0){
 			window.location.href="BuyGoods.do?pageCode="+jumppage+"&typeId="+$("#nowtypeId").val()+"&roomId="+$("#roomId").html();					
 		}
 		else{
 			window.location.href="BuyGoods.do?pageCode="+nowpage+"&typeId="+$("#nowtypeId").val()+"&roomId="+$("#roomId").html();
 		}
 	})
 	$("#btnCount").click(function(){
 		$(".overDiv").css("display","block");
 		$(".sumMoney").css("display","block");
 		$.ajax({
		type:"post",
		url:"AjaxCountFoods.do",
		success:function(data){
			$("#totalMoney").html("总金额："+data);
			}			
		})	
 	})
 	$(".countBtn").click(function(){
 		$(".overDiv").css("display","none");
 		$(".sumMoney").css("display","none");
 	})
 </script>
</html>
