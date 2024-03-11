<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
	<c:if test="${ sessionScope.log eq null }">
		<a href="joinForm">회원가입</a>	<br>
		<a href="loginForm">로그인</a>	<br>
	</c:if>
	<c:if test="${ sessionScope.log ne null }">
		<a href="logOut">로그아웃</a>	<br>
	</c:if>
</body>
</html>
