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
	//댓글 작업 호출
	replyService.add();
})
</script>
<%@include file="../includes/footer.jsp" %> 
      






















