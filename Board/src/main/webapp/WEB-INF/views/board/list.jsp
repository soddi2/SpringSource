<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- jstl라이브러리 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- fmt라이브러리 : 등록일 생성 -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- header에 있는 값 가져오기 -->
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board List</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id='regBtn' type='button' class='btn btn-xs pull-right btn-success' onclick="location.href='register'">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover">          
                             <thead>
                            	 <tr>
                                     <th>번 호</th>
                                     <th>제 목</th>
                                     <th>작성자</th>                              
                                     <th>작성일</th>
                                     <th>수정일</th>
                                 </tr>
                                </thead>
                                <tbody>
								<!-- 게시판 리스트 반복문 -->
								<!-- th : 굶은 글씨, td는 얆은 글씨 -->
                                <c:forEach var="list" items="${list}">
                                    <tr>
                                        <th>${list.bno}</th>
                                        <!-- ? : 제목에 bno를 달아주기 parameter(?bno=&title)-->
                                        <!-- &nbsp; : 스페이스바 한번, <br> : 엔터 -->
                                        <!-- html => 공백 여러개와 엔터가 적용이 안됨 -->
                                        <td><a href="<c:out value='${list.bno}' />" class="move">${list.title}</a>&nbsp;&nbsp;<strong>[${list.replycnt}]</strong></td>
                                        <td>${list.writer}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value='${list.regdate}'/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value='${list.updatedate}'/></td>
                                    </tr>									
                                </c:forEach>
                                </tbody>
                            </table>
							<div class="row"> <!-- start search -->
                            	<div class="col-md-12">
                            	  <div class="col-md-8"><!--search Form-->
                            	  <!-- 검색 title -->
                            		<form action="" id="searchForm">
                            		<!-- 주소줄 자리 때문에 위에 있음,일관성을 줄수 있음 -->
                            			<input type="hidden" name="pageNum" value="${cri.pageNum}" />
                            			<input type="hidden" name="amount" value="${cri.amount}" />                            			
                            			<select name="type" id="">
                            				<option value="" <c:out value="${empty cri.type?'selected':'' }" />>-------</option>
                            				<option value="T" <c:out value="${cri.type=='T' ? 'selected':'' }" />>제목</option>
                            				<option value="C" <c:out value="${cri.type=='C' ? 'selected':'' }" />>내용</option>
                            				<option value="W" <c:out value="${cri.type=='W' ? 'selected':'' }" />>작성자</option>
                            				<option value="TC" <c:out value="${cri.type=='TC' ? 'selected':'' }" />>제목 or 내용</option>
                            				<option value="TW" <c:out value="${cri.type=='TW' ? 'selected':'' }" />>제목 or 작성자</option>
                            				<option value="TCW" <c:out value="${cri.type=='TCW' ? 'selected':'' }" />>제목 or 내용 or 작성자</option>              			
                            			</select>
                            			<input type="text" name="keyword" value="${cri.keyword}" />
                            			<button class="btn btn-default" type='button'>검색</button>
                            		</form>
                            	   </div>
                            	   <div class="col-md-2 col-md-offset-2">
                            	   	<!--페이지 목록 갯수 지정하는 폼-->
                            	   	<select class="form-control" name="amount">
                            	   		<option value="10" <c:out value="${cri.amount == 10 ? 'selected':'' }" />>10</option>
                            	   		<option value="20" <c:out value="${cri.amount == 20 ? 'selected':'' }" />>20</option>
                            	   		<option value="30" <c:out value="${cri.amount == 30 ? 'selected':'' }" />>30</option>
                            	   		<option value="40" <c:out value="${cri.amount == 40 ? 'selected':'' }" />>40</option>
                            	   	</select>
								  </div>
                             	 </div>                             	 
                      		 </div><!-- end search -->
                            <!-- start Pagination -->
                            <div class="text-center">
                            	<ul class="pagination">
                            		<c:if test="${pageVO.prev}">
                            			<li class="paginate_button previous"><a href="${pageVO.startPage-1}">Previous</a>                            		
                            		</c:if>
                            		<!-- 내가 5페이지를 보고 있어도 1-10까지 계속 페이지를 불러옴 -->
                            		<c:forEach var="idx" begin="${pageVO.startPage}" end="${pageVO.endPage}">
                            		<!-- 현재 보여지는 페이지 활성화 -->
	                            		<li class="paginate_button ${pageVO.cri.pageNum==idx?'active':''}" ><a href="${idx}">${idx}</a></li>
                            		</c:forEach>
                            		<c:if test="${pageVO.next}">
	                            		<li class="paginate_button next"><a href="${pageVO.endPage+1}">Next</a></li>
                            		</c:if>
                            	</ul>
                            </div>
                            <!-- end Pagination -->   
                            </div>
                            <!-- end panel-body -->
                        </div>
                        <!-- end panel -->
                    </div>                   
                </div>               
            <!-- /.row -->
<!-- 페이지번호를 누르면 동작하는 폼 -->
<form action="list" id="actionForm">
	<input type="hidden" name="pageNum" value="${pageVO.cri.pageNum}" />
	<input type="hidden" name="amount" value="${pageVO.cri.amount}" />	
	<input type="hidden" name="type" value="${cri.type }" /> <!-- pageVO.cri.type -->
	<input type="hidden" name="keyword" value="${cri.keyword }" />
</form>

<!-- 모달 추가 -->
<!-- alert 창 대신 -->
<div class="modal" tabindex="-1" role="dialog" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">게시글 등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>처리가 완료되었습니다.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- 스크립트 -->
 <script>
	  $(function() {
	    let result = '${result}';
	    	
	    checkModal(result);
	    history.replaceState({}, null, null);
	    
	    	
	    function checkModal(result){
	    	if(result === '' || history.state){
	    		return;
	    	}
	    	if(parseInt(result) > 0) {
	    		$(".modal-body").html("게시글"+parseInt(result)+" 번이 등록되었습니다.");
	    	}
	    	//show가 띄워주기
	    	$('#myModal').modal("show");
	    }
	    
	    //사용자가 페이지 번호를 누르면 동작하는 스크립트
	    let actionForm = $("#actionForm");
	    $(".paginate_button a").click(function(e){
	   		//a태그의 동작 막기
	    	e.preventDefault();
		    //전송해야 할 폼 가져온 후 pageNum의 값과 amount 값을 변경한 후 
		    //attr : 태그에 들어있는 값을 가져다 줌
		    actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		    //폼 전송하기 
		    actionForm.submit();
			//여기서 폼을 쓰면 여기서만 쓰고 밑에서 못 씀
	    })
	    
	    //클릭하면 10,20창을  click으로 하면 두번 개념
	    $(".form-control").change(function(){
	    	//전송해야 할 폼 가져온 후 amount 값을 변경한 후 
	    	//this = form-control이고 select은 value값을 가져올 수 있음
	    	actionForm.find("input[name='amount']").val($(this).val());
	    	//폼 전송하기
	    	actionForm.submit();
	    })
	    
	    //타이틀 클릭시 페이지 나누기 정보가 있는 폼 보내기
	    $(".move").click(function(e){
	    	//37번줄에
	    	//페이지 나누기 후에 변화를 주는 부분
	    	<%-- <a href="read?bno=${vo.bno}&pageNum=${cri.pageNum}&amount=${cri.amount}">${vo.title}</a> --%>
	    	// 이렇게 작성하는 부분 대체
	    	e.preventDefault();
	    	actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"' />");
	    	actionForm.attr('action','read');
	    	actionForm.submit();
	    })
	    
	    //검색 버튼 클릭시
	    $(".btn-default").click(function(){
			//action id가 search폼인 거 담기
	    	let searchForm = $("#searchForm");
	    	
	    	//type과 keyword가 비어 있는지 확인 하고
			//비어 있으면 메세지 띄워준 후 return
			//태그가 select면 select로 
			if($("select[name='type']").val()===""){
				alert("타입을 선택해 주세요");
	    		return false; //return을 하면 안돌아 갈수도 있어어 예방차원에 false를 해줌
			}else if($("input[name='keyword']").val()===""){
		 		alert("검색어를 입력하세요");
  				return false;
	  		}
	  
			//모두 입력이 되어 있으면 폼 전송
			searchForm.find("input[name='pageNum']").val("1");
			searchForm.submit();
	    })
	    
	  })
</script>
<%@include file="../includes/footer.jsp" %> 



































      