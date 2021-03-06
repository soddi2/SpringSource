<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<!-- 실패시 알림 -->
<script> 
   	let msg = '${error}';
   	console.log(msg);
   	if(msg != ''){
   		alert(msg);
   	}
</script>
<form>
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>회원탈퇴</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<!-- value에 auth에 userid 값을 가져와서 담아 넣기 -->
					<input type="text" name="userid" id="userid" class="form-control" value="${auth.userid}" readonly/>
			 		<small id="userid" class="text-info"></small>		
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="password" id = "password" class="form-control" placeholder="비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>
				</div>	
			</div>				
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">탈퇴</button>
				<!-- on클릭에 로케이션 달고 인덱스로 보내 줍니다 -->
				    <button type="button" class="btn btn-secondary" id="leavecancel" onclick="location.href='/'">취소</button>					
			</div>
		</div>
	</div>		
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	//http://localhost:8080/leave + delete
	
	//json 형태로 보낸 후 성공하면 index로 이동하기
	$(".btn-primary").click(function(e){ //누르면 가져오게
	// userid와 password를 서버로 보내서 회원탈퇴
	let param = {
			userid : $("input[name='userid']").val(),
			password : $("input[name='password']").val()
	};
		e.preventDefault();
		
		console.log($("form").serialize());
		//폼안의 데이터를 json형태로 서버로 보개지 입력 후 결과를 받아 출력하기
		$.ajax({
			url : '/leave', // http://localhost:8080//member/leave =>
			type : 'delete',
			contentType : "application/json",
			data : JSON.stringify(param), // $("form").serialize() : 무조건 post방식이여야 반응
			success:function(param){ // 200 : 성공~
				console.log(param);
				alert(param);
				location.href='/';
			},
			error:function(xhr,txtStatus,error){ //400 : 실패~
				//alert(xhr.responseText);
				if(msg === 'fail') {
					alert('현재 비밀번호를 확인해 주세요');
					$("#password").val("");
					$("#password").focus();
				}
			}
		})
	})
})

</script>




























