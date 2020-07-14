<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>calc.jsp 결과값 보여주기</h1>
	
	<!-- 도메인 이름을 주지 않은 경우 -->
	<!-- 클래스가 아닌 것들은 다 소문자이기 때문에 앞글잘를 소문자로 바꿔주세요 -->
	<h3>${calcVO.num1}</h3> 
	<h3>${calcVO.op}</h3> 
	<h3>${calcVO.num2}</h3>
	
	<!-- 도메인 이름을 준 경우 -->
	<h3>${vo.num1}</h3> 
	<h3>${vo.op}</h3>
	<h3>${vo.num2}</h3>
	<h3>${result}</h3>
	
	<!-- model에 담은 경우 -->
	<h3>${num1}</h3>
	<h3>${num2}</h3>
	<h3>${op}</h3>
	<h3>${result}</h3>
</body>
</html>












