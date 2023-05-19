package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface CommentMapper {

	@Select("""
			SELECT * 
			FROM Comment
			WHERE boardId = #{boardId}
			""")
	List<Comment> selectAllByBoardId(Integer boardId);
	
}



