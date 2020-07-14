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
	<h1>Update</h1>
	<c:if test="${empty userid}">
		<form action="" method="post">
			<div>
				<label for="userid">아이디</label>
				<input type="text" name="userid" id="userid" />
			</div>
			<div>
				<label for="password">비밀번호</label>
				<input type="text" name="password" id="password" />
			</div>
			<div>
				<button>전송</button>
			</div>
		</form>
	</c:if>
	<c:if test="${!empty userid}">
		${userid} 님 회원정보 수정 완료
	</c:if>
</body>
</html>










