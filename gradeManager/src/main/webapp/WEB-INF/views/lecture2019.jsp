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
	<h3>2019년 수강신청 내역</h3>
	<c:forEach var="grade" items="${grades}">
		<c:out value="년도: ${grade.year}	|	"></c:out>
		<c:out value="학기: ${grade.semester}	|	"></c:out>
		<c:out value="과목코드: ${grade.code}	|	"></c:out>
		<c:out value="과목이름: ${grade.lecture}	|	"></c:out>
		<c:out value="구분: ${grade.division}	|	"></c:out>
		<c:out value="학점: ${grade.score}"></c:out><br/>
	</c:forEach>
	<a href="${pageContext.request.contextPath}/creategrade">수강 신청 하기</a><br/>
	<a href="${pageContext.request.contextPath}">홈 화면으로 가기</a><br/>
</body>
</html>