const boardId = $("#boardIdText").text().trim();
$.ajax("/comment/list?board=" + boardId, {
	method: "get", // 생략 가능
	success: function(comments) {
		// console.log(data);
		$("#commentListContainer").empty();
		for (const comment of comments) {
			// console.log(comment);
			$("#commentListContainer").append(`
				<div>
					${comment.content} 
					: ${comment.memberId} 
					: ${comment.inserted}
				</div>
			`);
		}
	}
});