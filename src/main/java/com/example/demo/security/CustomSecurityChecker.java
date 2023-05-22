package com.example.demo.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Component
public class CustomSecurityChecker {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private CommentMapper commentMapper;
	
	public boolean checkCommentWriter(Authentication authentication,
			Integer commentId) {
		Comment comment = commentMapper.selectById(commentId);
		
		return comment.getMemberId().equals(authentication.getName());
	}

	public boolean checkBoardWriter(Authentication authentication, Integer boardId) {
		Board board = boardMapper.selectById(boardId);
		
		String username = authentication.getName();
		String writer = board.getWriter();
		
		return username.equals(writer);
	}
}





