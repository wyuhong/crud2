<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询所有的页面</title>
</head>
<body>

	<!-- http://localhost:8080/hellostruts2/listStudents -->
	<center>
		<form action="test" method="post">
			<input id="stuName" type="text" name="stuName"/><s:fielderror/><br/>
			<input type="text" name="className"/><br/>
			<input type="submit" value="提交"/><br/>
		</form>
	</center>
	<script type="text/javascript" src="//cdn.bootcss.com/jquery/1.12.3/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#stuName").blur(function(){
				$.post(
					"ajaxStuName",
					{"stuName":$("#stuName").val()},
					function(data){
						alert(data);
					},
					"json"
				);
			});
			
		});
	</script>
</body>
</html>