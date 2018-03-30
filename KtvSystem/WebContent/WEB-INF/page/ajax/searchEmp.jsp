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
</body>

</html>