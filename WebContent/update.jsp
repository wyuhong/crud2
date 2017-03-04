<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的页面</title>
</head>
<body>

	<!-- http://localhost:8080/hellostruts2/listStudents -->
	<center>
		<form action="updateStudent" method="post">
			<input type="hidden" name="stu.stuId" value="${student.stuId }"/><br/>
			<input type="text" name="stu.stuName" value="${student.stuName }"/><br/>
			<select name="stu.classId">
			<c:forEach items="${clist}" var="cl">
			<c:choose>
			<c:when test="${student.classId eq cl.classId }">
			<option selected="selected"  value="${cl.classId}">${cl.className}</option>
			</c:when>
			<c:otherwise>
			<option  value="${cl.classId}">${cl.className}</option>
			</c:otherwise>
			</c:choose>
			</c:forEach>
			</select>
			
			<input type="submit" value="修改"/><br/>
		</form>
	</center>
</body>
</html>