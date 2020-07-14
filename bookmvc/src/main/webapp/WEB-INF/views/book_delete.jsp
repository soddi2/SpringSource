<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h4>삭제할 도서 코드 번호를 입력해 주세요</h4>
<form action="delete" method="post">
	<div class="form-group">
		<input type="text" name="code" class="form-control form-control-lg" 
		required="required" placeholder="도서코드입력"/>			
	</div>
	<div class="form-group">
		<button type="submit" class="btn btn-primary">삭제</button>
		<button type="reset" class="btn btn-secondary">취소</button>	
	</div>
</form>








