listComment();

$("#sendCommentBtn").click(function() {
	const boardId = $("#boardIdText").text().trim();
	const content = $("#commentTextArea").val();
	const data = {boardId, content};
	
	$.ajax("/comment/add", {
		method: "post",
		contentType: "application/json",
		data: JSON.stringify(data),
		complete: function(jqXHR) {
			listComment();
			$(".toast-body").text(jqXHR.responseJSON.message);
			toast.show();
		}
	});
})

$("#updateCommentBtn").click(function() {
	const commentId = $("#commentUpdateIdInput").val();
	const content = $("#commentUpdateTextArea").val();
	const data = {
		id : commentId,
		content : content
	}
	$.ajax("/comment/update", {
		method: "put",
		contentType: "application/json",
		data: JSON.stringify(data),
		complete: function(jqXHR) {
			listComment();
			$(".toast-body").text(jqXHR.responseJSON.message);
			toast.show();
		}
	})
})

function listComment() {
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
						<button 
							id="commentDeleteBtn${comment.id}" 
							class="commentDeleteButton" 
							data-comment-id="${comment.id}">삭제</button>
						:
						<button
							id="commentUpdateBtn${comment.id}"
							class="commentUpdateButton"
							data-comment-id="${comment.id}">수정</button>
						: ${comment.content} 
						: ${comment.memberId} 
						: ${comment.inserted}
					</div>
				`);
			};
			$(".commentUpdateButton").click(function() {
				const id = $(this).attr("data-comment-id");
				$.ajax("/comment/id/" + id, {
					success: function(data) {
						$("#commentUpdateIdInput").val(data.id);
						$("#commentUpdateTextArea").val(data.content);
					}
				})
			});
			
			
			$(".commentDeleteButton").click(function() {
				const commentId = $(this).attr("data-comment-id");
				$.ajax("/comment/id/" + commentId, {
					method: "delete",
					complete: function() {
						listComment();
					}
				});
			})
		}
	});
	
}
