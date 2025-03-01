package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class FlatSellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatSellerApplication.class, args);
		System.out.println("Running");
	}

}
