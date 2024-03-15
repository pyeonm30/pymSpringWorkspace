<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>   
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="mvo" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/> 
<c:set var="auth" value="${SPRING_SECURITY_CONTEXT.authentication.authorities}"/> 

<script>
	let csrfHeaderName = "${_csrf.headerName}";
	let csrfTokenValue = "${_csrf.token}";
	function logout(){
	  	$.ajax({
	  		url : "${cp}/logout",
	  		type: "post", // insert    	
	  		beforeSend: function(xhr){
	              xhr.setRequestHeader(csrfHeaderName, csrfTokenValue)
	          },
	  		success : function(){
	  			location.href="${cp}/";
	  		},
	  		error : function(){ alert("error");}    		
	  	}); 
	}

</script>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${cp}/">스프링 mvc6</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${cp}/">Home</a></li>
        <li><a href="${cp}/boardMain.do">게시판</a></li>            
      </ul>
     <security:authorize access="isAnonymous()">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${cp}/member/memLoginForm.do"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	            <li><a href="${cp}/member/memJoin.do"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>            
	      </ul>
      </security:authorize>
      <security:authorize access="isAuthenticated()">
	      <ul class="nav navbar-nav navbar-right">
	            <li><a href="${cp}/member/memUpdateForm.do"><span class="glyphicon glyphicon glyphicon-wrench"></span> 회원정보수정</a></li>
	            <li><a href="${cp}/member/memImageForm.do"><span class="glyphicon glyphicon glyphicon-picture"></span> 사진등록</a></li>
	            <li><a href="javascript:logout()"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>            
	            <c:if test="${empty mvo.member.memProfile}">
			      <li><img class="img-circle" src="${cp}/resources/images/person.PNG" style="width: 50px; height: 50px"/>
			    </c:if>
			    <c:if test="${!empty mvo.member.memProfile}">
			      <li><img class="img-circle" src="${cp}/resources/upload/${mvo.member.memProfile}" style="width: 50px; height: 50px"/>
			    </c:if>
			     ${mvo.member.memName} 
			     (
			     <security:authorize access="hasRole('ROLE_USER')"> 
			       U,
			     </security:authorize> 
			     <security:authorize access="hasRole('ROLE_MANAGER')"> 
			       M,
			     </security:authorize>  
			     <security:authorize access="hasRole('ROLE_ADMIN')">
			       A
			     </security:authorize>
			      )
			    </li>
	      </ul>
      </security:authorize>
    </div>
  </div>
</nav>