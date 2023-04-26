package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.mapper.*;

@Controller
@RequestMapping("/")
public class BoardController {
	
	@Autowired
	private BoardMapper mapper;

	// 경로 : http://localhost:8080
	// 경로 : http://localhost:8080/list
	// 게시물 목록
//	@RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
	@GetMapping({"/", "list"})
	public String list(Model model) {
		// 1. request param 수집/가공
		// 2. business logic 처리
		List<Board> list = mapper.selectAll();
		// 3. add attribute
		model.addAttribute("boardList", list);
		
		System.out.println(list.size());
		// 4. forward/redirect
		return "list";
	}
}








