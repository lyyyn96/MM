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
public class Order {

	@Id
	@Column(name = "order_count")
	private BigDecimal orderCount;
	
	@NonNull
	@Column(name = "order_method")
	private String orderMethod;
	@NonNull
	@Column(name = "order_Date")
	private String orderDate;
	@NonNull
	@Column(name = "mem_count")
	private String memCount;
	@NonNull
	@Column(name = "movie_code")
	private String movieCode;

}
