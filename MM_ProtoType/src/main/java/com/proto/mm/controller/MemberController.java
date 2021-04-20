package com.proto.mm.controller;




import java.math.BigDecimal;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.mm.model.Member;
import com.proto.mm.service.MainService;
import com.proto.mm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	MainService mainService;
	
	
	@GetMapping("memberInsertForm")
	public String signUp() {
		return "memberInsertForm";
	}
	
	
	@RequestMapping(value = "memberInsert", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
	@ResponseBody
	public String memberInsert(HttpServletRequest request,
			HttpServletResponse response, String[] prefer) {
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String temp = Arrays.toString(prefer);
		String preference = temp.replaceAll("[\\s\\[\\]]", "");
		BigDecimal mem_count = null;
		try {
			Member m=new Member(mem_count,id,pw,name,preference); 
			Member result = memberService.idCheck(id);
			if(result == null) {
				memberService.memberInsert(m);
				return name+"님 회원가입 되셨습니다";	
			}else {
				return "아이디가 중복입니다.";
			}
			
		}catch(Exception e) {
			return e.getMessage();
		}	
	}	
	
	
	@GetMapping("memberList")
	public String member(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		memberService.showList(model);
		return "memberList";
	}
	
	

}
