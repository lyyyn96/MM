package com.proto.mm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.proto.mm.model.Cart;
import com.proto.mm.model.Member;
import com.proto.mm.model.Movie;
import com.proto.mm.model.Order;
import com.proto.mm.repository.MovieRepository;
import com.proto.mm.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Model showOrder(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("구매 서비스 호출");
		// 모든 영화 목록 조회 후 Movie List에 저장 후 model에 값 저장 후 반환
		String movie_title = request.getParameter("movieTitle");
		Movie movie = movieRepository.findByMovieTitle(movie_title);
		
		model.addAttribute("movie", movie);
		
		return model;
	}
	
	public Model showOrderList(Model model,HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("구매목록 서비스 호출");
		// 모든 영화 목록 조회 후 Movie List에 저장 후 model에 값 저장 후 반환
		HttpSession session=request.getSession();
		Member member = (Member)session.getAttribute("member");
		BigDecimal memCount = member.getMemCount();
		List<Order> orders = orderRepository.findByMemCount(memCount, Sort.by(Sort.Direction.ASC, "orderCount"));
		model.addAttribute("orders", orders);
		
		List<Movie> orderMovies = findMovieByMovieCode(orders);
		model.addAttribute("movies", orderMovies);
		
		/*for(Order order : orders) {
			System.out.println(order.toString());
		}*/
		
		return model;
	}
	
	public List<Movie> findMovieByMovieCode (List<Order> orders){
		
		List<Movie> cartMovies=new ArrayList<Movie>();
		
		for(Order order : orders) {
			BigDecimal movieCode = order.getMovieCode();
			Movie movie = new Movie();
			movie = movieRepository.findByMovieCode(movieCode);
			cartMovies.add(movie);
		}
		return cartMovies;
	}
}
