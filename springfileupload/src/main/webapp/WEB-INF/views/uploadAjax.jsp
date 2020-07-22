<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/mycss.css" />
</head>
<body>
	<h1>Upload Ajax</h1>
		<div class="uploadDiv">
			<input type="file" name="uploadFile" multiple />
		</div>
<button id="uploadBtn">Upload</button>
<div class="uploadResult">
	<ul></ul>
</div>
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<!-- $ : 제이쿼리의 줄임말 -->
<script>
$(function(){
	$("#uploadBtn").on("click",function(){
		//form의 형태로 테이타를 구성할 수 있음
		// key, value 의 형태로 구성
		let formData = new FormData();
		
		// 첨부파일 목록 가져오기
		let uploadFile = $("input[name='uploadFile']");
		//로그 창에서 0번을 눌럿고 파일즈를 찾았다
		let files = uploadFile[0].files;
		console.log(files);
		
		//form의 형태로 붙이기
		for(var i=0;i<files.length;i++){
			if(!chechExtension(files[i].name,files[i].size)){
				return false;				
			}
			formData.append("uploadFile",files[i]);
		}
		
		// processData : 데이터를 query string(http://~~~?uploadFile=테스트.txt)로 변환할 것인지 결정
		//               기본값은 application/x-www-form-urlencoded 로 true 이기
		//               때문에 false로 지정
		// contentType : 기본값은 application/x-www-form-urlencoded
		//               파일의 경우에 enctype 은 multipart/form-data로 보내야
		//               하기 때문에 false로 지정  
		
		//ajax는 무조건 network 창 켜놓고 하기
		$.ajax({
			url : 'uploadAjax',
			type : 'post',
			//code 추가 필수!
			processData : false,
			contentType : false,
			data : formData,
			success:function(result){
				// 그페이지 소스가 뜸 아무것도 안보내서 
				console.log(result);
				//업로드 된 파일 텍스트 표시
				showUploadFile(result);
			},
			error:function(xhr,status,error){
				alert(xhr.responseText);
			}
		})
	})
	
	//첨부파일 제한 / 크기 제한
	function chechExtension(fileName, fileSize){
		let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		let maxSize = 2097152;
		
		if(fileSize > maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	//업로드 된 파일 보여주기
	function showUploadFile(uploadResultArr){
		let str="";
		//결과를 보여줄 영역 가져오기
		let uploadResult = $(".uploadResult ul");
		// element.파일네임 유유아이디 : 원본 파일명이 넘어옴
		$(uploadResultArr).each(function(i,element){
			if(element.fileType){ //이미지파일
				//썸네일 이미지 경로
				var fileCallPath = encodeURIComponent(element.uploadPath+"\\s_"+element.uuid+"_"+element.fileName);	
				//원본 이미지 경로
				var oriPath = element.uploadPath+"\\"+element.uuid+"_"+element.fileName;
				oriPath = oriPath.replace(new RegExp(/\\/g),"/");
				
				str += "<li><a href=\"javascript:showImage(\'"+oriPath+"\')\">";
				str += "<img src='/display?fileName="+ fileCallPath +"'><div>"+element.fileName+"</a>";
				str += "<span data-file='"+fileCallPath+"' data-type='image'> X </span>";
				str += "</div></li>";				
			}else{//일반 파일
				var fileCallPath = encodeURIComponent(element.uploadPath+"\\"+element.uuid+"_"+element.fileName);
				str += "<li><a href='/download?fileName="+ fileCallPath +"'>";
				str += "<img src='/resources/img/attach.png'><div>"+element.fileName+"</a>";
				str += "<span data-file='"+fileCallPath+"' data-type='file'> X </span>";
				str += "</div></li>";
			}
		})
		uploadResult.append(str);
	}
	
	//확대 사진 닫기
	$(".bigPictureWrapper").on("click",function(){
		$(".bigPicture").animate({width:'0%',height:'0%'},1000);
		setTimeout(function() {
			$(".bigPictureWrapper").hide(); //.bigPictureWrapper를 숨기는 절차
		}, 1000);
	})
	
	// X를 누르면 파일 삭제
	$(".uploadResult").on("click","span",function(){
		//삭제해야할 파일 경로
		let targetFile = $(this).data("file");
		//삭제해야할 파일 타입
		let type = $(this).data("type");
		
		let targetLi = $(this).closest("li");
		$.ajax({
			url : '/deleteFile',
			data : {
				fileName : targetFile,
				type : type
			},
			type : 'post',
			success:function(result){
				console.log(result);
				targetLi.remove();
			}
		})
	})
	
	
})
function showImage(fileCallPath){
	$(".bigPictureWrapper").css("display","flex").show();
	
	/* 에니메이션 */
	$(".bigPicture").html("<img src='/display?fileName="+fileCallPath+"'>")
					.animate({width:'100%',height:'100%'}, 1000);
}
</script>
</body>
</html>














