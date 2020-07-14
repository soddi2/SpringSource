/**
 * modifyFrom.jsp에 대한 유효성 검사하기
 */
$(function(){
	$("#changePwd").validate({ //changPwd를 발리데이션 합니다.
		//규칙
		rules:{
			password:{
				required:true,
//				equalTo : "#password"
			},
			new_password:{
				required:true,
				validNWD : true,
			},
			confirm_password:{
				required:true,
				validNWD : true,
				equalTo : "#new_password"
			}
		},
		messages:{
			password:{
				required:"비번을 입력하세요"
			},
			new_password:{
				required:"새비번을 입력하세요"
			},
			confirm_password:{
				required:"새비번을 다시 입력하세요",
				equalTo : "이전 비밀번호와 다릅니다."
			}
		},//messages end
		errorPlacement:function(error,element){ //에러메시지 위치 지정			
			$(element).closest("form").find("small[id='"+element.attr("id")+"']").append(error);				
		}
	})
})

//규칙을 검증할 메소드 추가
$.validator.addMethod("validPWD",function(value){
	const regPwd = /(?=^[A-Za-z])(?=.+\d)[A-Za-z\d]{8,15}/;
	return regPwd.test(value);	
},"비밀번호는 영문자로 시작하고,숫자의 조합으로 8~15자리로 만들어야 합니다.");

$.validator.addMethod("validNWD",function(value){
	const regNwd = /(?=^[A-Za-z])(?=.+\d)[A-Za-z\d]{8,15}/;
	return regNwd.test(value);	
},"비밀번호는 영문자로 시작하고,숫자의 조합으로 8~15자리로 만들어야 합니다.");



