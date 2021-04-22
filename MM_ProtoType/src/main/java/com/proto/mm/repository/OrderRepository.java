package com.proto.mm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proto.mm.model.Order;

public interface OrderRepository extends JpaRepository<Order, BigDecimal>{

	public List<Order> findByMemCount(BigDecimal memCount, Sort sort);
}
