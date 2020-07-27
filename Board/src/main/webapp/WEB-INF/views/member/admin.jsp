<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인한 사용자 중에서 관리자만  접근 가능</h1>
	<form action="/login" method="post">
		<!-- post로 가는 모든 경로는 csrf로 담기(보안) -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>
	<!-- 
		principal : 데이터베이스에서 인증이 끝난 정보(CustomUser)
	 -->
	<div>
		<ul>
			<li>Admin 인증 정보</li>
			<li>principal : <sec:authentication property="principal"/></li>
			<li>MemberVo : <sec:authentication property="principal.member"/></li>
			<li>사용자 이름 : <sec:authentication property="principal.member.username"/></li>
			<li>사용자 아이디 : <sec:authentication property="principal.member.userid"/></li>
			<li>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/></li>
		</ul>
	</div>
</body>
</html>