package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.mm.model.Member;
import com.proto.mm.service.MemberService;



@Controller
public class MainController{
	
	@Autowired
	MemberService memberService;

	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
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
			// id와 pw로 DB 조회 후 해당하는 Member 객체 반환
			Member member = memberService.signIn(id,pw);
			// 반환 된 Member 객체에서 name 값 얻기
			String name = member.getName();
			
			if(name!=null) {
				// 세션 값이 있다면 가져오고 없다면 생성하여 member 객체를 입력
				HttpSession session=request.getSession();
				session.setMaxInactiveInterval(3600);
				session.setAttribute("member", member);
				json.put("name", name);
	
			}else {
				json.put("msg", "로그인 실패");
			}
			
		}catch(Exception e) {
			e.getStackTrace();
			json.put("msg", e.getMessage());
		}	
	System.out.println(json.toString());
	return json.toString();
	}		
		
	// Sign out
	@RequestMapping(value = "signOut", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")			
	@ResponseBody
	public String signOut(HttpServletRequest request,
			HttpServletResponse response){
		
			//기존 세션을 가져오고 없더라도 생성하지 않는다.
			HttpSession session=request.getSession(false);
			session.invalidate();
			return "";
	
	}
	
}
