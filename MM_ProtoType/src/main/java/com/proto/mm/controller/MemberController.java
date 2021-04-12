package com.proto.mm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.repository.MemberRepository;

import com.proto.mm.model.Member;

@Controller
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	
	@GetMapping("test")
	public String getMessage(Model model) {
		model.addAttribute("testSTR","타임리프 연습");
		return "testView";
	}
	
	@GetMapping("member/list")
	public String member(Model model) {
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		for(Member member : members) {
			System.out.println(member.toString());
		}
		return "member/list";
	}
}
