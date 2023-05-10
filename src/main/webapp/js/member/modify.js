$("#inputPassword, #inputPasswordCheck").keyup(function() {
	const pw1 = $("#inputPassword").val();
	const pw2 = $("#inputPasswordCheck").val();

	if (pw1 === pw2) {
		$("#modifyButton").removeClass("disabled");
		$("#passwordSuccessText").removeClass("d-none");
		$("#passwordFailText").addClass("d-none");
	} else {
		$("#modifyButton").addClass("disabled");
		$("#passwordSuccessText").addClass("d-none");
		$("#passwordFailText").removeClass("d-none");
	}

});