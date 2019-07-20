<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
	
	<sf:form method="post" action="${pageContext.request.contextPath}/docreate" modelAttribute="grade">
		<table class="formtable">
		
		<tr><td class="label">Year: </td><td><sf:input class="control" type="int" path="year"/><br/>
				<sf:errors path="lecture" class="error"/></td></tr>
			<tr><td class="label">Semester: </td><td><sf:input class="control" type="int" path="semester"/><br/>
				<sf:errors path="division" class="error"/></td></tr>
			<tr><td class="label">Code: </td><td><sf:input class="control" type="text" path="code"/><br/>
				<sf:errors path="score" class="error"/></td></tr>
			<tr><td class="label">Lecture: </td><td><sf:input class="control" type="text" path="lecture"/><br/>
				<sf:errors path="lecture" class="error"/></td></tr>
			<tr><td class="label">Division: </td><td><sf:input class="control" type="text" path="division"/><br/>
				<sf:errors path="division" class="error"/></td></tr>
			<tr><td class="label">Score: </td><td><sf:input class="control" type="int" path="score"/><br/>
				<sf:errors path="score" class="error"/></td></tr>
			
			
			<tr><td></td><td><input class="control" type="submit" value="수강 신청"/></td></tr>
		</table>
	</sf:form>
	
</body>
</html>