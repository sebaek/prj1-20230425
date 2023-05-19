package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("comment")
public class CommentController {
	
	
	@Autowired
	private CommentSerivce service;
	
//	@RequestMapping(path = "id/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("id/{id}")
	@ResponseBody
	public String remove(@PathVariable("id") Integer id) {
		service.remove(id);
		
		return "ok";
	}
	
	@PostMapping("add")
	@ResponseBody
	public String add(@RequestBody Comment comment) {
		
		service.add(comment);
		
		return "ok";
	}
	
	@GetMapping("list")
	@ResponseBody
	public List<Comment> list(@RequestParam("board") Integer boardId) {
		
		
//		return List.of("댓1", "댓2", "댓3");
		return service.list(boardId);
	}
}








