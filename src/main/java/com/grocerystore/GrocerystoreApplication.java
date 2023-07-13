package com.grocerystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GrocerystoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrocerystoreApplication.class, args);
	}

}
