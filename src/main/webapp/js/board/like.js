$("#likeIcon").click(function() {
	// 게시물 번호 request body에 추가
	const boardId = $("#boardIdText").text().trim();
	// const data = {boardId : boardId};
	const data = {boardId};
	
	$.ajax("/like", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		
		//success:,
		//error:,
		//complete:,
	});
});