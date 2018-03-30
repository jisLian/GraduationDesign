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
	tr:hover{
		background-color: lightgray;
	}
</style>
<body>
 <div class="header">     
      <h1 class="page-title">个人中心</h1>
 </div>
<div class="well">
    <table class="table">
      <tbody>
        <tr>
          <td width="100px">编号:</td><td>${loginUser.empId }</td>
          </tr>
          <tr> 
          <td>姓名:</td><td>${loginUser.empName }</td>
          </tr>
          <tr> 
          <td>性别:</td><td>${loginUser.empSex==0?'男':'女' }</td>
          </tr> 
          <tr>
          <td>电话:</td><td>${loginUser.empTel }</td>
          </tr>
          <tr> 
          <td>身份:</td><td>${loginUser.empFlag==0?'服务员':loginUser.empFlag==2?'管理员':'前台人员' }</td>
          </tr>
          <tr> 
          <td>生日:</td><td><fmt:formatDate value="${loginUser.birthday }" pattern="yyyy-MM-dd"/></td>
          </tr> 
          <tr>
          <td>入职日期:</td><td><fmt:formatDate value="${loginUser.hire_date }" pattern="yyyy-MM-dd"/></td>
           </tr>
          <tr>
          <td>住址:</td><td>${loginUser.empAddress  }</td>
        </tr>        
      </tbody>
    </table>
</div>
</body>
<script type="text/javascript">
	
</script>
</html>