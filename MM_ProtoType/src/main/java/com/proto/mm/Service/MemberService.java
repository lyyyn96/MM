package com.proto.mm.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proto.mm.DAO.MemberDAO;
import com.proto.mm.DTO.MemberDTO;


@Service
public class MemberService{
	
	@Autowired
	MemberDAO memberDAO;

	public List<MemberDTO> memberView() {
		return memberDAO.memberView();
	}

	
}
