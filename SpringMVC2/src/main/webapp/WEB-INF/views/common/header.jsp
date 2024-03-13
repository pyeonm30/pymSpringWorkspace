<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"> 게시판 </span>
        <span class="icon-bar"> 공지사항 </span>
        <span class="icon-bar"> 내정보 </span>                        
      </button>
      <a class="navbar-brand" href="${cp}/">스프링 mvc2</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${cp}/">Home</a></li>
        <li><a href="boardMain.do">게시판</a></li>            
      </ul>
      <c:if test="${empty mvo}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${cp}/member/memLoginForm.do"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	            <li><a href="${cp}/member/memJoin.do"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>            
	      </ul>
      </c:if>
      <c:if test="${!empty mvo}">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${cp}/member/memUpdateForm.do"><span class="glyphicon glyphicon glyphicon-wrench"></span> 회원정보수정</a></li>
	            <li><a href="${cp}/member/memLogout.do"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>            
	            <c:if test="${!empty mvo}">
			    <c:if test="${empty mvo.memProfile}">
			      <li><img class="img-circle profile-img" src="${cp}/resources/images/person.PNG" style="width: 40px; height: 40px "/></li>
			      <li style="height: 60px; line-height: 60px;" >${mvo.memName} 님 </li>
			    </c:if>
			    <c:if test="${!empty mvo.memProfile}">
			      <li><img class="img-circle profile-img" src="${cp}/resources/upload/${mvo.memProfile}" style="width: 40px; height: 40px" /> ${mvo.memName} 님Welcome.</li>
			    </c:if>			  
			  </c:if>
	      </ul>
      </c:if>
    </div>
  </div>
</nav>