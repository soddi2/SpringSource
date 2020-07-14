<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
    <!-- slim min을 그냥 min으로 교체 -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" 
    integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" 
    crossorigin="anonymous">
    </script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
      crossorigin="anonymous"
    ></script>
    <title>도서 관리 시스템</title>
  </head>
  <body>
    <div class="jumbotron">
      <h3>Ajax로 구현한 도서관리시스템</h3>
    </div>
   	<div class="container"></div>>
		<button type="button">도서 정보 가져오기</button>   	
   	</div>
   	<div id="result">
   		<table class="table">
   			
   		</table>
   	</div>
<script>
$(function(){
	//버튼이 눌러지면
	$("button").click(function(){
		//결과를 보여줄 위치 가져오기
		let result = $("#result table");
		
	// http://localhost:8080/list + get 요청을 한 후
	// 서버가 보내주는 json데이터를 result에 테이블 형태로 보여주기
		$.ajax({ //json형태로 보내기 때문에 rest컨트롤러가 있어야함
			url : '/list',
			type : 'get',
			success:function(data){
				console.log(data); //json 배열
				let str="";
				$.each(data,function(i,item){ //for문하고 같음
					str += "<tr><td>";
					str += item.code+"</td><td>"+item.title+"</td>";
					str += "<td>"+item.writer+"</td><td>"+item.price+"</td><td>";
				})
				result.html(str);
			}
		})
	})	
})
</script>
  </body>
</html>
























