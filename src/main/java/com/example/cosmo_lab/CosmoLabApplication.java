package com.example.cosmo_lab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value= {"com.example.cosmo_lab.admin.model.mapper"})
@MapperScan(value= {"com.example.cosmo_lab.item.model"})
@MapperScan(value= {"com.example.cosmo_lab.order.mapper"})
@MapperScan(value= {"com.example.cosmo_lab.user"})

public class CosmoLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmoLabApplication.class, args);
		System.out.println("Hello CosmoLab");
	}
}
