<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<div class="container-lg">
		<h1>${board.id }번 게시물 보기</h1>
		<div>
			제목 : ${board.title }
		</div>
		<div>
			본문 : <div>${board.body }</div>
		</div>
		<div>
			작성자 : ${board.writer }
		</div>
		<div>
			작성일시 : ${board.inserted }
		</div>
		<div>
			<a class="btn btn-secondary" href="/modify/${board.id }">수정하기</a>
			<button id="removeButton" class="btn btn-danger" form="removeForm" type="submit">삭제하기</button>
		</div>
	</div>
	
	<div class="d-none">
		<form action="/remove" method="post" id="removeForm">
			<input type="text" name="id" value="${board.id }" />
		</form>
	</div>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script>
		$("#removeButton").click(function(e) {
			// 서브밋 진행 이벤트 막기
			e.preventDefault();
			
			const res = confirm("삭제 하시겠습니까?");
			if (res) {
				// 서브밋 실행
				$("#removeForm").submit();
			}
		});
	</script>

    <c:if test="${not empty param.success }">
	    <script>
			alert("게시물이 수정되었습니다.");	    
	    </script>
    </c:if>
</body>
</html>








