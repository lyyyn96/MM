package com.proto.mm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proto.mm.service.MainService;
import com.proto.mm.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	MainService mainService;
	
	@GetMapping("home")
	public String movie(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		movieService.showMovieList(model);
		return "home";
	}
	
}
