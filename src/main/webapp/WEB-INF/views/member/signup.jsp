<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<my:navBar current="signup"></my:navBar>
	
	<my:alert></my:alert>

	<div class="container-lg">
		<div class="row justify-content-center">
			<div class="col-12 col-md-8 col-lg-6">
				<h1>회원 가입</h1>
				<form method="post">
					<!-- .mb-3*5>(label.form-label[for]+input.form-control[name]) -->
					<div class="mb-3">
						<label for="inputId" class="form-label">아이디</label>
						<input id="inputId" type="text" class="form-control" name="id" value="${member.id }" />
					</div>
					<div class="mb-3">
						<label for="inputPassword" class="form-label">패스워드</label>
						<input id="inputPassword" type="password" class="form-control" name="password" />
					</div>
					
					<div class="mb-3">
						<label for="inputPasswordCheck" class="form-label">패스워드 확인</label>
						<input id="inputPasswordCheck" type="password" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label for="inputNickName" class="form-label">별명</label>
						<input id="inputNickName" type="text" class="form-control" name="nickName" value="${member.nickName }" />
					</div>
					<div class="mb-3">
						<label for="inputEmail" class="form-label">이메일</label>
						<input id="inputEmail" type="email" class="form-control" name="email" value="${member.email }"/>
					</div>
					<div class="mb-3">
						<input id="signupSubmit" type="submit" class="btn btn-primary disabled" value="가입" />
					</div>
				</form>
			</div>
		</div>
	</div>



	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	<script>
		console.log("hello js");
		
		// 패스워드, 패스워드체크 인풋에 키업 이벤트 발생하면
		$("#inputPassword, #inputPasswordCheck").keyup(function() {
			// 패스워드에 입력한 값
			const pw1 = $("#inputPassword").val();
			// 패스워드확인에 입력한 값이
			const pw2 = $("#inputPasswordCheck").val();
			
			if (pw1 === pw2) {
				// 같으면
				// submit 버튼 활성화
				$("#signupSubmit").removeClass("disabled");
				// 패스워드가 같다는 메세지 출력
				
			} else {
				// 그렇지 않으면
				// submit 버튼 비활성화
				$("#signupSubmit").addClass("disabled");
				// 패스워드가 다르다는 메세지 출력
				
			}
			
			
		})
		
	
	</script>
	
</body>
</html>






