package com.proto.mm.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.proto.mm.DTO.MemberDTO;


@Mapper
@Repository
public interface MemberDAO{
	
	public List<MemberDTO> memberView();

	
}
