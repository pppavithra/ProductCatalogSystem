package com.guvi.ProductCatalogSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.guvi.ProductCatalogSystem")

public class ProductCatalogSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogSystemApplication.class, args);
	}

}
