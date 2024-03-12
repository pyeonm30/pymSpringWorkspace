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
	<h1>회원가입</h1>	
	<form action="${cp}/member/joinPro" method="post">
		<table>
			<tr>
				<td>아이디</td>			
				<td><input type="text" name="id" ></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw" ></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" >
					<input type="reset" value="다시작성" >
				</td>
			</tr>
		</table>			
	</form>
	<p></p>
	<a href="${cp}/member/index">메인으로</a>
</body>
</html>