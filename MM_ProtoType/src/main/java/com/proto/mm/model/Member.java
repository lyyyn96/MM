package com.proto.mm.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity // 데이터베이스 연동 클래스임을 명시
@Data
public class Member{
	
	@Id  // PK임을 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// GenerationType은 Auto가 기본, 자동으로 해줌. 성능은 시퀀스가 가장 좋지만 많은 건을 처리 하고
	// 자동증가 기본값으로 id 설정 시 IDENTITY가 적절함 
	private BigDecimal mem_count;
	
	private String id;
	private String pw;
	private String name;
	

}
