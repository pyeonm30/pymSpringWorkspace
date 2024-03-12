<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 화면</h1>
	<c:if test="${sessionScope.log eq null}">
		<a href="${cp}/member/joinForm">회원가입</a>	<br>
		<a href="${cp}/member/loginForm">로그인</a>	<br>
	</c:if>
	
	<c:if test="${sessionScope.log ne null}">
		<a href="${cp}/member/logout">로그아웃</a>		<br>
		<a href="${cp}/member/modifyForm">정보수정</a>	<br>
		<%-- 직접 구현해보세요. --%>
		<a href="#">탈퇴</a>							<br>
	</c:if>
	
	<a href="${cp}/member/index">메인으로</a>			<br>
</body>
</html>