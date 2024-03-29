<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	body{
		margin-top:100px;
	}
</style>
<!-- alert창 띄우기 -->
<script> 
   	let msg = '${info}';
   	console.log(msg);
   	if(msg !== ''){
   		alert(msg);
   	}
</script>
</head><!-- script는 html만 안 벗어나게 -->
	<!-- jquery,jquery-validate : 순서 중요, 둘이 세트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.js"></script>
    <!-- validation 사용자 작성 코드 삽입-->
    <script src="/resources/js/modify.js"></script>
    <!-- 수정 -->
    <script>
		$(function(){
			$("button").click(function(e){
				// http/location:8081/modify + put
				let param = {
						password : $("input[name='password']").val(),
						new_password : $("input[name='new_password']").val(),
						confirm_password : $("input[name='confirm_password']").val()
				};
			
				e.preventDefault();
				
				$.ajax({
					url : '/modify',
					type : 'put',
					contentType : "application/json",
					data : JSON.stringify(param),
					success:function(data){ //200
						alert(data);
						location.href='/';
					},
					error:function(xhr,txtStatus,error){ //400 xhr : 
						//alert(xhr.responseText); 
						let msg = xhr.responseText;
						if(msg === 'fail') {
						alert('현재 비밀번호를 확인해 주세요');
						$("#confirm_password").val("");
						$("#confirm_password").focus();
					}
				}
			})
		})
	})
	</script>
<body>
<div class="card border-success mb-3 mx-auto" style="max-width: 25rem;">
  <div class="card-header">비밀번호 변경</div>
  <div class="card-body">
  	<form id="changePwd" action="/member/changePwd" method="post">
  			<div class="form-group row">
	    		<input type="password" class="form-control" size="50" id="password" name="password" placeholder="현재 비밀번호">
	    		<small id="password" class="text-info"></small>
	    	</div>
    		<div class="form-group row">
			    <input type="password" class="form-control" size="50" id="new_password" name="new_password" placeholder="새 비밀번호">  
			    <small id="new_password" class="text-info"></small> 
			</div>
			<div class="form-group row"> 
			    <input type="password" class="form-control" size="50" id="confirm_password" name="confirm_password" placeholder="새 비밀번호 확인">
			    <small id="confirm_password" class="text-info"></small> 
			</div>
			<div class="form-group row "> 
			    <button type="submit" class="btn btn-primary btn-block">변경</button>
			</div> 
    </form>
</div>
</div>
</body>
</html>





















