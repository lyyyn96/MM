package com.proto.mm.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proto.mm.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, BigDecimal>{
	
	public Movie findByMovieTitle(String movieTitle);
	
	public Movie findByMovieCode(BigDecimal movieCode);

}
