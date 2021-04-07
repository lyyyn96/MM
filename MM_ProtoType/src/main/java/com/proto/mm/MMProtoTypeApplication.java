package com.proto.mm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class MMProtoTypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MMProtoTypeApplication.class, args);
	}

}
