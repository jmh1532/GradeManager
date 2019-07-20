<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>
<body>

	<p><a href="${pageContext.request.contextPath}/lecture2019">2019 수강신청 내역</a></p>
	<p><a href="${pageContext.request.contextPath}/creategrade">2019 수강신청 하기</a></p>
	<p><a href="${pageContext.request.contextPath}/grades">학기별 이수 학점 내역 </a></p>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout"/>" method="post">
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
	</form>

</body>
</html>
