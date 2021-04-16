package com.proto.mm.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.mm.model.Member;
import com.proto.mm.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("member/list")
	public String member(Model model) {
		memberService.showList(model);
		return "member/list";
	}
	
	// Sign in
	@RequestMapping(value = "signIn", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
	@ResponseBody
	public String memberlogin(HttpServletRequest request,
		HttpServletResponse response) {
	String id=request.getParameter("id");
	String pw=request.getParameter("pw");
	
	JSONObject json=new JSONObject();
	try {
		Member member_cheked = memberService.signIn(id,pw);
		String name = member_cheked.getName();
		BigDecimal mem_count = member_cheked.getMem_count();
		
		Member member=new Member(mem_count,id,pw,name);
		
		if(name!=null) {

			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(3600);
			session.setAttribute("member", member);
			json.put("name", name);

		}else {
			json.put("msg", "로그인 실패");
		}
		
	}catch(Exception e) {
		json.put("msg", e.getMessage());
	}	
	System.out.println(json.toString());
	return json.toString();
	}		

}
