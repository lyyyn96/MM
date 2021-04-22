package com.proto.mm.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.proto.mm.model.Member;
import com.proto.mm.model.Movie;
import com.proto.mm.model.Order;
import com.proto.mm.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public Model showOrderList(Model model, HttpSession session) {
		System.out.println("구매목록 서비스 호출");
		// 모든 영화 목록 조회 후 Movie List에 저장 후 model에 값 저장 후 반환
		Member member = (Member)session.getAttribute("member");
		BigDecimal memCount = member.getMemCount();
		List<Order> orders = orderRepository.findByMemCount(memCount, Sort.by(Sort.Direction.ASC, "orderCount"));
		model.addAttribute("orders", orders);
		for(Order order : orders) {
			System.out.println(order.toString());
		}
		
		return model;
	}
}
