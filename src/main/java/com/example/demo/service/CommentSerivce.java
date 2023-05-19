package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Service
public class CommentSerivce {
	
	@Autowired
	private CommentMapper mapper;

	public List<Comment> list(Integer boardId) {
		// TODO Auto-generated method stub
		return mapper.selectAllByBoardId(boardId);
	}

}




