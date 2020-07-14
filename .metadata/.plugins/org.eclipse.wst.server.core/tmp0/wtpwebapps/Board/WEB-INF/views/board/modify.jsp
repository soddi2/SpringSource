<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Modify</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Modify Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <!-- action을 주게되면 그 폼으로 새로고침 되고 안주면 자신의 폼을 그래도 유지 -->
                			<form action="" method="post" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value="${vo.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" value="${vo.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content">${vo.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly" value="${vo.writer}">                				
                				</div>  
                				<!-- submit(폼 전송),reset(폼 리셋)은 기능이 들어있음  button은 그냥 폼만 있음-->
                				<!-- data-아무거나 와두 됌 -->
                				<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>              			
                				<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>              			
                				<button type="submit" data-oper='list' class="btn btn-info">List</button>              			
                			</form>
                		</div>
                	</div>
                </div>
            </div>
			<%-- remove와 list를 위한 폼--%>
			<form method="post" id="myForm">
				<input type="hidden" name="bno" value="${vo.bno}" />
				<input type="hidden" name="pageNum" value="${cri.pageNum}" />	
				<input type="hidden" name="amount" value="${cri.amount}" />	
				<input type="hidden" name="type" value="${cri.type}" /> <!-- pageVO.cri.type -->
				<input type="hidden" name="keyword" value="${cri.keyword}" />
			</form>
			
			<!-- 스크립트 -->
			<script>
			$(function() {
				let form = $("#myForm");
				
				//event에 e를 펑션에 받아줘야한다
				$("button").click(function(e) { //페이지가 로딩 되면서 실행
					//버튼은 모두 submit 형태이기 때문에 submit 속성 중지시키기
					e.preventDefault(); //a태그에 동작을 중지 시킨다
					
					//버튼이 눌러지면 어느 버튼에서 온 것인지 알아내기
					let oper = $(this).data("oper");
					
					if(oper === 'modify'){
						//modify 버튼이 눌러지면 수정 폼 보내기
						//modify는 폼을 post로 작동 하게 바꿈
						form = $("form[role='form']");
					}else if(oper === 'list'){
						//list가 눌러지면 bno는 삭제하고 method=get 방식으로 myForm 보내기
						form.attr('action','list');
						form.attr('method','get');
						form.find("input[name='bno']").remove();
						
					}else if(oper === 'remove'){
						//Remove가 눌러지면 myForm 보내기
						form.attr('action','remove');
						
					}
					//동작이 막혔기 때문에 서브밋을 해줘야 한다
					form.submit();
				})

			})
			</script>
			<%-- 스크립트 --%>
<%@include file="../includes/footer.jsp" %>       


































