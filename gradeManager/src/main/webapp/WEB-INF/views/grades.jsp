<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:out value="	년도	|	학기	|	이수학점	|	상세보기	"></c:out><br/>
	<c:forEach var="grade" items="${grades}">
		<c:out value ="${grade.year}|"></c:out>
		<c:out value ="${grade.semester}|"></c:out>
		<c:out value ="${grade.score}|"></c:out>
		<a href="${pageContext.request.contextPath}/semesterView?year=${grade.year}&semester=${grade.semester}">상세보기</a><br/>
	</c:forEach>
	
</body>
</html>