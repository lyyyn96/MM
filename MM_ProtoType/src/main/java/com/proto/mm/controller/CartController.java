package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.mm.model.Cart;
<<<<<<< HEAD
import com.proto.mm.service.CartService;
import com.proto.mm.service.MainService;
import com.proto.mm.service.MovieService;
import com.proto.mm.service.OrdersService;
=======
import com.proto.mm.model.Movie;
import com.proto.mm.service.CartService;
import com.proto.mm.service.MainService;
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6

@Controller
public class CartController {
	
	@Autowired
	MainService mainService;
	
	@Autowired
	CartService cartService;
	
<<<<<<< HEAD
	@Autowired
	MovieService movieService;
	
	@Autowired
	OrdersService orderService;
	
=======
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6

	@GetMapping("cart")
	public String cart(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		mainService.signInCheck(model, request, response);
		cartService.showCartList(model, request, response);
		
		return "cart";
	}
	
	@RequestMapping(value = "cartInsert", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
	@ResponseBody
	public String cartInsert(Model model,HttpServletRequest request,
			HttpServletResponse response) {
			try {
<<<<<<< HEAD
				if (orderService.orderCheck(request, response) != null) {
					return "이미 구매한 영화 입니다.";
				}else if(cartService.cartCheck(request, response) == null) {
					cartService.cartInsert(request, response);
					String movieTitle = request.getParameter("movieTitle");
				
					return movieTitle + "이(가) 장바구니에 담겼습니다.";
=======
				
				if(cartService.cartCheck(request, response) == null) {
				cartService.cartInsert(request, response);
				String movieTitle = request.getParameter("movieTitle");
				
				return movieTitle + " 이(가) 장바구니에 담겼습니다.";
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
				}else {
					return "이미 장바구니에 담겨있습니다.";
				}
			}catch(Exception e) {
				return e.getMessage();
			}
		}
	
	@RequestMapping(value = "cartDelete", 
			method= {RequestMethod.POST},
			produces = "application/text; charset=utf8")
	@ResponseBody
	public String cartDelete(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Cart cart = cartService.findCartMovie(request, response);
			cartService.cartDelete(cart);
			String movieTitle = request.getParameter("movieTitle");
			
<<<<<<< HEAD
			return movieTitle + " 삭제 되었습니다.";
=======
			return movieTitle + "삭제 되었습니다.";
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
			
		}catch(Exception e) {
			return e.getMessage();
		}
		
		
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "cartMovieDetail", 
			method= {RequestMethod.GET})
	public String showCartMovieDetail(Model model, HttpServletRequest request,
							  HttpServletResponse response) {
		String movieTitle=request.getParameter("movieTitle");

		mainService.signInCheck(model, request, response);
		movieService.showMovieDetail(model, movieTitle);
		System.out.println("영화 자세히 보기 정보 : "+model+"\n"+movieTitle);
		
		return "cartMovieDetail";
	}
	
=======
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
}
