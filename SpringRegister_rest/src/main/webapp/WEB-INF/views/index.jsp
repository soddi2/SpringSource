<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
	  <h1 class="display-4">Spring WebMVC</h1>	 
	  <hr class="my-4">  
<!-- 세션에 값이 있다면 비밀번호 변경, 로그아웃 회원탈퇴 버튼이 보여지도록 하고 세션이 없다면 로그인, 회원가입 버튼이 보여지도록 수정하기 -->
	<c:if test="${empty auth}">
		<a class="btn btn-primary btn-lg" href="/register/step1" role="button">회원가입</a>	
		<a class="btn btn-info btn-lg" href="/member/login" role="button">로그인</a>	
	</c:if>
	<c:if test="${!empty auth}">
		<a class="btn btn-success btn-lg" href="/member/logout" role="button">로그아웃</a>
		<a class="btn btn-warning btn-lg" href="/member/changePwd" role="button">비밀번호변경</a>
		<a class="btn btn-danger btn-lg" href="/member/leave" role="button">회원탈퇴</a>
	</c:if>  
	</div>
</div>
<script> 
   	let msg = '${info}';
   	console.log(msg);
   	if(msg !== ''){
   		alert(msg);
   	}
</script>
</body>
</html>