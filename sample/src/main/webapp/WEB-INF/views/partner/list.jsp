<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../includes/header.jsp" %>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <h1 class="page-header">Partner List</h1>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <div class="panel panel-default">
        <div class="panel-heading">
          <button
            id="regBtn"
            type="button"
            class="btn btn-xs pull-right btn-success"
            onclick="location.href='register'"
          >
            Register Partner
          </button>
        </div>
        <div>&nbsp;</div>
        <div class="panel-body">
          <table class="table table-striped table-bordered table-hover">
            <thead>
              <tr class="text-center">
                <th>번 호</th>
                <th>회사명</th>
                <th>CEO</th>
                <th>연락처</th>
                <th>주 소</th>
                <th>등록일</th>
              </tr>
            </thead>
            <tbody>
              <!-- 파트너 리스트 반복문 -->
              <!-- el은 그냥 쓸수 있음 jsp에 들어 있음 -->
              <!-- c:if,c:foreach는 jstl을 불러다 줘야 쓸수 있음 -->
              <c:forEach var="list" items="${list}">
              <tr class="text-center">
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.ceo}</td>
                <td>${list.contact}</td>
                <td>${list.address}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value='${list.registered}'/></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>

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
	    
	    function checkModal(result){
	    	if(result === ''){
	    		return;
	    	}else {
		    	$(".modal-body").html(result+"이 등록되었습니다.");	    		

		    	//show가 띄워주기
		    	$('#myModal').modal("show");
	    		}
	    	}
	    })
	 
</script>
<%@include file="../includes/footer.jsp" %>
