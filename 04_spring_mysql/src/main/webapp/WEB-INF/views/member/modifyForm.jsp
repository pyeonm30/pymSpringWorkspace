<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	
	<c:if test="${sessionScope.log eq null }">
		<script>
			alert("로그인 후 이용가능합니다.");
			location.href="${cp}/member/userMenu";
		</script>
	</c:if>
	
	<c:if test="${sessionScope.log ne null }">
		<h1>회원정보 수정하기</h1>
		<form action="${cp}/member/modifyPro" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td>${member.id}</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input name="pw"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input name="email"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정하기" >
					</td>
				</tr>
			</table>
		</form>
		<br><br>
		<a href="${cp}/member/index">메인으로</a>
	</c:if>
</body>
</html>