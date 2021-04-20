  
package com.proto.mm.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.service.MainService;
import com.proto.mm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MainService mainService;
	
	
	@GetMapping("memberList")
	public String member(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		memberService.showList(model);
		return "memberList";
	}
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		HttpSession session=request.getSession();
		memberService.showMemberInfo(model,session);
		// orderService에서 정보 가져오기
		
		return "memberInfo";
	}

	@GetMapping("memberUpdate")
	public String memberUpdate(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		
		return "memberUpdate";
	}
}