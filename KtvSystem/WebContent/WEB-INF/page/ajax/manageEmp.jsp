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
            <h1 class="page-title">员工管理</h1>
            <div class="search-well">
		<form class="form-inline"
			style="float: right; position: relative; top: -60px; left: -90px">
			<input class="input-xlarge" placeholder="Search Employees..."
				id="appendedInputButton" type="text">
			<button class="btn" type="button" id="btn_seachEmps">
				<i class="icon-search"></i> Go
			</button>
		</form>
	</div>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="Javascript:manageEmp(1)">Home</a> <span class="divider">/</span></li>
            <li class="active">员工</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
<div class="well">
    <table class="table">
      <thead>
        <tr>
          <th>员工编号</th>
          <th>员工姓名</th>
          <th>员工性别</th>
          <th>员工电话</th>
          <th>员工身份</th>
          <th>员工生日</th>
          <th>入职日期  </th>
          <th>员工住址</th>
          <th>删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="emp" items="${EmpList}" varStatus="status">
        <tr>
          <td>${emp.empId }</td>
          <td>${emp.empName }</td>
          <td>${emp.empSex==0?'男':'女' }</td>
          <td>${emp.empTel }</td>
          <td>${emp.empFlag==0?'服务员':emp.empFlag==2?'管理员':'前台人员' }</td>
          <td><fmt:formatDate value="${emp.birthday }" pattern="yyyy-MM-dd"/></td>
          <td><fmt:formatDate value="${emp.hire_date }" pattern="yyyy-MM-dd"/></td>
          <td>${emp.empAddress  }</td>
          <td>
              <a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove" onClick="getDeleteId(${emp.empId })"></i></a>
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
				<li><a href="javascript:manageEmp(1)">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:manageEmp(${currentPage-1 })">上一页</a></li>
			</c:otherwise>
		</c:choose>
		 <c:forEach varStatus="i" begin="1" end="${sumPage}">
		 	<li class=""><a href="javascript:manageEmp(${i.count})">${i.count}</a></li>
		 </c:forEach>						
		<c:choose>
			<c:when test="${sumPage==currentPage }">
				<li><a href="javascript:manageEmp(${currentPage})">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:manageEmp(${currentPage+1 })">下一页</a></li>
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
        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>是否要删除该员工?</p>
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
	function getDeleteId(empId){
		$("#deleteBtn").click(function(){
			$.ajax({
				type:"post",
				data:{"empId":empId},
				url:"deleteEmp.do",
				success:function(data){
					manageEmp(1);
				}
			})			
		})
	}
	//搜索员工事件
	$("#btn_seachEmps").click(function(){
		if($("#appendedInputButton").val()!=""){
			$.ajax({
				type:"post",
				url:"searchEmps.do",
				data:{"searchContent":$("#appendedInputButton").val()},
				success:function(data){
					$(".container-fluid").html(data);
				}
			})
		}else{
			manageEmp(1);
		}
	})
</script>
</html>