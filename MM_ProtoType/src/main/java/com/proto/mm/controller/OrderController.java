package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.service.MainService;
import com.proto.mm.service.OrderService;



@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	MainService mainService;
	
	@GetMapping("orders")
	public String order(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		HttpSession session=request.getSession();
		orderService.showOrderList(model,session);
		return "orders";
	}
}
