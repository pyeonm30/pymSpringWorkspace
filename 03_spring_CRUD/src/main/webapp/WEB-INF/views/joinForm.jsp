<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="joinPro" method="post">
		ID : <input type="text" name="id" >				<br>
		PW : <input type="password" name="pw" >			<br>
		NAME : <input type="text" name="name" >			<br>
		Hobby : <input type="checkbox" name="hobby" value="sports"> 스포츠
		<input type="checkbox" name="hobby" value="study"> 공부
		<input type="checkbox" name="hobby" value="music"> 음악<br>
		<input type="submit" value="회원가입" >&nbsp;&nbsp;
	</form>
	<br>
	<br>
	<a href="loginForm">로그인</a> &nbsp;&nbsp; 
	<a href="home">메인</a>
</body>
</html>