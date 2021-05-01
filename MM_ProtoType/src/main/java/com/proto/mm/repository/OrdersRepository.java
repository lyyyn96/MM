package com.proto.mm.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proto.mm.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, BigDecimal>{

	public List<Orders> findByMemCount(BigDecimal memCount, Sort sort);

	public Orders findByMemCountAndMovieCode(BigDecimal memCount, BigDecimal movieCode);
<<<<<<< HEAD
	
	
	
=======
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
}
