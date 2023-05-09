package com.example.demo.security;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Component
public class CustomSecurityChecker {
	
	@Autowired
	private BoardMapper mapper;

	public boolean checkBoardWriter(Authentication authentication, Integer boardId) {
		Board board = mapper.selectById(boardId);
		
		String username = authentication.getName();
		String writer = board.getWriter();
		
		return username.equals(writer);
	}
}





