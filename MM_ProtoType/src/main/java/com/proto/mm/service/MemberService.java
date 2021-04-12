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
		List<Member> members = memberRepository.findAll();
		model.addAttribute("members", members);
		for(Member member : members) {
			System.out.println(member.toString());
		}
		return model;
	}
	
	
}
