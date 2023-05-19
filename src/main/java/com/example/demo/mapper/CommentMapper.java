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
			ORDER BY id
			""")
	List<Comment> selectAllByBoardId(Integer boardId);

	@Insert("""
			INSERT INTO Comment (boardId, content, memberId)
			VALUES (#{boardId}, #{content}, #{memberId})
			""")
	Integer insert(Comment comment);

	@Delete("""
			DELETE FROM Comment
			WHERE id = #{id}
			""")
	Integer deleteById(Integer id);

	@Select("""
			SELECT *
			FROM Comment
			WHERE id = #{id}
			""")
	Comment selectById(Integer id);

	@Update("""
			UPDATE Comment
			SET
				content = #{content}
			WHERE
				id = #{id}
			""")
	Integer update(Comment comment);
	
}



