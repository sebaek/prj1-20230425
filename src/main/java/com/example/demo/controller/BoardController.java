package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.domain.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("/")
public class BoardController {

	@Autowired
	private BoardService service;

	// 경로 : http://localhost:8080
	// 경로 : http://localhost:8080/list
	// 게시물 목록
//	@RequestMapping(value = {"/", "list"}, method = RequestMethod.GET)
	@GetMapping({ "/", "list" })
	public String list(Model model) {
		// 1. request param 수집/가공
		// 2. business logic 처리
		List<Board> list = service.listBoard();
		// 3. add attribute
		model.addAttribute("boardList", list);

		// 4. forward/redirect
		return "list";
	}

	@GetMapping("/id/{id}")
	public String board(@PathVariable("id") Integer id, Model model) {
		// 1. request param
		// 2. business logic
		Board board = service.getBoard(id);
		// 3. add attribute
		model.addAttribute("board", board);
		// 4. forward/redirect
		return "get";
	}

	@GetMapping("/modify/{id}")
	public String modifyForm(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("board", service.getBoard(id));
		return "modify";
	}
	
//	@RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
	@PostMapping("/modify/{id}")
	public String modifyProcess(Board board, RedirectAttributes rttr) {
		
		boolean ok = service.modify(board);
		
		if (ok) {
			// 해당 게시물 보기로 리디렉션
			rttr.addAttribute("success", "success");
			return "redirect:/id/" + board.getId();
		} else {
			// 수정 form 으로 리디렉션
			rttr.addAttribute("fail", "fail");
			return "redirect:/modify/" + board.getId();
		}
	}
	
	@PostMapping("remove")
	public String remove(Integer id, RedirectAttributes rttr) {
		boolean ok = service.remove(id);
		if (ok) {
			rttr.addAttribute("success", "remove");
			return "redirect:/list";
		} else {
			return "redirect:/id/" + id;
		}
	}
	
	@GetMapping("add")
	public void addForm() {
		// 게시물 작성 form (view)로 포워드
	}
	
	@PostMapping("add")
	public String addProcess(Board board, RedirectAttributes rttr) {
		// 새 게시물 db에 추가
		// 1.
		// 2.
		boolean ok = service.addBoard(board);
		// 3.
		// 4.
		if (ok) {
			return "redirect:/id/" + board.getId();
		} else {
			rttr.addFlashAttribute("board", board);
			return "redirect:/add";
		}
	}
}






