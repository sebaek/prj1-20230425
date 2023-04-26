package com.example.demo.mapper;

import java.util.*;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.*;

@Mapper
public interface BoardMapper {

	@Select("""
			SELECT
				id,
				title,
				writer,
				inserted
			FROM Board
			ORDER BY id DESC
			""")
	List<Board> selectAll();

	
}





