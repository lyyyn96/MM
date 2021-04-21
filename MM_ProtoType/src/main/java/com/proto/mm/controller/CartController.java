package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.service.CartService;
import com.proto.mm.service.MainService;

@Controller
public class CartController {
	
	@Autowired
	MainService mainService;
	
	@Autowired
	CartService cartService;
	

	@GetMapping("cart")
	public String cart(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		mainService.signInCheck(model, request, response);
		cartService.showCartList(model, request, response);
		
		return "cart";
		
	}
}
