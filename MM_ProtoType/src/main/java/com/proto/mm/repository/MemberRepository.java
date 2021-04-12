package com.proto.mm.repository;


import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proto.mm.model.Member;

public interface MemberRepository extends JpaRepository<Member, BigDecimal>{
	
	

}
