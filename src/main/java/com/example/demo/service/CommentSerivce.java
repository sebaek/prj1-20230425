package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentSerivce {
	
	@Autowired
	private CommentMapper mapper;

	public List<Comment> list(Integer boardId) {
		// TODO Auto-generated method stub
		return mapper.selectAllByBoardId(boardId);
	}

	public void add(Comment comment) {
		comment.setMemberId("user9");
		mapper.insert(comment);
		
	}

	public void remove(Integer id) {
		mapper.deleteById(id);
		
	}

}




