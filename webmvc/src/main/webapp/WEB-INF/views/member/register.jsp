<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="" method="post"> <!-- 동일한 주소를 쓸거라면 action안해도됨 -->
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="password">비밀번호</label>
			<input type="text" name="password" id="password" />
		</div>
		<div>
			<label for="confirm_password">비밀번호 확인</label>
			<input type="text" name="confirm_password" id="confirm_password" />
		</div>
		<div>
			<label for="mobile">전화번호</label>
			<input type="text" name="mobile" id="mobile" />
		</div>
		<div>
			<button>전송</button>
		</div>
	</form>
</body>
</html>