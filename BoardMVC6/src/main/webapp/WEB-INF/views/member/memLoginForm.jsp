<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>로그인</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script defer src="${cp}/resources/js/modal.js"></script>
   
   <!-- ?error -->
   <script>
   $(document).ready(function(){
 	if(${param.error!=null}){
 		$("#messageType").attr("class", "modal-content panel-warning");
    		$(".modal-body").text("아이디와 비밀번호를 확인해주세요");
    		$(".modal-title").text("실패 메시지");
   		$("#myMessage").modal("show");
 	}
   });
   </script>
</head>
<body onload="actionModal('${msgType}' ,'${msg}' )" >
<div class="container">
  <jsp:include page="../common/header.jsp"/> 
  <h2>Spring MVC02</h2>
  <div class="panel panel-default">
    <div class="panel-heading">로그인화면</div>
    <div class="panel-body">
      <form action="${cp}/member/memLogin.do" method="post">
         <table class="table table-bordered" style="text-align: center; border: 1px solid #dddddd;">
           <tr>
             <td style="width: 110px; vertical-align: middle;">아이디</td>
             <td><input id="memID" name="username" class="form-control" type="text" maxlength="20" placeholder="아이디를 입력하세요."/></td>
           </tr>
           <tr>
             <td style="width: 110px; vertical-align: middle;">비밀번호</td>
             <td colspan="2"><input id="memPassword" name="password" class="form-control" type="password" maxlength="20" placeholder="비밀번호를 입력하세요."/></td>            
           </tr>      
           <tr>
             <td colspan="2" style="text-align: left;">
                <input type="submit" class="btn btn-primary btn-sm pull-right" value="로그인"/>
             </td>             
           </tr>
         </table>
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
      </form> 
    </div>

    <div class="panel-footer"></div>
  </div>
</div>
 <jsp:include page="../common/msgModal.jsp"/> 
</body>
</html>
<

