package com.proto.mm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proto.mm.model.Cart;

public interface CartRepository extends JpaRepository<Cart, BigDecimal>{

	// Memcount가 일치하는 Cart 값 조회
	public List<Cart> findByMemCount(BigDecimal memCount, Sort sort);
}
