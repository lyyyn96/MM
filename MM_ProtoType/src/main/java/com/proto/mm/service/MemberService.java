package com.proto.mm.service;

import java.util.List;
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
	
	

