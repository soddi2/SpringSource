<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value="${vo.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" readonly="readonly" value="${vo.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<!-- textarad는 value말고 안에 넣어라 -->
                					<textarea class="form-control" rows="3" name="content" readonly="readonly">${vo.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly" value="${vo.writer}">                				
                				</div>  
                				<button type="button" class="btn btn-default">Modify</button>     			
                				<button type="reset" class="btn btn-info">List</button>          			
                			</form>
                		</div>
                	</div>
                </div>
            </div> 
<!-- 댓글 영역 -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>
				Reply
				<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
					New Reply
				</button>
			</div>
			<div class="panel-body">
			<!-- 여기서 부터 반복 -->
				<ul class="chat"> 
					<li class="left clearfix" data-rno='30'>
						<div>
							<div class="header">
								<strong class="primary-font">댓글러00</strong>
								<small class="pull-right text-muted">
									2020.07.15 12:14
								</small>
							</div>
							<p>Good Job!!!</p>
						</div>						
					</li>
				</ul>
			</div>
			<!-- 만들어진 영역이기 떄문에 위임하는 형태로 해야함 -->
			<div class="panel-footer"><!-- 댓글 페이지 영역 -->
			
			</div>
		</div>
	</div>
</div>      
<!-- 댓글 등록 모달 -->
<div class="modal" tabindex="-1" role="dialog" id="replyModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
      	<div class="form-group">
      		<label for="">댓글 내용</label>
      		<input type="text" class="form-control" name="reply" value="댓글내용"/>
      	</div>
      	<div class="form-group">
      		<label for="">작성자</label>
      		<input type="text" class="form-control" name="replyer" value="작성자"/>
      	</div>
      	<div class="form-group">
      		<label for="">작성일</label>
      		<input type="text" class="form-control" name="replydate" value="작성일"/>
      	</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" id="modalRegisterBtn">등록</button>
        <button type="button" class="btn btn-success" id="modalModBtn">수정</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBtn">삭제</button>
        <button type="button" class="btn btn-primary" id="modalCloseBtn" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>              
<!-- 페이지 나누기와 다른 작업들을 위해서 폼 작성 -->      
<!-- 스크립트에 myForm을 가져온다 -->
<form id="myForm">
	<input type="hidden" name="bno" value="${vo.bno}" />
	<input type="hidden" name="pageNum" value="${cri.pageNum}" />	
	<input type="hidden" name="amount" value="${cri.amount}" />	
	<input type="hidden" name="type" value="${cri.type }" /> <!-- pageVO.cri.type -->
	<input type="hidden" name="keyword" value="${cri.keyword }" />
</form>
<script>
$(function() {
	let form = $("#myForm");
	
	$(".btn-default").click(function() {
		//bno는 삭제하기
		form.attr('action','modify'); //http://~/board/modify
		form.submit();
	})
	$(".btn-info").click(function(){
		form.attr('action','list');
		form.find("input[name='bno']").remove(); //주소줄에서 bno지우기
		form.submit();
	})
	
})
</script>
<script src="/resources/js/reply.js"></script>
<script>
$(function(){
	//e.preventDefault();
	
	//현재 글의 글 번호 가져오기
	let bno = ${vo.bno};
	
	//댓글 영역 가져오기
	let replyUL = $(".chat");
	
	//댓글 영역 내용을 보여주는 함수 호출 
	showList(1);
	
	//모달 영역 가져오기
	let modal = $(".modal");
	//모달 영역이 가지고 있는 input 영역 찾기
	let modalInputReply = modal.find("input[name='reply']");
	let modalInputReplyer = modal.find("input[name='replyer']");
	let modalInputReplyDate = modal.find("input[name='replydate']");
	//모달 영역이 가지고 있는 버튼 찾기
	let modalModBtn = $("#modalModBtn");
	let modalRemoveBtn = $("#modalRemoveBtn");
	let modalRegisterBtn = $("#modalRegisterBtn");
	
	$("#addReplyBtn").click(function(){
		//input 안에 들어있는 내용 없애주기
		modal.find("input").val("");
		
		//작성날짜 영역 없애기
		modalInputReplyDate.closest("div").hide();
		// 닫기 버튼만 제외하고 모든 버튼을 숨기기
		modal.find("button[id!='modalCloseBtn']").hide();
		// 등록 버튼 다시 보이기
		modalRegisterBtn.show();
		
		modal.modal("show");
	})
	
	//댓글 작업 호출
	//댓글 등록하기
	//$는 위에서 변수로 들어왔기 때문에 큰 의미는 없다
	// on("click",~~) : click과 같은 역할인데,동적으로 나중에 바인딩 시킬  수 있는 기능이 추가 되어있음
	//					여러 이벤트를 동시에 추가할 수 있음
	//ex) .on("click","mouseenter",function()
	
	//댓글 페이지 나누기로 추가
	let pageNum = 1;
	
	modalRegisterBtn.on("click",function(){
		
		var reply = {
				bno:bno,
				replyer: modalInputReplyer.val(),
				reply: modalInputReply.val()
			};
		
			replyService.add(reply,function(result){ //2개이상 받는거 param{} 제이슨형식으로 보내기
				alert(result);
				//modal 에 있은 댓글 내용과 관련된 내용 지우기
				modal.find("input").val("");
				//모달 창 종료
				modal.modal("hide");
				//전체 댓글 리스트 보기 
				//-1로 변경해서 마지막 페이지 보여주기
				showList(-1);
				
		}); //add 종료 		
	}) 
	
	//댓글 리스트 요청하기
	function showList(page){
		
		 replyService.getList({bno:bno,page:page},function(total,list){
			console.log(list);
			
			if(page == -1){
				pageNum = Math.ceil(total / 10.0);
				showList(pageNum);
				return;
			}
			
			if(list === null || list.length === 0){
				replyUL.html("");
				return;
			}
			
			let str = "";
			for(var i=0,len=list.length||0; i<len; i++){ //반복할 구간
				str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
				str += "<div><div class='header'>";
				str += "<strong class='primary-font'>"+list[i].replyer+"</strong>";
				str += "<small class='pull-right text-muted'>"+replyService.displayTime(list[i].replydate)+"</small>";
				str += "</div><p>"+list[i].reply+"</p></div></li>";		
			}
			replyUL.html(str);
			showReplyPage(total);
		})  //getList 종료		
	}
	

	//댓글 페이지 영역 가져오기
	let replyPageFooter = $(".panel-footer");
	
	function showReplyPage(total){
		
		//마지막 페이지 계산
		let endPage = Math.ceil(pageNum/10.0)*10;
		//시작 페이지 계산
		let startPage = endPage - 9;
		//이전 버튼
		let prev = startPage != 1;
		//다음 버튼 
		let next = false;
		
		//실제 마지막 페이지 계산
		if(endPage * 10 >= total){
			endPage = Math.ceil(total/10.0);
		}
		if(endPage * 10 < total){
			next = true;
		}
		
		//디자인 작성후 댓글 페이지 영역에 보여주기
		let str = "<ul class='pagination pull-right'>";
		if(prev){
			str += "<li class='page-item'><a class='page-link'";
			str += " href='"+(startPage - 1)+"'>Prev</a></li>";
		}
		for(var i = startPage; i<= endPage; i++){
			let active = pageNum == i ? "active":""; //pageNum = "2"면 스트링으로 넘어오는데 i는 int라 타입비교까지 하면 안됌
			str += "<li class='page-item "+active+"'>";
			str += "<a class='page-link' href='"+i+"'>"+i;
			str += "</a></li>";
		}
		if(next){
			str += "<li class='page-item'><a class='page-link'";
			str += " href='"+(endPage + 1)+"'>Next</a></li>";
		}
		str += "</ul></div>";
		replyPageFooter.html(str);
	}
	
	//댓글 페이지 번호를 누르면 실행되는 스크립트
	replyPageFooter.on("click","li a",function(e){
		//href 때문에 움직이는 이벤트 제거
		e.preventDefault();
		
		pageNum = $(this).attr("href");
		showList(pageNum);
	})
	
	
	
	
	
	//$(modalRemoveBtn).click(function()) 이렇게 걸어도 상관은 없지만 그냥 .on 쓰자
	$(modalRemoveBtn).on("click",function(){		
		//댓글 삭제
		//json은 키 밸류값으로 가야한다고!!
		replyService.remove({rno:modal.data("rno")},
				function(result){ 
					alert(result);
					//모달 창 종료
					modal.modal("hide");
					//전체 댓글 리스트 보기
					// showList(1);  페이지 나누기 전
					showList(pageNum); //페이지 나누기 후 : 현재 보던 페이지
	
				},
				function(msg){ 
					alert("삭제 실패");
		}) //remove 종료
	})
	
	//댓글 수정
	$(modalModBtn).on("click",function(){
		
		replyService.update({rno:modal.data("rno"),reply:modalInputReply.val()},function(result){
							alert(result);
							
							//모달 창 종료
							modal.modal("hide");
							
							//전체 댓글 리스트 보기
							// showList(1);  페이지 나누기 전
							showList(pageNum); //페이지 나누기 후 : 현재 보던 페이지
							
						},function(error){
							alert("수정 실패");
			
		})   //update 종료
	})
	
	//댓글 하나 가져오기
	//json {key : value}
	//실제로는 li에 이벤트를 걸어야 하지만 댓글이 나중에 생기는 
	//부분이기 때문에 존재하는 영역에 댓글을 걸고 나중에 생기는 
	//li 태그에 위임하는 방식으로 작성
	$(".chat").on("click","li",function(){ //동적 바인딩 방식 나중에 생기는 영역은 인식을 못함  그냥 클릭은 현재 태그가 만들어져 있는 건 동작을 하지만 나중에 만든건 동작을 안함
		
		//현재 클릭된 댓글의 rno를 가져오기
		var rno = $(this).data("rno");
		
		
		replyService.get(rno,
				function(result){
					console.log(result);
					//도착한 데이터 모달창에 보여주기
					modalInputReply.val(result.reply);
					modalInputReplyer.val(result.replyer);
					modalInputReplyDate.val(replyService.displayTime(result.replydate))
											.attr("readonly","readonly"); //작성일 수정 금지
					
					//현재 읽어온 rno 담아주기
					modal.data("rno",result.rno);
					
					//반복 작업시 버튼 다시 보여주기
					modal.find("button").show();
					
					//등록 버튼 지우기
					modal.find("button[id='modalRegisterBtn']").hide();
					
					//작성 날짜 영역 보여주기
					modalInputReplyDate.closest("div").show();
					modal.find("button").show();
					modal.find("button[id='modalRegisterBtn']").hide();
					
					modal.modal("show");
					
		},function(error){
			alert("데이터 없음");
	
		})   //get 종료
	})
	
})
</script>
<%@include file="../includes/footer.jsp" %> 
      






















