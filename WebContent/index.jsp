<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<s:debug/></br>
<center>
 <table border="1">
	<tr>
		<td>学生编号</td>
		<td>学生姓名</td>
		<td>学生班级</td>
		<td>操作</td>
	</tr>
	
	<c:forEach items="${slist}" var="s">
	<tr>
		<td>${s.stuId}</td>
		<td>${s.stuName}</td>
		<td>${s.className}</td>
		<td>
			<a href="removeStudent?stu.stuId=${s.stuId }">删除</a>
			<a href="toupdateStudent?stu.stuId=${s.stuId }">修改</a>
		</td>
	</tr>
	</c:forEach >
	
	<!-- 第一种方法 -->
	<%-- <s:iterator value="#request.slist">
	<tr>
		<td><s:property value="stuId"/></td>
		<td><s:property value="stuName"/></td>
	</tr>
	</s:iterator> --%>
	<!-- 第二种 -->
	<%-- <s:iterator value="#request.slist" id="s">
	<tr>
		<td><s:property value="#s.stuId"/></td>
		<td><s:property value="#s.className"/></td>
	</tr>
	</s:iterator> --%>
 </table>
	 <a href="add.jsp">新增学生</a>
</center>
</body>
</html>