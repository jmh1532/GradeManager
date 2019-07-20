<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${grade.year}년  ${grade.lecture}과목이 수강신청 되었습니다. 감사합니다.<br/>
<a href="${pageContext.request.contextPath}/lecture2019">click go to 수강신청 내역.</a>
</body>
</html>