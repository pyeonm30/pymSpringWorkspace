<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <script defer src="${cp}/resources/js/modal.js"></script>
</head>
<body onload="actionModal('${msgType}' ,'${msg}' )" >
<div class="container">
  <jsp:include page="../common/header.jsp"/> 
  <h2>Spring MVC03</h2>
  <div class="panel panel-default">
    <div class="panel-heading">회원사진등록양식</div>
    <div class="panel-body">
      <form action="${cp}/member/memImageUpdate.do" method="post" enctype="multipart/form-data">
         <input type="hidden" name="memID" value="${mvo.memID}"/>
         <table class="table table-bordered" style="text-align: center; border: 1px solid #dddddd;">
           <tr>
             <td style="width: 110px; vertical-align: middle;">아이디</td>
             <td>${mvo.memID}</td>
           </tr>
           <tr>
             <td style="width: 110px; vertical-align: middle;">사진 업로드</td>
             <td colspan="2">
               <span class="btn btn-default">
                 이미지를 업로드하세요.<input type="file" name="memProfile"/>
               </span>
             </td>            
           </tr>      
           <tr>
             <td colspan="2" style="text-align: left;">
                <input type="submit" class="btn btn-primary btn-sm pull-right" value="등록"/>
             </td>             
           </tr>
         </table>
      </form> 
    </div>
 <jsp:include page="../common/msgModal.jsp"/> 
</body>
</html>