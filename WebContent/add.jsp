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
		<form action="saveStudent" method="post">
			学生编号：<input type="text" name="stu.stuId"/><br/>
			学生姓名：<input type="text" name="stu.stuName"/><br/>
			班级编号：<input type="text" name="stu.classId"/>
			<input type="submit" value="保存"/><br/>
		</form>
	</center>
</body>
</html>