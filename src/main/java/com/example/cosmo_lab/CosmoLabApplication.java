package com.example.cosmo_lab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.example.cosmo_lab.admin.model.mapper"})
public class CosmoLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmoLabApplication.class, args);
	}
}
