package com.proto.mm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	
	@GetMapping("test")
	public String getMessage(Model model) {
		model.addAttribute("testSTR","타임리프 연습");
		return "testView";
	}
	
	@GetMapping("member/list")
	public String member(Model model) {
		memberService.showList(model);
		return "member/list";
	}
}
