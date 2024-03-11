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
	<h1> JoinPro </h1>
	ID : ${ member.id }			<br>
	PW : ${ member.pw } 		<br>
	NAME : ${ member.name }		<br>
	Hobby : ${ member.hobby }	<br>
	
	<c:forEach var="hobby" items="${ member.hobby }">
		<c:out value="${ hobby }" />
	</c:forEach>
	<br>
	<a href="loginForm">로그인</a> &nbsp;&nbsp; 
	<a href="home">메인</a>
</body>
</html>