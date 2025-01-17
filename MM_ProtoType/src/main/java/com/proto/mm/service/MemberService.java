package com.proto.mm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.proto.mm.model.Member;
import com.proto.mm.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	
	public Model showList(Model model) {
		System.out.println("회원목록 서비스 호출");
		// 모든 사용자 목록 조회 후 Member List에 저장 후 model에 값 저장 후 반환
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		for(Member member : members) {
			System.out.println(member.toString());
		}
		return model;
	}

	
	public Member signIn(String id, String pw) {
		System.out.println("로그인 서비스 호출");
		return memberRepository.findByIdAndPw(id, pw);
	}
	

	
	
}