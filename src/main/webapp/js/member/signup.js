
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
		$("#passwordSuccessText").removeClass("d-none");
		$("#passwordFailText").addClass("d-none");

	} else {
		// 그렇지 않으면
		// submit 버튼 비활성화
		$("#signupSubmit").addClass("disabled");
		// 패스워드가 다르다는 메세지 출력
		$("#passwordFailText").removeClass("d-none");
		$("#passwordSuccessText").addClass("d-none");

	}


})

