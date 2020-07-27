/**
 * 댓글 작성 스크립트
 */

let replyService=(function(){ //익명 함수
	
	//직접 호출할 수 없는 함수
	function add(reply, callback){ //못부르는 스코프
		console.log("add method 실행");
		console.log(reply);
		$.ajax({
			url : "/replies/new",
			type : "post",
			contentType: 'application/json',
			data : JSON.stringify(reply),
			success:function(result){ //결과값을 read화면으로 돌려주고 싶다 , 콜백함수 : 자동으로 호출되는 함수 영역 성공하면 알아서 호출
				//console.log(result);
				if(callback){ //callback익명함수를 사용한 것과 같은 효과
					callback(result); 
				}
			},
			error:function(xhr,txtstatus,error){
				console.log(xhr.responseText);
			}
			
		})
	}//add 종료
	
	function getList(param,callback){
		let bno = param.bno;
		let page = param.page || 1; //페이지 값으 들어오면 들어온 페이지값이 들어가고 안들어 오면 1
		
		
		
		console.log("bno : "+bno);
		console.log("page : "+page);
		
		let url = "/replies/pages/"+bno+"/"+page;
		
		$.getJSON(url, function(data) {			
			console.log(data);
			if(callback){ //뭔가 함수 받은게 있으면 받아온 데이터 넘기기
				//data.replyCnt : 전체 댓글 수
				//data.list : 댓글 리스크
				callback(data.replyCnt,data.list);
			}
		})
		
	}//getList 종료
	
	function remove(param,replyer,callback,error){
		let rno = param.rno;
		
		console.log("rno : "+rno);
		$.ajax({
			//url 확인 
			url : '/replies/'+rno, // http://localhost:8081/replies/3
			type : 'delete',
			contentType : "application/json",
			data : JSON.stringify({replyer : replyer}),
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(xhr.responseText);
				}
			}
		})
	}//remove 종료
	
	function update(reply,callback,error){
		$.ajax({
			url : '/replies/'+reply.rno, // http://localhost:8081/replies/3
			type : 'put',
			contentType: 'application/json',
			data : JSON.stringify(reply),
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(xhr.responseText);
				}
			}
		})
	} //update 종료
	
	function get(rno,callback,error){
		$.getJSON({
			url : '/replies/'+rno,  //http://localhost:8080/replies/3
			type : 'get',			
			success:function(result){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,err){
				if(error){
					error(xhr.responseText);
				}
			}
		})
	}//get 종료
	
	// ms 단위로 나온 시간 변경
	function displayTime(timeVal){
		let today = new Date();
		
		let gap = today.getTime() - timeVal;
		let dateObj = new Date(timeVal);
				
		if(gap < (1000 * 60 * 60 * 24)){ //하루
			let hh = dateObj.getHours();
			let mm = dateObj.getMinutes();
			let ss = dateObj.getSeconds();
			return [(hh > 9 ? '':'0')+hh, ':', (mm > 9 ? '':'0')+mm,  //자리수 맞추기
				':', (ss > 9 ? '':'0')+ss].join("");
		}else{
			let yy = dateObj.getFullYear();
			let mm2 = dateObj.getMonth()+1;
			let dd = dateObj.getDate();
			return [yy,"/",(mm2 > 9 ? '':'0')+mm2,"/",(dd > 9 ? '':'0')+dd].join("");
		}		
	}
                           
	//return 구문에 의해서 각 함수의 결과를 리턴 받기
	return { //리턴이 없으면 함수의 결과를 받을수 없음 리턴 구문 엄청 중요(안하면 스코프에 갇혀있음)
		add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime
	};
})();























