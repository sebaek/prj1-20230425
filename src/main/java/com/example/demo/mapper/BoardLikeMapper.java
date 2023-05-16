package com.example.demo.mapper;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface BoardLikeMapper {
	@Insert("""
			INSERT INTO BoardLike
			VALUES (#{boardId}, #{memberId})
			""")
	Integer insert(Like like);

	@Delete("""
			DELETE FROM BoardLike
			WHERE boardId = #{boardId} 
			  AND memberId = #{memberId} 
			""")
	Integer delete(Like like);

	@Select("""
			SELECT COUNT(*) 
			FROM BoardLike
			WHERE boardId = #{boardId}
			""")
	Integer countByBoardId(Integer boardId);

	@Select("""
			SELECT * 
			FROM BoardLike
			WHERE boardId = #{boardId}
			  AND memberId = #{memberId}
			""")
	Like select(Integer boardId, String memberId);

	@Delete("""
			DELETE FROM BoardLike
			WHERE boardId = #{boardId}
			""")
	void deleteByBoardId(Integer boardId);

	@Delete("""
			DELETE FROM BoardLike
			WHERE memberId = #{memberId}
			""")
	void deleteByMemberId(String memberId);
}




