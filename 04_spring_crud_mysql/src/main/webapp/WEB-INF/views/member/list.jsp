<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>회원 목록</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이메일</th>
		</tr>
	<c:forEach var="member" items="${memberList}">
		<tr>
			<td>${member.num}</td>
			<td>${member.id}</td>
			<td>${member.pw}</td>
			<td>${member.email}</td>
		</tr>
	</c:forEach>
	</table>
	
	<a href="${cp}/member/index">메인으로</a>			<br>
</body>
</html>