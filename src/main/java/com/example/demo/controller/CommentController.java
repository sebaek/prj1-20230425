package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;
import com.example.demo.service.*;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("comment")
public class CommentController {
	
	
	@Autowired
	private CommentSerivce service;
	
	@PutMapping("update")
//	@ResponseBody
	@PreAuthorize("authenticated and @customSecurityChecker.checkCommentWriter(authentication, #comment.id)")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Comment comment) {
		Map<String, Object> res = service.update(comment);
		
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("id/{id}")
//	@ResponseBody
	public Comment get(@PathVariable("id") Integer id) {
		return service.get(id);
	}
	
//	@RequestMapping(path = "id/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("id/{id}")
//	@ResponseBody
	@PreAuthorize("authenticated and @customSecurityChecker.checkCommentWriter(authentication, #id)")
	public ResponseEntity<Map<String, Object>> remove(@PathVariable("id") Integer id) {
		Map<String, Object> res = service.remove(id);
		
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping("add")
//	@ResponseBody
//	@PreAuthorize("authenticated")
	public ResponseEntity<Map<String, Object>> add(
			@RequestBody Comment comment,
			Authentication authentication) {
		
		if (authentication == null) {
			Map<String, Object> res = Map.of("message", "로그인 후 댓글을 작성해주세요.");
			return ResponseEntity.status(401).body(res);
		} else {
			Map<String, Object> res = service.add(comment, authentication);
			
			return ResponseEntity.ok().body(res);
		}
		
	}
	
	@GetMapping("list")
//	@ResponseBody
	public List<Comment> list(@RequestParam("board") Integer boardId, Authentication authentication) {
		
		
//		return List.of("댓1", "댓2", "댓3");
		return service.list(boardId, authentication);
	}
}








