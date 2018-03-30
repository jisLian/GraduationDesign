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
<body>      
        <div class="header">     
            <h1 class="page-title">顾客管理</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="Javascript:initUser(1)">Home</a> <span class="divider">/</span></li>
            <li class="active">Users</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>#</th>
          <th>名字</th>
          <th>电话</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="Customer" items="${CustomerList}" varStatus="status">
        <tr>
          <td>${status.index+1 }</td>
          <td>${Customer.customerName }</td>
          <td>${Customer.customerTel }</td>
          <td>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove" onClick="getDeleteId(${Customer.customerId })"></i></a>
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
				<li><a href="javascript:initUser(1)">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:initUser(${currentPage-1 })">上一页</a></li>
			</c:otherwise>
		</c:choose>
		 <c:forEach varStatus="i" begin="1" end="${sumPage}">
		 	<li class=""><a href="javascript:initUser(${i.count})">${i.count}</a></li>
		 </c:forEach>						
		<c:choose>
			<c:when test="${sumPage==currentPage }">
				<li><a href="javascript:initUser(${currentPage})">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:initUser(${currentPage+1 })">下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</c:if>
<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">删除提示信息</h3>
    </div>
    <div class="modal-body">
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>是否要删除该顾客?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
        <button class="btn btn-danger" data-dismiss="modal" id="deleteBtn">确定</button>
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
	//点击删除按钮事件
	function getDeleteId(userId){
		$("#deleteBtn").click(function(){
			$.ajax({
				type:"post",
				data:{"userId":userId},
				url:"deleteUser.do",
				success:function(data){
					initUser(1);
				}
			})			
		})
	}
</script>
</html>