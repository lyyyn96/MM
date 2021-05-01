package com.proto.mm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	@Id
	@Column(name = "movie_code")
	private BigDecimal movieCode;
	
	@NonNull
	@Column(name = "movie_title")
	private String movieTitle;
	@NonNull
	@Column(name = "movie_rating")
	private BigDecimal movieRating;
	@NonNull
	@Column(name = "movie_genre")
	private String movieGenre;
	@NonNull
	@Column(name = "movie_director")
	private String movieDirector;
	@NonNull
	@Column(name = "movie_actor")
	private String movieActor;
	@NonNull
	@Column(name = "movie_story")
	private String movieStory;
	@NonNull
	@Column(name = "movie_rdate")
	private String movieRdate;
	@NonNull
	@Column(name = "movie_rtime")
<<<<<<< HEAD
	private BigDecimal movieRtime;
=======
	private String movieRtime;
>>>>>>> 6d60f666779c42176499abdff4917f8c7f6865f6
	@NonNull
	@Column(name = "movie_price")
	private BigDecimal moviePrice;
}
