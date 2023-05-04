package com.example.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.domain.*;
import com.example.demo.service.*;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberService service;

	@GetMapping("signup")
	public void signupForm() {
		
	}
	
	@PostMapping("signup")
	public String signupProcess(Member member, RedirectAttributes rttr) {
	
		boolean ok = service.signup(member);
		
		if (ok) {
			return "redirect:/list";
		} else {
			return "redirect:/member/signup";
		}
	}
}







