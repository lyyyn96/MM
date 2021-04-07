package com.proto.mm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.DTO.MemberDTO;
import com.proto.mm.Service.MemberService;


@Controller
public class MainController{
	@Autowired
	MemberService memberService;
	
	@GetMapping("")
	public String mainView() {
		return "index";
	}

	@GetMapping("test")
	public String getMessage(Model model) {
		model.addAttribute("testSTR","타임리프 연습");
		return "testView";
	}
	
	@GetMapping("memberList")
	public String member(Model model) {
		List<MemberDTO> memberList = memberService.memberView();
		model.addAttribute("memberList", memberList);
		for(MemberDTO member : memberList) {
			System.out.println(member.toString());
		}
		
		return "memberList";
	}
	
}
