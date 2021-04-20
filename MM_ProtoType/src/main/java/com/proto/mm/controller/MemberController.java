package com.proto.mm.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
<<<<<<< HEAD
	JSONObject json=new JSONObject();
	try {
		Member member_cheked = memberService.signIn(id,pw);
		String name = member_cheked.getName();
		BigDecimal mem_count = member_cheked.getMem_count();
		
		Member member=new Member(mem_count,id,pw,name);
		
		if(name!=null) {

			HttpSession session=request.getSession();
			session.setMaxInactiveInterval(3600);
			System.out.println(session.getMaxInactiveInterval());
			session.setAttribute("member", member);
			System.out.println("테스트1");
			json.put("name", name);
			
			System.out.println(name);
		}else {
			json.put("msg", "로그인 실패");
		}

		
	}catch(Exception e) {
		json.put("msg", e.getMessage());
	}	
	return json.toString();
	}		
	

=======
>>>>>>> e88e3c75d782e6113ec16ce3f1e6e9f753fd3343

}
