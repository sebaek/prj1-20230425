package com.example.demo.controller;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("comment")
public class CommentController {
	
	@GetMapping("list")
	@ResponseBody
	public List<String> list(@RequestParam("board") Integer boardId) {
		
		return List.of("댓1", "댓2", "댓3");
	}
}








