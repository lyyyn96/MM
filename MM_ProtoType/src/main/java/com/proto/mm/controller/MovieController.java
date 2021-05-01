package com.proto.mm.controller;

<<<<<<< HEAD


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.JSONObject;
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.proto.mm.model.Movie;
import com.proto.mm.model.Poster;
import com.proto.mm.service.MainService;
import com.proto.mm.service.MovieService;
import com.proto.mm.service.PosterService;

=======

import com.proto.mm.service.MainService;
import com.proto.mm.service.MovieService;
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6

@Controller
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Autowired
	MainService mainService;
	
<<<<<<< HEAD
	@Autowired
	PosterService posterService;
	
	// Show movie detail
	@GetMapping("movieDetail")
	@ResponseBody
	public String showMovieDetail(Model model, HttpServletRequest request,
							  HttpServletResponse response) {
		String movieTitle=request.getParameter("movieTitle");

		mainService.signInCheck(model, request, response);
		movieService.showMovieDetail(model, movieTitle);
		System.out.println("영화 자세히 보기 정보 : "+model+"\n"+movieTitle);
		
		JSONObject json = new JSONObject();
		Movie movie = (Movie) model.getAttribute("movie");
		json.put("movie",new Gson().toJson(movie));
		json.put("poster",(String)model.getAttribute("filePath"));
		
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping(value = "movieAllDetail", 
			method= {RequestMethod.GET})
	public String showCartMovieDetail(Model model, HttpServletRequest request,
=======

	
	// Show movie detail
	@RequestMapping(value = "movieDetail", 
			method= {RequestMethod.GET})
	public String showMovieDetail(Model model, HttpServletRequest request,
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
							  HttpServletResponse response) {
		String movieTitle=request.getParameter("movieTitle");

		mainService.signInCheck(model, request, response);
		movieService.showMovieDetail(model, movieTitle);
		System.out.println("영화 자세히 보기 정보 : "+model+"\n"+movieTitle);
		
<<<<<<< HEAD
		return "movieAllDetail";
=======
		return "home";
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
	}

	@RequestMapping(value = "movieList", 
	method= {RequestMethod.GET})
	public String movieList(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		movieService.showMovieList(model, request, response);
		System.out.println(model.getAttribute("searched"));
<<<<<<< HEAD
		return "home";
	}
	
	@RequestMapping(value = "movieAll", 
	method= {RequestMethod.GET})
	public String movieAll(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		movieService.showMovieList(model, request, response);

		return "movieAll";
	}
	
	@GetMapping("movieSearch")
	@ResponseBody
=======
		
		return "home";
	}
	
	
	@RequestMapping(value = "movieSearch", 
	method= {RequestMethod.GET})
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
	public String movieSearch(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		// 세션을 체크해서 로그인 상태인지 확인
		mainService.signInCheck(model, request, response);
		
		String movieTitle=request.getParameter("movieTitle");
<<<<<<< HEAD
		System.out.println(movieTitle);
		JSONObject json = new JSONObject();
		if(movieTitle != "") {
			movieService.showMovieByMovieTitle(model,request, response);
			List<Movie> movies = (List<Movie>) model.getAttribute("movies");
			json.put("movies", movies);

			List<Poster> posters = (List<Poster>) model.getAttribute("posters");			
			json.put("posters", posters);
		}
		
		System.out.println(json);
		
		return json.toString();
	}

	@RequestMapping(value = "autoSearch", 
			method= {RequestMethod.GET},
			produces = "application/json; charset=utf8")
	@ResponseBody
    public void autoSearch(Model model,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		mainService.signInCheck(model, request, response);
		JSONArray arrayObj = movieService.autoSearch(request, response);
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter(); 
		pw.print(arrayObj); 
		pw.flush(); 
		pw.close();
		
	}
}
=======
		if(movieTitle != "") {
			movieService.showMovieByMovieTitle(model,request, response);
		}else {
			movieService.showMovieList(model, request, response);
		}
		
		
		System.out.println(model.getAttribute("searched"));
		
		return "home";
	}


	
	
}
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
