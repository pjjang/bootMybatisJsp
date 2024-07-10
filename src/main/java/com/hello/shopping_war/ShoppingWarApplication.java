package com.hello.shopping_war;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.hello.shopping_war.repository")
public class ShoppingWarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingWarApplication.class, args);
	}

}
