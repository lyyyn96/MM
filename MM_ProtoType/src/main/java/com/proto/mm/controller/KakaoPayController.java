package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proto.mm.service.KakaoPayService;
import com.proto.mm.service.MainService;
import com.proto.mm.service.OrdersService;

@Controller
public class KakaoPayController {
	    @Autowired
	    private KakaoPayService kakaoPayService;
	    
	    @Autowired
	    private MainService mainService;
	    
	    @Autowired
	    private OrdersService ordersService;
	    
	    
	    @GetMapping("/kakaoPay")
	    public void kakaoPayGet() {
	        
	    }
	    
	    @PostMapping("/kakaoPay")
	    public String kakaoPay(Model model, HttpServletRequest request, HttpServletResponse response) {
	    	mainService.signInCheck(model, request, response);
	        return "redirect:" + kakaoPayService.kakaoPayReady(model, request, response);
	 
	    }
	    
	    @GetMapping("/kakaoPaySuccess")
	    public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model, HttpServletRequest request, HttpServletResponse response) {
	    	  model.addAttribute("info", kakaoPayService.kakaoPayInfo(pg_token, model, request, response));
	    	  ordersService.orderInsert(model, request, response);
	    	  return "kakaoPaySuccess";
	    }
	    
	    @GetMapping("/kakaoPayCancel")
	    public String kakaoPayCancel(Model model, HttpServletRequest request, HttpServletResponse response) {
	        return "redirect:cart";
	    }
	    
	    @GetMapping("/kakaoPaySuccessFail")
	    public String kakaoPaySuccessFail(Model model, HttpServletRequest request, HttpServletResponse response) {
	        return "redirect:cart";
	    }
	}